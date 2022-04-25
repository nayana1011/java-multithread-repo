package com.sapient.endur.ui;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolDemo {
	private static final int NTHREADS=10;
	public static void main(String[] args) {
		Long number=100L;
		ExecutorService executor = Executors.newFixedThreadPool(NTHREADS);
		
		//submitting 500 tasks to the Thread pool which has 10 threads
		for(int i=0;i<500;i++) {
			executor.execute(  ()->{
				Long sum=0L;
				for(long j=1;j<=number;j++) {
					sum= sum+j;
				}
				System.out.println(sum);
				
			});
			
		}
		
		executor.shutdown();
		

	}

}



