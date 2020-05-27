package aop.log.orginal;
import java.util.logging.Logger;;
public class OutPutLogging {
	
	Logger logger=Logger.getLogger(this.getClass().getName());
	
	public void doLogging() {
		beforeLogin();
		// 模拟用户登录时的操作
		login();
		afterLogin();
	}
	
	public void login() {
		logging("==========用户登录==========");
	}
	
	// 输出的日志信息
	public void logging(String msg) {
		logger.info(msg);
	}
	
	// 用户登录前输出的日志信息
	private void beforeLogin() {
		logging("用户登录操作执行之前的日志信息");
	}
	// 用户登录后输出的日志信息
	private void afterLogin() {
		logging("用户登录操作执行之后的日志信息");
	}
}
