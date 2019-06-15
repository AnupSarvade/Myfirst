package com.prismit.hashcode;

public class Create {

	public static void main(String[] args) {

		Employee e1 = new Employee(101,"vara", 10000);
		Employee e2 = e1;
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
		System.out.println(e1.equals(e2));
		
		Employee e3 = new Employee(101,"vara", 10000);
		Employee e4 = new Employee(101,"vara", 10000);
		
		System.out.println(e3.hashCode());
		System.out.println(e4.hashCode());


		System.out.println(e3.equals(e4));

	}

}
