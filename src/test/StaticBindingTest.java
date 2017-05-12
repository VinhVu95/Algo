package test;

import java.util.Collection;
import java.util.HashSet;

public class StaticBindingTest {
	public static void main(String[] args){
		Collection c = new HashSet();
		sort(c);
	}
	
	public static Collection sort(Collection c){
		System.out.println("Inside collection sort method");
		return c;
	}
	
	public static Collection sort(HashSet c){
		System.out.println("Inside hash set sort method");
		return c;
	}
}
