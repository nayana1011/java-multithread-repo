package com.sapient.endur.ui;

import com.sapient.endur.service.HelloThread;

public class HelloThreadDemo {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread());
		Thread t1= new HelloThread("worker-1");
		//main thread spawns worker thread and this worker thread enters into run() method
		t1.start(); // start() method implicitly invokes run() method
				
		try {
			//main thread joins worker thread i.e. main thread waits until worker thread completes its task
			t1.join();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		System.out.println("End of "+ Thread.currentThread().getName()+" thread");
	}

}


