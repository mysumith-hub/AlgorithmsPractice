package com.algorithms.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 *     	     30
 *     	20    	  35
 *   19    25  	31  37
 *           26  
 * @author yc05s3b
 *
 */
public class BreadthFirstSearch {

	public static void main(String args[]){
		BFSNode head = new BFSNode(30);
		head.addNode(20);
		head.addNode(35);
		head.addNode(25);
		head.addNode(31);
		head.addNode(19);
		head.addNode(37);
		head.addNode(26);
//		System.out.println(head);
//		head.BFSTravel();
//		
//		System.out.println();
//		System.out.println("--");
//		head.breadthSearch();
//		System.out.println();
//		System.out.println("--");
//		head.inOrder(head);
//		System.out.println();
//		System.out.println("--");
//		head.postOrder(head);
//		System.out.println();
//		System.out.println("--");
//		head.preOrder(head);
		
		head.depthOfTree(head);
	}
	
}
class BFSNode{
	int data;
	BFSNode right;
	BFSNode left;
	public BFSNode(int data) {
		this.data = data;
	}
	public void addNode(int data){
		if(data<this.data){
			if(left == null){
				left = new BFSNode(data);
			}else{
				left.addNode(data);
			}
		}
		if(data>this.data){
			if(right == null){
				right = new BFSNode(data);
			}else{
				right.addNode(data);
			}
		}
	}
	public void BFSTravel(){
		ArrayList<BFSNode> nodes = new ArrayList<BFSNode>();
		nodes.add(this);
//		nodes.add(right);
		printLevel(nodes);
	}
	public void printLevel(ArrayList<BFSNode> nodes){
		if(nodes == null || nodes.size()==0){
			return;
		}
		ArrayList<BFSNode> newNodes = new ArrayList<BFSNode>();
		for(BFSNode bfsNode : nodes){
			System.out.print(","+bfsNode.data);
			if(null != bfsNode.left){
				newNodes.add(bfsNode.left);
			}
			if(null != bfsNode.right){
				newNodes.add(bfsNode.right);
			}
		}
		printLevel(newNodes);
	}
	public void breadthSearch(){
		Queue<BFSNode> queue = new LinkedList<BFSNode>();
		queue.add(this);
		while(!queue.isEmpty()){
			BFSNode node = queue.remove();
			System.out.print(","+node.data);
			if(null != node.left){
				queue.add(node.left);
			}
			if(null != node.right){
				queue.add(node.right);
			}
		}
	}
	public void inOrder(BFSNode bfsNode){
		
		if(bfsNode.left != null){
			inOrder(bfsNode.left);
		}
		System.out.print(","+bfsNode.data);
		if(bfsNode.right != null){
			inOrder(bfsNode.right);
		}
	}
	public void inOrderNoRecurrsion(BFSNode bfsNode){
		BFSNode current = bfsNode;
		while(current != null){
			
		}
	}
	
	public void preOrder(BFSNode bfsNode){
		System.out.print(","+bfsNode.data);
		if(null != bfsNode.left){
			preOrder(bfsNode.left);
		}
		if(null != bfsNode.right){
			preOrder(bfsNode.right);
		}
	}
	public void postOrder(BFSNode bfsNode){
		if(null != bfsNode.left){
			postOrder(bfsNode.left);
		}
		if(null != bfsNode.right){
			postOrder(bfsNode.right);
		}
		System.out.print(","+bfsNode.data);
	}
	/**
	 *     	     30
	 *     	20    	  35
	 *   19    25  	31  37
	 *          26  
	 * @author yc05s3b
	 *
	 */
	public void leftDepth(BFSNode bfsNode, int left, int right){
		if(bfsNode.left != null){
			
		}
		
		if(bfsNode.right != null){
			
			
		}
		
		
		
	}
	public void depthOfTree(BFSNode bfsNode){
		int depth = 1;
//		leftDepth(bfsNode, depth);
		System.out.println(depth);
	}
	@Override
	public String toString() {
		return "BFSNode [\n\tdata=" + data + ", \n\t\tright=" + right + ", \n\t\tleft=" + left + "\n]";
	}
}
