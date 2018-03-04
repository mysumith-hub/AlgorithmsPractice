package com.algorithms.string;

public class StringReverse {

	public String reverseString(String str){
		String reverseString = "";
		for(int i = str.length()-1; i>=0; i--){
			reverseString = reverseString + str.charAt(i);
		}
		
		return reverseString;
	}
	public String reverseStringWithChar(String str){
		char []chrString = str.toCharArray();
		String reverseString = "";
		for(int i = chrString.length-1; i>=0;i--){
			reverseString = reverseString + chrString[i];
		}
		return reverseString;
	}
	public String reverseStringWithTemp(String str){
		char []chrString = str.toCharArray();
		int j = chrString.length-1;
		System.out.println(chrString.length);
		for(int i = 0; i<chrString.length/2; i++){
			char temp = chrString[j];
			System.out.println(temp+":"+i+":"+j);
			chrString[j] = chrString[i];
			chrString[i] = temp;
			j --;
		}
		
		return new String(chrString);
	}
	public static void main(String args[]){
		String str = "the sky is blue";
		str = new StringReverse().reverseString(str);
		System.out.println(str);
		
		str = "the sky is blue";
		str = new StringReverse().reverseStringWithChar(str);
		System.out.println(str);
		
		str = "theskyisblue";
		
		str = new StringReverse().reverseStringWithTemp(str);
		System.out.println(str);
		
	}
}
