package re;

public class ThreadBorrowBookFromMemMenu implements Runnable {
	//log in constructors and variables
	MemberMenu m = new MemberMenu();
	private String uid;
	private String bid;
	//Constructor thats uses a string as an argument
	ThreadBorrowBookFromMemMenu(String uid, String bid){
		this.uid = uid;
		this.bid = bid;
	}
	@Override
	public void run() {
		//Employee login
		m.tfUserId.setText(uid);
		m.tfBookId.setText(bid);
		m.btnBorrowBook.doClick();
	}
}
