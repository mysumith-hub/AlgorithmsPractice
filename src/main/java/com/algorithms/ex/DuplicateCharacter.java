package com.algorithms.ex;

public class DuplicateCharacter {
	public static void main(String args[]){
		char A = 'Z';
		char a = 'a';
		System.out.println((int)A);
		System.out.println((int)a);
		int i = 91;
		System.out.println((char)i);
//		intChar();
//		iterate();
	}
	public static void intChar(){
		boolean chars[] = new boolean[123];
		String m = "sdfzz";
		int start = -1;
		
		while(start++ < m.length()){
			if(chars[m.charAt(start)]){
				System.out.println("true");
				break;
			}
			chars[m.charAt(start)] = true;
		}
	}
	public static void iterate(){
		String m = "sdfgg";
		int start = -1;
		boolean flag = true;
		while(start++ < m.length() && flag){
			for(int i=start+1;i<m.length();i++){
				if(m.charAt(i) == m.charAt(start)){
					System.out.println("char:"+m.charAt(i));
					flag = false;
					break;
				}
			}
		}
	}
}
