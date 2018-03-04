package com.algorithms.ex;

public class NumberArrange {

	public static void arrage(int[] numbers){
		int[] postive = new int[numbers.length];
		int[] negtive = new int[numbers.length];
		int postiveIncrement = -1 ;
		int negitveIncrement = -1;
		for(int i : numbers){
			if(i >= 0){
				postive[++postiveIncrement] = i; 
			}else{
				negtive[++negitveIncrement] = i;
			}
		}
		print(postive);
		System.out.println();
		print(negtive);
		int[] arrange = new int[numbers.length];
		int increment = -1;
//		++postiveIncrement;
//		++negitveIncrement;
		while(increment < numbers.length-1){
			if(postiveIncrement !=-1){
				arrange[++increment] = postive[postiveIncrement--];
			}
			if(negitveIncrement !=-1){
				arrange[++increment] = negtive[negitveIncrement--];
			}
		}
		System.out.println();
		print(arrange);
	}
	public static void print(int[] numbers){
		for(int i : numbers){
			System.out.print(i+",");
		}
	}
	public static void main(String args[]){
		int[] numbers = {2,1,4,-4,0,-2,-3,5};
		arrage(numbers);
	}
	
}
