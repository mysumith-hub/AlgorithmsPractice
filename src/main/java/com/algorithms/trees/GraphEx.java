package com.algorithms.trees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class GraphEx {

	LinkedList[] itemList;
	public GraphEx(int size){
		itemList = new LinkedList[size];
		for(int i=0;i<size;i++){
			itemList[i] = new LinkedList<Integer>();
		}
	}
 	public void addItem(int vertice,int edge){
 		itemList[vertice].add(edge);
	}
 	public void printItems(){
 		for(int i=0;i<itemList.length;i++){
 			System.out.println("List of "+i);
 			
 			Iterator<Integer> iterator = itemList[i].iterator();
 			while(iterator.hasNext()){
 				System.out.print(iterator.next()+",");
 			}
 			System.out.println();
 		}
 		
 	}
 	public void BFS(){
 		boolean[] visited = new boolean[itemList.length];
 		System.out.println(visited);
 		Queue<Integer> queue = new LinkedList<Integer>();
 		queue.add(0);
 		visited[0] = true;
 		System.out.print(0);
 		while(!queue.isEmpty()){
 			int item = queue.remove();
 			LinkedList<Integer> list = itemList[item];
 			Iterator<Integer> iterator = list.iterator();
 			while(iterator.hasNext()){
 				int number = iterator.next();
 				if(!visited[number]){
 					System.out.print(","+number);
 					visited[number] = true;
 					queue.add(number);
 				}
 				
 			}
 		}
 	}
 	public void DFS(int start){
 		boolean[] visited = new boolean[itemList.length];
 		System.out.print(start);
 		visited[start] = true;
 		DFSUtility(itemList[start], visited);
// 		for(LinkedList<Integer> list : itemList){
// 			DFSUtility(list, visited);
// 		}
 	}
 	
 	public void DFSUtility(LinkedList<Integer> item,boolean[] visited){
 		
 		Iterator<Integer> iterator = item.iterator();
 		
 		while(iterator.hasNext()){
 			int number = iterator.next();
 			if(!visited[number]){
 				System.out.print(","+number);
 				visited[number] = true;
 				LinkedList<Integer> node = itemList[number];
 				DFSUtility(node, visited);
 			}
 		}
 	}
 	public void DFSCycle(){
 		boolean[] visited = new boolean[itemList.length];
 		System.out.print(0);
 		visited[0] = true;
 		DFSCycleUtility(itemList[0], visited,0);	
 	}
 	public void DFSCycleUtility(LinkedList<Integer> item,boolean[] visited,int self){
 		
 		if(item.isEmpty()){
 			return;
 		}
 		Iterator<Integer> iterator = item.iterator();
 		
 		while(iterator.hasNext()){
 			int number = iterator.next();
 			if(number == self && item.getFirst() != self){
 				System.err.println("Contains Cycle:"+self);
 			}
 			if(!visited[number]){
 				System.out.print(","+number);
 				visited[number] = true;
 				LinkedList<Integer> node = itemList[number];
 				DFSCycleUtility(node, visited,number);
 			}
 		}
 	}
 	public static void main(String args[]){
 		GraphEx graphEx = new GraphEx(5);
 		graphEx.addItem(0, 2);
 		graphEx.addItem(1, 3);
 		graphEx.addItem(1, 4);
 		graphEx.addItem(0, 1);
 		graphEx.addItem(1, 2);
 		graphEx.addItem(2, 1);
 		graphEx.addItem(2, 3);
 		graphEx.addItem(2, 4);
 		
 		
// 		graphEx.printItems();
 		graphEx.BFS();
 		System.out.println("");
 		graphEx.DFS(2);
 		graphEx.addItem(0, 0);
 		System.out.println("");
 		graphEx.DFSCycle();
 	}
}
