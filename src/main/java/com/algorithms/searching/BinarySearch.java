package com.algorithms.searching;

import java.util.Arrays;


/**
 * 
 * @author Searching
 * 
 * Serach for 5
 * 0,1,2,3,4,5,6,7,8,9,10,11,12
 * 
 * index = length/2 = 6
 * 
 * 0,1,2,3,4,5,6
 * 
 * temp = index = 6
 * index = index/2 = 3
 * 
 * index = temp - index/2 = 6 -1
 *  
 *
 *
 */
public class BinarySearch {

	public static void main(String args[]){
		
		int searchIndex = 5;
//		int array[] = {32,25,42,64,51,36};
		int array[] = {1,2,3,4,5,6,7,8,9,10,11,12};
		Arrays.sort(array);
		int index = array.length/2;
		int temp = index;
		while(true){
			
			if(array[index] == searchIndex){
				System.out.println("Search Index at: "+index);
				break;
			}else if(array[index] < searchIndex){
				index = temp - index/2; 
					
				
			}else if(array[index] > searchIndex){
				temp = index;
				index = index/2;
				
			}
			
			
			
			if(index < 0 || index > array.length-1){
				System.out.println("Not Found:"+index);
				break;
			}
		}
		
		
//		for(int i=0;i<array.length;i++){
//			System.out.println(array[i]);
//		}
	}
}
