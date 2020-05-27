package edu.zut.cs.software.base.service;

/**
 * 
 * @author shishuqian
 * 
 */
import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import edu.zut.cs.software.base.domain.BaseEntity;

/**
 * Generic Manager that talks to GenericDao to CRUD POJOs.
 * <p>
 * Extend this interface if you want type safe (no casting necessary) managers
 * for your domain objects.
 * </p>
 *
 * 
 * @param <T>  a type variable
 * @param <PK> the primary key for that type
 * @author <a href="mailto:ming616@gmail.com">Liu Xiaoming</a>
 */
public interface GenericManager<T extends BaseEntity<PK>, PK extends Serializable> {

	/**
	 * * delete entity according given id
	 *
	 * @param id entity id
	 */
	public void delete(PK id);

	public void deleteAll();

	/**
	 * fetch all entities
	 *
	 * @return list for all entities
	 */
	public Iterable<T> findAll();

	/**
	 * @param page pagable structure
	 * @return pagable list
	 */
	public Page<T> findAll(Pageable page);

	/**
	 * fetch specified entity according id;
	 *
	 * @param id entity id;
	 * @return entity
	 */
	public T findById(PK id);

	/**
	 * @param entities entity set to save
	 * @return Iterable entity set
	 */
	public Iterable<T> save(Iterable<T> entities);

	/**
	 * save specified entity;
	 *
	 * @param entity entity for saving
	 * @return saved domain entity
	 */
	public T save(T entity);

	public long count();
}
