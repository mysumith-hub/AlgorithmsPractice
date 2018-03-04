package com.algorithms.sortings;

/**
 * The selection sort is a combination of searching and sorting. During each pass, 
 * the unsorted element with the smallest (or largest) value is moved to its proper position in the array. 
 * The number of times the sort passes through the array is one less than the number of items in the array. 
 * In the selection sort, the inner loop finds the next smallest (or largest) value and the outer loop places that value into its proper location.
 * 
 * 
 * Selection sort is not difficult to analyze compared to other sorting algorithms since none of the loops depend on the data in the array. 
 * Selecting the lowest element requires scanning all n elements (this takesn − 1 comparisons) and then swapping it into the first position. 
 * Finding the next lowest element requires scanning the remaining n − 1 elements and so on, for (n − 1) + (n − 2) + ... + 2 + 1 = n(n − 1) / 2 ∈ Θ(n2) comparisons. 
 * Each of these scans requires one swap for n − 1 elements.
 * 
 *
 */
public class SelectionSort {

	public void sort(int elements[]){
		int temp = 0;
		int index = 0;
		for(int i=0;i<elements.length;i++){
			index = i;
			for(int j=i;j<elements.length;j++){
				if(elements[index] > elements[j]){
					index = j;
				}
			}
			temp = elements[i];
			elements[i] = elements[index];
			elements[index] = temp;
			printElements(elements);
		}
	}
	public void printElements(int [] elements){
		for(int element : elements){
			System.out.print(element+",");
		}
		System.out.println("");
	}
	public static void main(String[] args){
		int [] elements = {6,3,2,4,1,100,-4,2,101};
		
		SelectionSort selectionSort = new SelectionSort();
		
		selectionSort.sort(elements);
		
	}
}
