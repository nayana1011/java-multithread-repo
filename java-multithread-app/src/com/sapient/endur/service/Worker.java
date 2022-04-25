package com.sapient.endur.service;

import java.util.Collections;
import java.util.List;

public class Worker implements Runnable{
	List<Integer> list;
	
	public Worker(List<Integer> list) {
		super();
		this.list = list;
	}
	
	@Override
	public void run() {
		Collections.sort(list);
	}
}


