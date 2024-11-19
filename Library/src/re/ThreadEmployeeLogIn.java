package re;


public class ThreadEmployeeLogIn implements Runnable{
	
	//log in constructors and variables
	LogMenu lm = new LogMenu();
	private String uid;
	//Constructor thats uses a string as an argument
	ThreadEmployeeLogIn(String uid){
		this.uid = uid;
	}
	@Override
	public void run() {
		//Employee login
		lm.tfUserId.setText(uid);
		lm.btnEmpLog.doClick();
	}
}

	

	
		
		
