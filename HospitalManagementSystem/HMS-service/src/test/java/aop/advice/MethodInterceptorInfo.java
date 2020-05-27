package aop.advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
public class MethodInterceptorInfo implements MethodInterceptor {
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("MethodInterceptor Before method:"+this.getClass().getName());
		Object obj = invocation.proceed();//
		System.out.println("MethodInterceptor After method:"+this.getClass().getName());
		return obj;
	}

}
