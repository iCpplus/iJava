package aop.advice;

public class WriteInformation {
	public void writeInfo() {// 目标方法
			System.out.println("This method:" + this.getClass().getName());
	}

	
	public static void main(String[] args) {
		WriteInformation w =new  WriteInformation();
		w.writeInfo();
	}

}
