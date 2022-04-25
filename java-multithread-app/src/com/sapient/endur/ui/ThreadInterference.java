package com.sapient.endur.ui;
/**
 * 
 * @author Admin
 * The situation where more than one thread competes for the same resource, where 
the sequence in which the resource is accessed is significant, is called race condition.
• Without synchronization, it is possible for one thread to modify a shared resource 
while another thread is in the process of using or updating that resource. This is called 
as thread interference.
• The section of the code that leads to race conditions is called a critical section.

Since race condition results in unpredictable results, provide synchronization.
There are two ways of providing synchronization
1. Synchronized method
2. Synchronized block

Synchronized method

      public synchronized return_type methodName(<parameters>){


      }



Synchronized block
	The critical section of the program that leads to race condition can be synchronized rather that entire method
	public  return_type methodName(<parameters>){
      	-----------------------;
      	synchronized(this) {
      		-----------------------;
      		-----------------------;
      	}

      	-----------------------;

      }
 */
public class ThreadInterference {

	public static void main(String[] args) {
		//Without Synchronization

		//		StringBuilder sb= new StringBuilder("welcome");
		//		
		//		Thread t1= new Thread( ()->{
		//			int length= sb.length();
		//			for(int i=0;i<length;i++) {
		//				System.out.println( Thread.currentThread().getName() +" "+ sb.append('x'));
		//			}
		//		});
		//		
		//		
		//		Thread t2= new Thread( ()->{
		//			int length= sb.length();
		//			for(int i=0;i<length;i++) {
		//				System.out.println( Thread.currentThread().getName() +" "+ sb.append('x'));
		//			}
		//		});
		//		
		//		t1.start();
		//		t2.start();


		//With synchronization	

		StringBuilder sb= new StringBuilder("welcome");

		Thread t1= new Thread( ()->{
			int length= sb.length();
			synchronized(sb) {
				for(int i=0;i<length;i++) {
					System.out.println( Thread.currentThread().getName() +" "+ sb.append('x'));
				}
			}
		});


		Thread t2= new Thread( ()->{
			int length= sb.length();
			synchronized(sb) {
				for(int i=0;i<length;i++) {
					System.out.println( Thread.currentThread().getName() +" "+ sb.append('x'));
				}
			}
		});

		t1.start();
		t2.start();

	}

}















