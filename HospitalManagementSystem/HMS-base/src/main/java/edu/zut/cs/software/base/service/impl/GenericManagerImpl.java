package edu.zut.cs.software.base.service.impl;

/**
 * 
 * @author shishuqian
 * 
 */
import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import edu.zut.cs.software.base.dao.GenericDao;
import edu.zut.cs.software.base.domain.BaseEntity;
import edu.zut.cs.software.base.service.GenericManager;

/**
 * <p>
 * This class serves as the Base class for all other Managers - namely to hold
 * common CRUD methods that they might all use. You should only need to extend
 * this class when your require custom CRUD logic.
 * </p>
 * 
 * To register this class in your Spring context file, use the following XML.
 *
 * @param <T>  a type variable
 * @param <PK> the primary key for that type
 */
@Transactional
public class GenericManagerImpl<T extends BaseEntity<PK>, PK extends Serializable> implements GenericManager<T, PK> {

	protected GenericDao<T, PK> dao;

	public void delete(PK id) {
		this.dao.deleteById(id);
	}

	public Iterable<T> findAll() {
		return this.dao.findAll();
	}

	public Page<T> findAll(Pageable page) {
		Page<T> result = this.dao.findAll(page);
		return result;
	}

	public T findById(PK id) {
		return this.dao.findById(id).get();
	}

	public Iterable<T> save(Iterable<T> entities) {
		return this.dao.saveAll(entities);
	}

	public T save(T entity) {
		T data = this.dao.save(entity);
		return data;
	}

	@Override
	public void deleteAll() {
		this.dao.deleteAll();
	}

	@Override
	public long count() {
		return this.dao.count();
	}

}
