package edu.zut.cs.software.base.dao;



import java.io.Serializable;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.test.context.ContextConfiguration;

import edu.zut.cs.software.base.BaseAbstractTestCase;
import edu.zut.cs.software.base.dao.GenericDao;
import edu.zut.cs.software.base.domain.BaseEntity;

/**
 * 
 * @author liuxiaoming
 *
 * @param <PK>
 * @param <T>
 * @param <D>
 */
@ContextConfiguration(locations = { "classpath:/applicationContextTest-resources.xml",
		"classpath:/applicationContext-dao.xml" })
public class GenericDaoTestCase<PK extends Serializable, T extends BaseEntity<PK>, D extends GenericDao<T, PK>>
		extends BaseAbstractTestCase {
	/**
	 * Logger for this class
	 */
	protected static final Logger logger = LogManager.getLogger(GenericDaoTestCase.class.getName());

	protected D dao;

	protected T entity;

	protected PK id;

	protected List<T> list;

//	@Test
//	public void testFindAll() {
//
//		Iterable<T> result = this.dao.findAll();
//		if (logger.isInfoEnabled()) {
//			logger.info("testFindAll() - Iterable<T> result={}", result); //$NON-NLS-1$
//		}

//		if (logger.isInfoEnabled()) {
//			logger.info("testFindAll() - List<T> result={}", result); //$NON-NLS-1$
//		}

//	}

}
