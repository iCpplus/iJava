package aop.log.advice;
import java.util.logging.Logger;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
public class LogAdvice implements MethodInterceptor {
	public Object invoke(MethodInvocation invocation) throws Throwable {
		//目标方法调用前，调用用户登录前程序，输出日志信息
		login();
		//完成目标方法的调用，该语句是固定的
		Object object = invocation.proceed();
		//目标方法调用后，调用用户登录后程序，输出日志信息
		logout();
		return object;
	}
	// 横切关注点，用于实现日志输出功能
	private void logging(String msg) {
		Logger logger=Logger.getLogger(LogAdvice.class.getName());
		logger.info(msg);
	}
	public void login() {//调用logging方法输出用户登录前的日志信息的输出
		logging("用户登录操作执行之前的日志信息");
	}
	private void logout() {//调用logging方法输出用户登录后的日志信息的输出
		logging("用户登录操作执行之后的日志信息");
	}
}
