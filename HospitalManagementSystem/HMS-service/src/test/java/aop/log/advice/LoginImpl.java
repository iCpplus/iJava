package aop.log.advice;
import java.util.logging.Logger;
public class LoginImpl implements Login{
	Logger logger=Logger.getLogger(LogAdvice.class.getName());
	
	public void login() {
		logger.info("==========管理员登录==========");	
	}
}