package com.sapient.endur.ui;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 * @author Admin
 * @FunctionalInterface
 * public interface Runnable {
			void run();
   }

    @FunctionalInterface
 *  public interface Callable<V> {
		V call() throws Exception;
	}

 */
public class CallableDemo {
	private static final Integer number=5;
	public static void main(String[] args) {
		//compute factorial of given number using Runnable interface


		//		Thread t1=new Thread( ()->{
		//			long fact=1;
		//			int n=number;
		//			while(n>0) {
		//				fact=fact* n--;
		//			}
		//			System.out.println(fact);
		//		});
		//		
		//		t1.start();


		new Thread( ()->{
			long fact=1;
			int n=number;
			while(n>0) {
				fact=fact* n--;
			}
			System.out.println(fact);
		}).start();;


		//compute factorial of given number using Callable interface

		ExecutorService executorService= Executors.newSingleThreadExecutor();
		Future<Long> future= executorService.submit( ()->{
			long fact=1;
			int n=number;
			while(n>0) {
				fact=fact* n--;
			}
			return fact;
		});

		try {
				while(!future.isDone()) {
					//System.out.println("processing...");
				}

				System.out.println(future.get());
		}catch(Exception e) {
			e.printStackTrace();
		}
		executorService.shutdown();

	}

}







