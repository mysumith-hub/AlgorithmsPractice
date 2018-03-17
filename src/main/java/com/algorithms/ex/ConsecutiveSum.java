package com.algorithms.ex;

public class ConsecutiveSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int number = 101;
//		System.out.println(Math.ceil((double)number/2));
//		System.out.println(Math.floor(number/2));
//		System.out.println(Math.ceil(23.01));
		consecutiveSum(1);
	}
	
	public static void consecutiveSum(int number){
		
		
		int first = 0; 
		int end = (int)Math.ceil((double)number/2);
		while(first++ <= end){
			int sum = 0;
			String consecutive = "";
			for(int i=first;i<=end;i++){
				sum +=i;
				consecutive += i+" "; 
				if(sum == number){
					System.out.println(consecutive);
				}
			}
		}
	}
}
