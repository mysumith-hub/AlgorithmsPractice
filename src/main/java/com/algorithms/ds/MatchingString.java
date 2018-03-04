package com.algorithms.ds;

public class MatchingString {

	public static void main(String[] args) {

		int[] chArray = new int[256];
		System.out.println((char)97);
		System.out.println((char)(97-24));
		String str = "ASsomthing";
		for(int i=0;i<str.length();i++){
			int value = str.charAt(i);
			char ch = str.charAt(i);
			
			System.out.println(value+":"+ch);
		}
	}

}
