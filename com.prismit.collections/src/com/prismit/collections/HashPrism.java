package com.prismit.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashPrism{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<Integer, String>  map = new HashMap<Integer, String>();
		
		map.put(3, "Anoop");
		map.put(5, "kumar");
		map.put(8, "Sarvade");
		
		//System.out.println(map);
		
		Iterator it = map.entrySet().iterator();
		
		while(it.hasNext()) {
			Map.Entry element = (Map.Entry) it.next();
			System.out.println(element);
			
		}
	}
}