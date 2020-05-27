package aop.advice;
import java.lang.reflect.Method;
import org.springframework.aop.MethodBeforeAdvice;
public class BeforInfo implements MethodBeforeAdvice {
	public void before(Method method, Object[] arg1, Object arg2)
			throws Throwable {
		System.out.println("Before method:"+method.getName());
	}
}
