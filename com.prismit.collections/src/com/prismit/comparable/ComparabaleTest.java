package com.prismit.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparabaleTest {

	public static void main(String[] args) {

		Employee e1 = new Employee (3,"venkat");
		Employee e2 = new Employee (8, "suresh");
		Employee e3 = new Employee (1, "mahesh");
		Employee e4 = new Employee (31, "amar");
		Employee e5 = new Employee (16, "ramesh");
		Employee e7 = new Employee (13, "rajesh");
		
		List <Employee> list = new ArrayList<Employee>();
		
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		list.add(e7);
		
		Collections.sort(list);
		
		for (Employee emp:list) {
			
			System.out.println(emp);
		}
		

	}
}
