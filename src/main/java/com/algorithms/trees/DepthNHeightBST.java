package com.algorithms.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DepthNHeightBST {
/**
 * 		
 * 
 * @param args
 */
	
	public static void main(String args[]){
		DepthNode root = new DepthNode(20);
		System.out.println(root.test);
		DepthNode root1 = new DepthNode(20);
		root1.test = "tester";
		System.out.println(root.test);
		root.insert(25);
		root.insert(15);
		root.insert(24);
		root.insert(16);
		root.insert(10);
		root.insert(9);
		root.insert(8);
		root.insert(23);
		root.insert(22);
		root.insert(21);
//		root.BFS(root);
//		System.out.println("---- Check Depth ----");
//		root.depthOfTree(root);
//		System.out.println("---- Inorder ----");
//		root.inorderIterative(root);
		
		DepthNode binrayTree = new DepthNode(1);
		for(int i=2;i<12;i++){
			binrayTree.binaryTreeInsert(i);
		}
		System.out.println("Pre Order");
		binrayTree.preOrder();
		System.out.println();
		System.out.println("Level Order");
		ArrayList<DepthNode> nodes = new ArrayList<DepthNode>();
		nodes.add(binrayTree);
		binrayTree.printLevel(nodes);
		
	}
}
class DepthNode{
	DepthNode right;
	DepthNode left;
	static String test = "test";
	int data;
	public DepthNode(int data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "DepthNode [\n\tdata=" + data + "\n]";
	}

	/**
	 * Binary Search tree insertion
	 * @param data
	 */
	public void insert(int data){
		if(data < this.data){
			if(left == null){
				left = new DepthNode(data);
			}else{
				left.insert(data);
			}
		}else{
			if(right == null){
				right = new DepthNode(data);
			}else{
				right.insert(data);
			}
		}
	}
	/**
	 * Binary tree insertion
	 * https://www.geeksforgeeks.org/insertion-binary-tree/
	 * @param data
	 */
	public void binaryTreeInsert(int data){
		Queue<DepthNode> queue = new LinkedList<DepthNode>();
		queue.add(this);
		
		while(!queue.isEmpty()){
			DepthNode node = queue.remove();
			
			if(node.left == null){
				node.left = new DepthNode(data);
				break;
			}else{
				queue.add(node.left);
			}
			
			if(node.right == null){
				node.right = new DepthNode(data);
				break;
			}else{
				queue.add(node.right);
			}
			
		}
	}
	
	public void printLevel(ArrayList<DepthNode> nodes){
		if(nodes == null || nodes.size()==0){
			return;
		}
		ArrayList<DepthNode> newNodes = new ArrayList<DepthNode>();
		for(DepthNode bfsNode : nodes){
			System.out.print(bfsNode.data+",");
			if(null != bfsNode.left){
				newNodes.add(bfsNode.left);
			}
			if(null != bfsNode.right){
				newNodes.add(bfsNode.right);
			}
		}
		printLevel(newNodes);
	}
	
	/**
	 * BFS without recurssion.
	 * @param root
	 */
	public void BFS(DepthNode root){
		Queue<DepthNode> queue = new LinkedList<DepthNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			DepthNode node = queue.remove();
			System.out.println(node.data);
			
			if(node.left != null){
				queue.add(node.left);
			}
			if(node.right != null){
				queue.add(node.right);
			}
		}
	}
	/**
	 * Iterative Method to find Height of Binary Tree
	 * https://www.geeksforgeeks.org/iterative-method-to-find-height-of-binary-tree/
	 * @param root
	 */
	public void depthOfTree(DepthNode root){
		Queue<DepthNode> queue = new LinkedList<DepthNode>();
		queue.add(root);
		int height = 0;
		while(!queue.isEmpty()){
			
			height++;
			int counter = queue.size();
			while(counter > 0){
				DepthNode node = queue.remove();
				if(node.left != null){
					queue.add(node.left);
				}
				if(node.right != null){
					queue.add(node.right);
				}
				counter--;
			}
		}
		System.out.println("Hiight:"+height);
	}
	public void preOrder(){
		System.out.print(data+",");
		if(left != null){
			left.preOrder();
		}
		if(right != null){
			right.preOrder();
		}
	}
	/**
	 * Inorder without recursion
	 * https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
	 * @param root
	 */
	public void inorderIterative(DepthNode root){
		Stack<DepthNode> stack = new Stack<DepthNode>();
		stack.push(root);
		DepthNode current = root;
		while(!stack.isEmpty()){	
			if(null != current && current.left != null){
				push(current.left, stack);
			}
			DepthNode element = stack.pop();
			System.out.print(element.data+",");
			if(element.right != null){
				stack.push(element.right);
			}
			current = element.right;
		}
	}
	public void push(DepthNode node, Stack<DepthNode> stack){
		DepthNode current = node;
		while(current != null){
			stack.push(current);
			current = current.left;
		}
	}
	
}