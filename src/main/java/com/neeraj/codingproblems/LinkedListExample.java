package com.neeraj.codingproblems;

public class LinkedListExample {
	Node head;
}

class Node {
	int data;
	Node next;

	public Node(int data) {
		super();
		this.data = data;
		this.next = null;
	}

	public LinkedListExample insert(LinkedListExample list, int data, int position) {
		Node newNode = new Node(data);
		newNode.next = null;

		if (list.head == null) {
			list.head = newNode;
		} else {
			// find the last node
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = newNode;

		}
		return list;
	}

}