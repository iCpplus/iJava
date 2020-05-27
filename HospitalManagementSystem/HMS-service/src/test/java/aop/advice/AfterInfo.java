package aop.advice;
import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;
public class AfterInfo implements AfterReturningAdvice {
	public void afterReturning(Object arg0, Method method, Object[] arg2,
			Object arg3) throws Throwable {
		System.out.println("After method:"+method.getName());
	}
}
