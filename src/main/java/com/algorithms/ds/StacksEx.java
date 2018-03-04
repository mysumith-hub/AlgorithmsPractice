package com.algorithms.ds;

public class StacksEx {

	public static void main(String[] args) throws Exception{

		Stack stack = new Stack();
		stack.push(7);
		stack.push(4);
		stack.push(19);
		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack.peek());
		stack.pop();
	}

	
}

class Stack{
	int[] stackArray = new int[2];
	int top = -1;
	public void push(int item){
		if(top == stackArray.length-1){
			doubleArray();
		}
		stackArray[++top] = item;
	}
	
	public int pop() throws Exception{
		int item = 0;
		if(top == -1){
			throw new Exception("Stack is Empty");
		}
		stackArray[top] = 0;
		top--;
		return item;
	}
	public int peek() throws Exception{
		int item = 0;
		if(top == -1){
			throw new Exception("Stack is Empty");
		}
		item = stackArray[top];
		return item;
	}
	public void doubleArray(){
		int[] newArray = new int[stackArray.length * 2];
		System.arraycopy(stackArray, 0, newArray, 0, stackArray.length);
		stackArray = newArray;
	}
}
