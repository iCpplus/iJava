package beforeAdvice;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class TestBeforeAdvice {
	public static void main(String[] args) {
		WriteInformation writeInfo = new WriteInformation();
		writeInfo.writeInfo();
		
		BeforeAdvice ba = new BeforInfo();
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(writeInfo);
		pf.addAdvice(ba);
		WriteInformation wi = (WriteInformation) pf.getProxy();
		wi.writeInfo();
	}
}
