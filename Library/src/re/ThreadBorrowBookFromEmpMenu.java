package re;

public class ThreadBorrowBookFromEmpMenu implements Runnable {
	//log in constructors and variables
	EmployeeMenu e = new EmployeeMenu();
	private String uid;
	private String bid;
	//Constructor thats uses a string as an argument
	ThreadBorrowBookFromEmpMenu(String uid, String bid){
		this.uid = uid;
		this.bid = bid;
	}
	@Override
	public void run() {
		//Employee login
		e.tfUserIDBR.setText(uid);
		e.tfBookIdBR.setText(bid);
		e.btnBorrowBook.doClick();
	}
}
