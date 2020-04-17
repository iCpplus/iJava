package edu.zut.cs.software.base.dao;


import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import edu.zut.cs.software.base.domain.BaseEntity;

/**
 * Generic DAO (Data Access Object) with common methods to CRUD POJOs.
 * Implemented with Spring-Data Repository
 * <p>
 * Extend this interface if you want type safe (no casting necessary) DAO's for
 * your domain objects.
 *
 * @param <T>  a type variable, Entity
 * @param <PK> the primary key for that type，Entity Id
 * @author <a href="mailto:ming616@gmail.com">Liu Xiaoming</a>
 */
@NoRepositoryBean
public interface GenericDao<T extends BaseEntity<PK>, PK extends Serializable> extends PagingAndSortingRepository<T, PK> {

	List<T> findAll(Example<T> ex);
}