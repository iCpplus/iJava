package edu.zut.cs.software.base.service;

/**
 * 
 * @author FC

 * 
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.Serializable;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import edu.zut.cs.software.base.BaseAbstractTestCase;
import edu.zut.cs.software.base.domain.BaseEntity;

@ContextConfiguration(locations = { "classpath:/applicationContextTest-resources.xml",
		"classpath:/applicationContext-dao.xml", "classpath:/applicationContext-service.xml" })
public abstract class GenericManagerTestCase<PK extends Serializable, T extends BaseEntity<PK>, M extends GenericManager<T, PK>>
		extends BaseAbstractTestCase {
	protected T entity;
	protected List<T> list;
	protected M manager;

	private Class<T> persistentClass;

	public GenericManagerTestCase(final Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	@Before
	public void setUp() throws Exception {
		this.entity = this.persistentClass.getDeclaredConstructor().newInstance();
	}

	@Test
	public void testCRUD() throws Exception {
		this.manager.deleteAll();
		int num = 10;
		int expect_idx = 5;
		T expected = null;
		for (int i = 1; i <= num; i++) {
			T e = this.persistentClass.getDeclaredConstructor().newInstance();
			T saved = this.manager.save(e);
			assertNotNull(saved);
			if (i == expect_idx) {
				expected = saved;
			}
		}
		// test for findById
		T response = this.manager.findById(expected.getId());
		assertEquals(expected, response);
		// test for method count()
		long count = this.manager.count();
		assertEquals(num, count);
	}

}
