package com.algorithms.ex;

public class JumpingNumber {

	public static boolean isJumpingNumebr(int number){
		boolean isJumpingNumber = true;
		
		int temp = number;
		while(temp > 9){
			int i = temp % 10;
			int j = (temp /10) % 10;
			if(Math.abs(i-j) != 1){
				return false;
			}
			temp = (temp /10) % 10;
		}
		return isJumpingNumber;
	}
	public static void main(String args[]){
		int limit = 121;
		for(int i=0;i<=limit;i++){
			if(isJumpingNumebr(i)){
				System.out.print(i+",");
			}
		}
	}
	
}
