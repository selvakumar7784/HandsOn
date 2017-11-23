package com.java.datastructures;

class Element<T> {
	protected T data;
	protected Element<T> nextElement;

	public Element(T data, Element<T> nextElement) {
		super();
		this.data = data;
		this.nextElement = nextElement;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Element<T> getNextElement() {
		return nextElement;
	}

	public void setNextElement(Element<T> nextElement) {
		this.nextElement = nextElement;
	}

}



public class StackImpl<T> {

	private int MAX_SIZE = 40;
	private Element<T> top;
	private int size;

	public void push(T data) throws StackOverFlowException {
		if (size == MAX_SIZE)
			throw new StackOverFlowException("Stack is full");

		Element<T> newElement = null;
		
			
			newElement = new Element<T>(data, top);

		top = newElement;
		size++;
	}

	public T pop() throws StackUnderFlowException {
		if (size == 0)
			throw new StackUnderFlowException("Stack is empty");
		T data = top.getData();
		top = top.getNextElement();

		size--;
		return data;
	}

	public T peek() throws StackUnderFlowException {
		if (size == 0)
			throw new StackUnderFlowException("Stack is empty");

		else
			return top.getData();
	}

	public boolean isFull() {
		return size == MAX_SIZE;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getSize(){
		return size;
	}
	public static void main(String[] args) throws StackOverFlowException, StackUnderFlowException {
		StackImpl<Integer> stack=new StackImpl<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		System.out.println("Top element is: "+stack.peek());
		System.out.println("Stack size is: "+stack.getSize());

		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		
		System.out.println("Top element is: "+stack.peek());
		System.out.println("Stack size is: "+stack.getSize());

	}

	public static class StackOverFlowException extends Exception {

		public StackOverFlowException(String message) {
			super(message);
		}

	}

	public static class StackUnderFlowException extends Exception {
		public StackUnderFlowException(String message) {
			super(message);
		}
	}
}
