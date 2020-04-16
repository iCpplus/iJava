package edu.zut.cs.software.base.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import edu.zut.cs.software.base.domain.BaseEntity;
import edu.zut.cs.software.base.service.GenericManager;

/**
 * This class serves as the Base class for all other Managers - namely to hold
 * common CRUD methods that they might all use. You should only need to extend
 * this class when your require custom CRUD logic.
 * <p/>
 * <p>
 * To register this class in your Spring context file, use the following XML.
 *
 * @param <T>  a type variable
 * @param <PK> the primary key for that type
 */

public class GenericManagerImpl<PK extends Serializable, T extends BaseEntity<PK>> implements GenericManager<PK, T> {

	Map<PK, T> entityMap = new HashMap<PK, T>();

	public void delete(PK id) {
		this.entityMap.remove(id);
	}

	public List<T> findAll() {
		List<T> all = new ArrayList<T>();
		for (Entry<PK, T> entry : this.entityMap.entrySet()) {
			all.add(entry.getValue());
		}
		return all;
	}

	public T findById(PK id) {
		return this.entityMap.get(id);
	}

	public T save(T entity) {
		return this.entityMap.put(entity.getId(), entity);
	}

}
