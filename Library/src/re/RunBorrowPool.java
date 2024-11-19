package re;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class RunBorrowPool {

	public static void main(String[] args) {
		//SingleThreadExecutor lets only one thread run at a time
		//ensures that two people can't take out the same book
		//accepts threads from Members and Employees
		ExecutorService borrowPool = Executors.newSingleThreadExecutor();
		Runnable r3 = new ThreadBorrowBookFromEmpMenu("1000", "100");
		Runnable r4 = new ThreadBorrowBookFromMemMenu("1006", "101");
		Runnable r5 = new ThreadBorrowBookFromMemMenu("1006", "100");
				
		borrowPool.submit(r3);
		borrowPool.submit(r4);
		borrowPool.submit(r5);
		
		
				
	}

}
