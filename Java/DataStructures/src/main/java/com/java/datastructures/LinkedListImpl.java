package com.java.datastructures;

class Node<T extends Comparable<T>> {
	protected T data;
	protected Node<T> next;

	public Node(T data, Node<T> next) {
		super();
		this.data = data;
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

}

public class LinkedListImpl<T extends Comparable<T>> {

	private Node<T> head;
	private Node<T> tail;
	private int size;

	public int size() {
		return size;
	}

	public void insertAthead(T data) {
		if (size == 0) {
			Node<T> newNode = new Node<T>(data, null);
			head = newNode;
			tail = head;
		} else {
			Node<T> newNode = new Node<T>(data, head);
			head = newNode;
		}
		size++;
	}

	public void insertAttail(T data) {

		Node<T> newNode = new Node<T>(data, null);
		tail.setNext(newNode);
		tail = newNode;
		size++;
	}

	public void insertAtPosition(T data, int position) {
		if (position > size || position < 0) {
			System.out.println("incorrect position");
			return;
		}
		if (position == 1) {
			insertAthead(data);
			return;
		}
		if (position == size) {
			insertAttail(data);
			return;
		}

		Node<T> currentNode = head;
		for (int i = 2; i <= position - 1; i++) {
			currentNode = currentNode.next;
		}

		Node<T> newNode = new Node<T>(data, currentNode.next);
		currentNode.next = newNode;
		size++;

		System.out.println("size is: " + size);
	}

	public void deleteAtPosition(int position) {
		if (position > size || position < 0) {
			System.out.println("incorrect position");
			return;
		}
		if (position == 1) {
			head=head.next;
			return;
		}
		Node<T> currentNode = head;
		for (int i = 2; i <= position - 1; i++) {
			currentNode = currentNode.next;
		}
		
		Node<T> tobeDeleted=currentNode.next;
		currentNode.next=tobeDeleted.next;
	}

	public void display() {
		Node<T> currentNode = head;
		while (currentNode.next != null) {

			System.out.println(currentNode.data);
			currentNode = currentNode.next;

		}
		System.out.println(currentNode.data);
	}

	public static void main(String[] args) {
		LinkedListImpl<String> linkedList = new LinkedListImpl<>();
		linkedList.insertAthead("one");
		linkedList.insertAthead("two");
		linkedList.insertAthead("three");
		linkedList.insertAthead("four");
		linkedList.insertAttail("abe");
		linkedList.insertAttail("jesus");
		linkedList.insertAthead("mary");
		linkedList.insertAttail("canon");
		linkedList.insertAtPosition("test", 4);
		System.out.println("Before deletion:: ");
		linkedList.display();
		linkedList.deleteAtPosition(2);
		System.out.println("After deletion:: ");
		linkedList.display();

	}

}
