package re;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunLogInMemPool {
	//class the runs the threads.
	//has three different Executor Services that run specific threads
	
	public static void main(String[] args) {
		//SingleThreadExecutor lets only one thread run at a time
		//Ensures that only one Employee can log on at the sane time
		ExecutorService logInEmpPool = Executors.newSingleThreadExecutor(); 
		Runnable r1 = new ThreadMemLogIn("1006");
		Runnable r2 = new ThreadMemLogIn("1008");
		
		logInEmpPool.execute(r1);
		logInEmpPool.execute(r2);
		}

}
