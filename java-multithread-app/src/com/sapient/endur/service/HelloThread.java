package com.sapient.endur.service;
public class HelloThread extends Thread{
	
	public HelloThread() {
		
	}
	
	public HelloThread(String threadName) {
		super(threadName);
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		System.out.println("End of "+ Thread.currentThread().getName());
	}	

}




