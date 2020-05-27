package edu.zut.cs.software.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
/**
 * @author shishuqian
 */
public class BaseAbstractTestCase extends AbstractJUnit4SpringContextTests {
	protected Logger logger = LogManager.getLogger(BaseAbstractTestCase.class.getName());
}
