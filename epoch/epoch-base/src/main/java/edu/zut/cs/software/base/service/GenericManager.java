package edu.zut.cs.software.base.service;

import java.io.Serializable;
import java.util.List;

import edu.zut.cs.software.base.domain.BaseEntity;

/**
 * 
 * Generic manager CRUD
 * 
 * 
 * @author KouShiXiang
 *
 * @param <PK> the primary key for that type
 * @param <T>  a type variable
 */

public interface GenericManager<PK extends Serializable, T extends BaseEntity<PK>> {

	/**
	 * delete entity by id.
	 * 
	 * @param id
	 */
	public void delete(PK id);

	/**
	 * 
	 * @return a list of all entities
	 * 
	 */
	public List<T> findAll();

	/**
	 * find the entity by id.
	 * 
	 * @param id
	 * @return entity
	 */
	public T findById(PK id);

	/**
	 * save entity
	 * 
	 * @param entity
	 * @return entity which will be saved
	 */
	public T save(T entity);

//	/**
//	 * @param entities
//	 * @return
//	 */
//	public List<T> save(Iterable<T> entities);

}
