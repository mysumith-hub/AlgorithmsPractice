package com.algorithms.ex;

import java.math.BigInteger;

public class NumberEx {

	public static void main(String args[]){
//		int 
//		System.out.println(Math.multiplyExact(77778, 77778));
		BigInteger numberBig = new BigInteger(""+77778 * 77778);
		int n = 77778;
		long number = ((long)n*(long)n);
		String s = ""+number;
		System.out.println("S:"+s);
		System.out.println("Len:"+s.length());
		System.out.println(Math.abs(s.length()/2));
		int digits = Math.abs(s.length()/2);
		if(s.length()-digits != digits){
			digits +=1;
		}
		System.out.println("Power:"+Math.pow(10, Math.abs(s.length()/2)));
		int power = (int)Math.pow(10, digits);
//		System.out.println(number%power);
//		System.out.println(number/power);
		System.out.println(number%power+number/power);
		
	}
}
