package com.algorithms.ds;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LikedListEx {

	public static void main(String[] args) {
		
		LinkedList linkedList = new LinkedList();
		linkedList.append(30);
		linkedList.print();
		linkedList.append(32);
		linkedList.print();
		linkedList.append(3);
		linkedList.print();
		linkedList.prepend(52);
		linkedList.print();
		linkedList.append(24);
		linkedList.print();
		linkedList.prepend(1);
		linkedList.print();
		linkedList.delete(30);
		linkedList.print();
		linkedList.delete(1);
		linkedList.print();
		linkedList.prepend(1);
		linkedList.print();
	}
}

class LinkedList {
	LinkNode head;

	public void append(int data) {
		if (head == null) {
			head = new LinkNode(data);
			return;
		}
		LinkNode current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new LinkNode(data);
	}

	public void insert(int data, int index) {
		if (head == null) {
			return;
		}
		if (index == 0) {
			prepend(data);
			return;
		}

	}

	public void prepend(int data) {
		LinkNode newHead = new LinkNode(data);
		newHead.next = head;
		head = newHead;
	}

	public void print() {
		if (head == null) {
			return;
		}
		LinkNode current = head;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println("");
	}

	public void delete(int data) {
		if (head == null) {
			return;
		}
		LinkNode current = head;
		if (head.data == data) {
			head = head.next;
			return;
		}
		while (current != null) {
			if (current.next.data == data) {
				current.next = current.next.next;
				return;
			}
			current = head.next;
		}
	}

	public void findDuplicatesWithBuffer() {

		LinkNode current = head;

		Set<Integer> set = new HashSet<Integer>();
		set.add(head.data);
		// map.put(key, value)
		while (current.next != null) {
			if (set.contains(current.next)) {
				current.next = current.next.next;
			}else{
				set.add(current.next.data);
			}
			current = current.next;
		}
	}
}

class LinkNode {
	LinkNode next;
	int data;

	public LinkNode(int data) {
		this.data = data;
	}
}
