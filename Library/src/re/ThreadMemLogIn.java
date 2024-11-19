package re;

public class ThreadMemLogIn implements Runnable{
	LogMenu lm = new LogMenu();
	private String uid;
	
	ThreadMemLogIn(String uid){
		this.uid = uid;
	}
	//log in constructors and variables
	
	
	//run method logs an employee on to the library
	
	@Override
	public void run() {
		//Employee login
		lm.tfUserId.setText(uid);
		lm.btnMemLog.doClick();
	}
}

