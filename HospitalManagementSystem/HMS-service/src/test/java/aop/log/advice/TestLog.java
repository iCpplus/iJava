package aop.log.advice;

public class TestLog {
	public static void main(String[] args) {
		Login login = new LoginImpl();
		login.login();

		System.out.println(" original login finished!  Begin new login!");
		
		Login newlogin = (Login) LogProxy.bind(login);// 代理的绑定
		newlogin.login();// 执行目标方法，此时启动代理的invoke方法，该方法自动执行
	}
}