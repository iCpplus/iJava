package edu.zut.cs.software.base.dao;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.Serializable;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import edu.zut.cs.software.base.BaseAbstractTestCase;
import edu.zut.cs.software.base.domain.BaseEntity;

/**
 * 
 * @author shishuqian
 *
 * @param <PK> primary key
 * @param <T> 	domin entity
 * @param <D> domain mananger
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

	private Class<T> persistentClass;

	public GenericDaoTestCase(final Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	@Before
	public void setUp() throws Exception {
		this.entity = this.persistentClass.getDeclaredConstructor().newInstance();
	}

	@Test
	public void testCRUD() throws Exception {
		this.dao.deleteAll();
		int num = 10;
		int expect_idx = 5;
		T expected = null;
		for (int i = 1; i <= num; i++) {
			T e = this.persistentClass.getDeclaredConstructor().newInstance();
			T saved = this.dao.save(e);
			assertNotNull(saved);
			if (i == expect_idx) {
				expected = saved;
			}
		}

		// test for findById
		T response = this.dao.findById(expected.getId()).get();
		assertEquals(expected, response);
		// test for method count()
		long count = this.dao.count();
		assertEquals(num, count);
	}

}
