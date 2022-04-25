package com.sapient.endur.ui;
/**
 * 
 * @author Admin
 * Avoid creating implementation class by going for Lamdas
 */
public class RunnableWithLamda {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread());
		// using anonymous inner class
		Thread t1 = new Thread ( new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread());				
			}
			
		}, "worker-1");
		
		t1.start();
		
		System.out.println("End of "+ Thread.currentThread().getName()+" thread");
		
		//using Lamda		
		Thread t2 = new Thread( ()->{System.out.println(Thread.currentThread());},"worker-2" );
		t2.start();
	}

}







