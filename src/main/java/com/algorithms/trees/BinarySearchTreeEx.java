package com.algorithms.trees;

public class BinarySearchTreeEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node root = new Node(20);
		root.insert(25);
		root.insert(15);
		root.insert(24);
		root.insert(16);
		System.out.println(root);
		System.out.println("Contains: "+root.contains(17));
		root.preOrder();
		System.out.println();
		root.inOrder();
		System.out.println();
		root.postOrder();
	}

}
class Node{
	
	int data;
	Node right;
	Node left;
	
	public Node(int data){
		this.data = data;
	}
	public void insert(int data){
		
		if(data>=this.data){
			if(right == null){
				right = new Node(data);
			}else{
				right.insert(data);
			}
		}else{
			if(left == null){
				left = new Node(data);
			}else{
				left.insert(data);
			}
		}
	}
	public boolean contains(int data){
		boolean isExist = false;
		if(this.data == data){
			isExist =  true;
		}else if(data>=this.data){
			if(right != null){
				isExist = right.contains(data);
			}
		}else{
			if(left != null){
				isExist = left.contains(data);
			}
		}
		return isExist;
	}
	public void preOrder(){
		System.out.print(data+",");
		if(null != right){
			right.preOrder();
		}
		if(null != left){
			left.preOrder();
		}
		
	}
	public void inOrder(){
		if(null != right){
			right.preOrder();
		}
		System.out.print(data+",");
		if(null != left){
			left.preOrder();
		}
		
	}
	public void postOrder(){
		if(null != right){
			right.preOrder();
		}
		if(null != left){
			left.preOrder();
		}
		System.out.print(data+",");
		
	}
	@Override
	public String toString() {
		return "Node [data=" + data + ", right=" + right + ", left=" + left + "]";
	}
}
