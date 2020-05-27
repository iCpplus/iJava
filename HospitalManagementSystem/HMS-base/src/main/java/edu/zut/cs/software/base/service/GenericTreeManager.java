package edu.zut.cs.software.base.service;

/**
 * 
 * @author shishuqian
 * 
 */
import java.io.Serializable;
import java.util.List;

import edu.zut.cs.software.base.domain.BaseTreeEntity;

/**
 * Generic Manager that talks to GenericDao to CRUD POJOs. Extend this interface
 * if you want typesafe (no casting necessary) managers for your domain objects.
 *
 * @param <T>  a type variable
 * @param <PK> the primary key for that type
 * @author <a href="mailto:ming616@gmail.com">Liu Xiaoming</a>
 */
public interface GenericTreeManager<T extends BaseTreeEntity<T, PK>, PK extends Serializable>
		extends GenericManager<T, PK> {

	/**
	 * 获取制定id的全部祖先实体集合；
	 *
	 * @param id  id code for specified entity
	 * @return ancestor list
	 */
	public List<T> getAncestors(PK id);

	/**
	 * 获取制定id的直接孩子实体集合；
	 *
	 * @param id id code for specified entity
	 * @return children list
	 */
	public List<T> getChildren(PK id);

	/**
	 * 获取制定id的全部子孙实体集合；
	 *
	 * @param id id code for specified entity
	 * @return all descentants list
	 */
	public List<T> getDescendants(PK id);

	/**
	 * 获取根节点实体集合
	 *
	 * @return all roots list
	 */
	public List<T> getRoot();

}
