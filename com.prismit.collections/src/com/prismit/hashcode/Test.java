package com.prismit.hashcode;

public class Test {
	public static void main (String []args) {
		
		Employee e1 = new Employee (101, "anup", 10000);
		Employee e2 = new Employee (103, "sarvade", 20000);
		Employee e3 = new Employee (101, "anup", 10000);
		
		System.out.println(e1==e3);
		System.out.println(e2==e3);
		System.out.println(e1.equals(e2));
		System.out.println(e1.equals(e3));


		
	}

}
 