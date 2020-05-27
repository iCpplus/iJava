package edu.zut.cs.software.base.dao;

import java.io.Serializable;

import edu.zut.cs.software.base.domain.BaseTreeEntity;

/**
 * 
 * @author shishuqian
 *
 * @param <PK>the primary key for that type 
 * @param <T>a type variable of domain entity
 * @param <M> domain manager
 */
public class GenericTreeDaoTestCase<PK extends Serializable, T extends BaseTreeEntity<T, PK>, M extends GenericTreeDao<T, PK>>
		extends GenericDaoTestCase<PK, T, M> {

	public GenericTreeDaoTestCase(Class<T> persistentClass) {
		super(persistentClass);
	}

}
