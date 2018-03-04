package com.algorithms.sortings;

/**
 * Bubble sort, also referred to as sinking sort, is a simple sorting algorithm that works by repeatedly stepping through the list to be sorted, 
 * comparing each pair of adjacent items and swapping them if they are in the wrong order. 
 * The pass through the list is repeated until no swaps are needed, which indicates that the list is sorted. 
 * The algorithm gets its name from the way smaller elements "bubble" to the top of the list. 
 * Because it only uses comparisons to operate on elements, it is a comparison sort. 
 * Although the algorithm is simple, most of the other sorting algorithms are more efficient for large lists.
 *
 * 
 * Bubble sort has worst-case and average complexity both О(n2), where n is the number of items being sorted. 
 * There exist many sorting algorithms with substantially better worst-case or average complexity of O(n log n). 
 * Even other О(n2) sorting algorithms, such as insertion sort, tend to have better performance than bubble sort. 
 * Therefore, bubble sort is not a practical sorting algorithm when n is large.
 * Performance of bubble sort over an already-sorted list (best-case) is O(n).
 * 
 *
 */
public class BubbleSort {

	public void sort(int [] elements){
		int j = 0;
		int temp = 0;
		for(int i=0;i<elements.length;i++){
			for(int k=0;k<elements.length-1;k++){
				j = k+1;
				if(elements[k] > elements[j]){
					temp = elements[j];
					elements[j] = elements[k];
					elements[k] = temp;
				}
			}	
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
		int [] elements = {6,3,2,4,1};
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sort(elements);
		
	}
}
