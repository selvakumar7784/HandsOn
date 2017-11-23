package com.java.datastructure.solutions;

import com.java.datastructures.StackImpl;
import com.java.datastructures.StackImpl.StackOverFlowException;
import com.java.datastructures.StackImpl.StackUnderFlowException;

public class MinimumInStack {
	private StackImpl<Integer> dataStack = new StackImpl<Integer>();
	private StackImpl<Integer> minStack = new StackImpl<Integer>();

	public void push(int data) throws StackOverFlowException, StackUnderFlowException {
		int min = data;
		if (!minStack.isEmpty()) {

			if (data > minStack.peek()) {

				min = minStack.peek();
			}
			
		}
		minStack.push(min);
		dataStack.push(data);
	}

	public int pop() throws StackUnderFlowException {
		minStack.pop();
		return dataStack.pop();
	}

	public int getMinimum() throws StackUnderFlowException{
		return minStack.peek();
	}
	public static void main(String[] args) throws StackOverFlowException, StackUnderFlowException {
		MinimumInStack minimumInStack = new MinimumInStack();
		minimumInStack.push(4);
		minimumInStack.push(1);
		minimumInStack.push(2);
		minimumInStack.push(3);
		System.out.println("Current minimum is : "+minimumInStack.getMinimum());
		minimumInStack.pop();
		minimumInStack.pop();
		System.out.println("Current minimum is : "+minimumInStack.getMinimum());

	}

}
