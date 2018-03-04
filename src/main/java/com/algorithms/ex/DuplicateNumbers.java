package com.algorithms.ex;

public class DuplicateNumbers {

	public static void oneDuplicateNumber(int[] numbers){
		int sum = numbers.length * numbers.length-1/2;
		System.out.println(sum);
		int numberSum = 0;
		for(int i : numbers){
			numberSum +=i;
		}
		System.out.println(Math.abs(sum/numberSum));
	}
	public static void main(String[] args) {
		int[] numbers = {1,2,3,3,4,5};
		oneDuplicateNumber(numbers);

	}

}
