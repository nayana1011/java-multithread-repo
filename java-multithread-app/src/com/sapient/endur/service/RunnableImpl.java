package com.sapient.endur.service;
public class RunnableImpl implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread()); //[thread-name,priority,thread-group]
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		System.out.println("End of "+ Thread.currentThread().getName());
	}

}





