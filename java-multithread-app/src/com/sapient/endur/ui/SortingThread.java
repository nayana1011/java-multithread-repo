package com.sapient.endur.ui;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.sapient.endur.service.Worker;

public class SortingThread {

	public static void main(String[] args) {
		List<Integer> myList= new ArrayList<>();
		Random random= new Random();
		for(int i=0;i<1000000;i++) {
			myList.add( Math.abs(random.nextInt()) );
		}
		//Runnbale object
		Worker worker= new Worker(myList);
		Thread t1= new Thread(worker, "worker-1");
		long start= System.currentTimeMillis();
		t1.start();
		try {
			t1.join();//main thread joins t
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		System.out.println("Time taken by worker thread to complete the task is " + 
									( System.currentTimeMillis() -start)+" milliseconds"   );
		
		
		
		System.out.println("--------------------------------------");
		
		List<Integer> myList1= new ArrayList<>();		
		for(int i=0;i<1000000;i++) {
			myList1.add( Math.abs(random.nextInt()) );
		}
		Thread t2= new Thread( ()->{Collections.sort(myList1); } ,"worker-2");
		long start1= System.currentTimeMillis();
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		System.out.println("Time taken by worker thread to complete the task is " + 
				( System.currentTimeMillis() -start1)+" milliseconds"   );
	}

}


