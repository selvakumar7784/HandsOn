/**
 * 
 */
package com.java.datastructures;

import com.java.datastructures.StackImpl.StackOverFlowException;
import com.java.datastructures.StackImpl.StackUnderFlowException;

/**
 * @author Selvakumar Samuel Dhanraj
 *
 *         Nov 26, 2017
 */
public class QueueBuiltWithTwoStacks<T> {

	private StackImpl<T> forwardStack = new StackImpl<T>();
	private StackImpl<T> reverseStack = new StackImpl<T>();

	public boolean isFull() {
		return forwardStack.isFull() || reverseStack.isFull();
	}

	public boolean isEmpty() {
		return forwardStack.isEmpty() && reverseStack.isEmpty();
	}

	public void enQueue(T data) throws QueueOverFlowException {
		if (isFull())
			throw new QueueOverFlowException();
		try {
			if (forwardStack.isEmpty()) {
				while (!reverseStack.isEmpty()) {

					forwardStack.push(reverseStack.pop());
				}
			}
			forwardStack.push(data);
		} catch (StackOverFlowException | StackUnderFlowException e) {
			throw new QueueOverFlowException();
		}

	}

	public T deQueue() throws QueueUnderFlowException {

		if (isEmpty())
			throw new QueueUnderFlowException();
		try {
			if (reverseStack.isEmpty()) {
				while (!forwardStack.isEmpty()) {
					reverseStack.push(forwardStack.pop());
				}
			}
			return reverseStack.pop();
		} catch (StackOverFlowException | StackUnderFlowException e) {
			throw new QueueUnderFlowException();
		}
	}

	/**
	 * @param args
	 * @throws QueueOverFlowException 
	 * @throws QueueUnderFlowException 
	 */
	public static void main(String[] args) throws QueueOverFlowException, QueueUnderFlowException {
		QueueBuiltWithTwoStacks<String> queue = new QueueBuiltWithTwoStacks<>();
		queue.enQueue("one");
		queue.enQueue("two");
		queue.enQueue("three");
		queue.enQueue("four");
		
		System.out.println("Is Queue Full: "+queue.isFull());
		System.out.println("Head element is: "+queue.deQueue());
	}

	public static class QueueOverFlowException extends Exception {

	}

	public static class QueueUnderFlowException extends Exception {

	}
}
