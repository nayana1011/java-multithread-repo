package com.sapient.endur.ui;
import java.time.LocalDate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.sapient.endur.model.Person;

/**
 * 
 * @author planb
 * In a multi-threaded applications, only one thread at a time can have lock the
 * HashMap. So other threads have to wait even though they are not working on the object.
 * Note: HashMap has only one lock
 * Ex.
 * Map<Long,Person> personMap= new HashMap<>();
 * 
 * we have put some Person objects, say person1, person2, person3,person4,person5 into HashMap.
 * 
 * Suppose say thread, t1 want to work on person1, it has to acquire lock on entire HashMap, Say 
 * thread, t2 has to work on person2 but cannot do it now because t1 has lock on th eHashMap.
 * 
 * This degrades the performance.
 * 
 * Solution is use ConcurrentHashMap, here there will be 16 locks, one lock per slot.
 *  so at a time 16 threads can concurrently work on the HashMap.
 */
public class ConcurrentHashMapDemo {

	public static void main(String[] args) {
		Person[] persons= {
				new Person(879876545432L,"Ravi Kumar",
				LocalDate.of(1998, 10,15),"Hyderabad","ravi@gmail.com",8876755680L),
				new Person(779876545432L,"Avinash",
						LocalDate.of(2001, 12,1),"Chennai","avvi@gmail.com",7876761245L),
				new Person(679876545432L,"Vinod Kumar",
						LocalDate.of(1995, 5,12),"Hyderabad","vinod@gmail.com",9876767600L),
				new Person(879876545400L,"Madhavi",
						LocalDate.of(2010, 7,5),"Pune","madhavi@gmail.com",8876767685L),
				new Person(299876545432L,"Jones",
						LocalDate.of(1992, 8,10),"Mumbai","jones@gmail.com",7876767680L)
		
		
				};
		
		ConcurrentMap<Long,Person> personMap= new ConcurrentHashMap<>();
		for(int i=0;i<persons.length;i++) {
			personMap.put(persons[i].getAdharCard(), persons[i]);
		}
		
		for(Map.Entry<Long, Person>  m: personMap.entrySet()) {
			System.out.println(m.getKey() +" " + m.getValue());
		}

	}

}








