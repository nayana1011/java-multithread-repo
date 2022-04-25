package com.sapient.endur.ui;
import com.sapient.endur.service.RunnableImpl;

public class ThreadDemo1 {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread());
		//create Runnable object
		Runnable runnable= new RunnableImpl();
		//create thread object, bind the Runnabale object to thread object
		//by passing the Runnable object to Thread class constructor
		Thread t1= new Thread(runnable,"worker-1");
		Thread t2= new Thread(runnable,"worker-2");
		//start() method of Thread class will spawn worker thread then the worker thread
		// enters into run() method.		
		//After spawning worker thread, main thread will continue executing the remaining 
		// statements of main() method
		t1.start();
		t2.start();
		//main thread goes to non-runnable state and will come back to Runnable state after elapsed time
		//		try {
		//			Thread.sleep(1000);
		//		} catch (InterruptedException e) {			
		//			e.printStackTrace();
		//		}

		//we want main thread to pause(non-runnable state) until worker threads come out of run() method
		//join me i.e. t1 & t2 threads are informing the main thread to join me
		try {
			t1.join();
			t2.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("End of the main method");

	}

}









