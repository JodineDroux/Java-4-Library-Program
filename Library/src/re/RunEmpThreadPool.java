package re;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunEmpThreadPool {

	public static void main(String[] args) {
		//Cache thread pool that creates a new thread if one is not available
		//Any method that is called by an Employee Thread will come here to run
		//Ensure that only one Employee can alter the log in and alter the database
		//To avoid any database discrepancies
		ExecutorService MemLogOnCache = Executors.newCachedThreadPool();
		Runnable r6 = new ThreadEmployeeLogIn("1000");
		Runnable r7 = new ThreadEmployeeLogIn("1001");
		Runnable r8 = new ThreadEmployeeLogIn("1002");
		
		MemLogOnCache.execute(r6);
		MemLogOnCache.execute(r7);
		MemLogOnCache.execute(r8);

	}

}
