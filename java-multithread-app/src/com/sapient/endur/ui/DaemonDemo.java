package com.sapient.endur.ui;
/**
 * 
 * @author Admin
 * when main thread is terminated then the daemon threads also are terminated
 * Note: The life of worker thread is not based on main thread
 */
public class DaemonDemo {

	public static void main(String[] args) {
		Thread t1= new Thread(  ()->{
			System.out.println(Thread.currentThread());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
			System.out.println("End of "+ Thread.currentThread().getName());
		}, "worker-1");

	
		Thread t2= new Thread(  ()->{
			System.out.println(Thread.currentThread());
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
			System.out.println("End of "+ Thread.currentThread().getName());
		}, "worker-2");
		
		//converting worker threads to daemon threads
		t1.setDaemon(true);
		t2.setDaemon(true);
		
		
		t1.start();
		t2.start();
		
		
		
		System.out.println("End of main thread");
	}
	
	

}



