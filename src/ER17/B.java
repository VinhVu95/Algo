package ER17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		int m = scan.nextInt();
		List<Mouse> mouses = new ArrayList<B.Mouse>(); 
		for(int i = 0; i < m ;i++){
			int p = scan.nextInt();
			String s = scan.next();
			scan.nextLine();
			boolean isUSB = s.trim().equals("USB")? true: false;
			mouses.add(new Mouse(p,isUSB));
		}
		Collections.sort(mouses);
		//for(Mouse mo : mouses) System.out.println(mo.price);
		int equiped = 0;
		long prices = 0;
		for(int i = 0; i < mouses.size(); i++){
			if(mouses.get(i).isUSB && a > 0) {equiped++; prices += mouses.get(i).price; a--;}
			else if(!mouses.get(i).isUSB && b > 0) {equiped++; prices += mouses.get(i).price; b--;}
			else if(c > 0){equiped++; prices += mouses.get(i).price; c--;}
		}
		System.out.println(equiped + " " + prices);
	}
	
	public static class Mouse implements Comparable<Mouse>{
		int price;
		boolean isUSB;
		public Mouse(int price, boolean isUSB){
			this.price = price;
			this.isUSB = isUSB;
		}
		@Override
		public int compareTo(Mouse o) {
			// TODO Auto-generated method stub
			return this.price - o.price;
		}
	}
}
