package aop.log.advice;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Logger;
public class LogProxy implements InvocationHandler {
	private Object proxyObj;
	public LogProxy(Object obj) {
		this.proxyObj = obj;
	}
	// 创建代理对象，绑定代理对象
	public static Object bind(Object obj) {
		Class<?> cls = obj.getClass();
		return Proxy.newProxyInstance(cls.getClassLoader(),
				cls.getInterfaces(), new LogProxy(obj));
	}
	/*
	 * 只有一个切入点，对所有对象的方法都进行调用， 
	 * 本例中只有login一个业务逻辑方法用于模拟用户登录操作，
	 * 在调用login方法的前后，执行日志输出操作。
	 */
	//invoke方法所有的Java动态代理程序所必有的程序，该程序会自动被执行
	public Object invoke(Object Proxy, Method method, Object args[])
			throws Throwable {
		//目标方法调用前，调用用户登录前程序，输出日志信息
		beforeLogin();
		//完成目标方法的调用，该语句是固定的
		Object object = method.invoke(proxyObj, args);
		//目标方法调用后，调用用户登录后程序，输出日志信息
		afterLogin();
		
		return object;
	}
	// 横切关注点，用于实现日志输出功能
	private void logging(String msg) {
		Logger logger=Logger.getLogger(LogProxy.class.getName());
		logger.info(msg);
	}
	private void beforeLogin() {//调用logging方法输出用户登录前的日志信息的输出
		logging("用户登录操作执行之前的日志信息");
	}
	private void afterLogin() {//调用logging方法输出用户登录后的日志信息的输出
		logging("用户登录操作执行之后的日志信息");
	}
}
