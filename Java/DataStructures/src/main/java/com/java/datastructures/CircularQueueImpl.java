package com.java.datastructures;

import java.lang.reflect.Array;

/**
 * @author Selvakumar Samuel Dhanraj
 *
 *         Nov 25, 2017
 */
public class CircularQueueImpl<T> {

	private static final int MAX_SIZE = 40;
	private static final int SPECIAL_EMPTY_VALUE = -1;
	private int headIndex = SPECIAL_EMPTY_VALUE;
	private int tailIndex = SPECIAL_EMPTY_VALUE;
	private T[] elements;

	public CircularQueueImpl(Class<T> clazz){
		this(clazz, MAX_SIZE);
	}

    public CircularQueueImpl(Class<T> clazz, int size ){
	 elements = (T[]) Array.newInstance(clazz, MAX_SIZE);
	}

    public static class QueueOverFlowException extends Exception{
    	
    }
    public static class QueueUnderFlowException extends Exception{
    	
    }
    
    public boolean isFull(){
    	int nextIndex= (tailIndex+1)%elements.length;
    	return nextIndex==headIndex;
    }
    
    public boolean isEmpty(){
    	return headIndex==SPECIAL_EMPTY_VALUE;
    }
    public void enQueue(T data) throws QueueOverFlowException{
    	if(isFull()){
    		throw new QueueOverFlowException();
    	}
    	tailIndex= (tailIndex+1)%elements.length;
    	elements[tailIndex]=data;
    	// This is the first element enqueued, set the head index
        // to the tail index.
    	if(headIndex == SPECIAL_EMPTY_VALUE)
    		headIndex=tailIndex;
    }
    
    public T deQueue() throws QueueUnderFlowException{
    	if(isEmpty()){
    		throw new QueueUnderFlowException();
    	}
    	
    	T data=elements[headIndex];
    	
    	if(headIndex == tailIndex){
    		headIndex = SPECIAL_EMPTY_VALUE;
    	}else{
    		headIndex=(headIndex+1)%elements.length;
    	}
    	
    	return data;
    }
    
    public boolean Offer(T data){
    	if(isFull())
    		return false;
    	try{
    		enQueue(data);
    	}catch (QueueOverFlowException e){
    		//this shouldn't happen as we have checked whether queue is full already
    	}
    	
    	return true;
    }
    
    public T peek() throws QueueUnderFlowException{
    	if(isEmpty())
    		throw new QueueUnderFlowException();
    	return elements[headIndex];
    }
	/**
	 * @param args
	 * @throws QueueOverFlowException 
	 * @throws QueueUnderFlowException 
	 */
	public static void main(String[] args) throws QueueOverFlowException, QueueUnderFlowException {
		CircularQueueImpl<String> queue = new CircularQueueImpl<>(String.class,4);
		queue.enQueue("one");
		queue.enQueue("two");
		queue.enQueue("three");
		queue.enQueue("four");
		
		System.out.println("Is Queue Full: "+queue.isFull());
		System.out.println("Head element is: "+queue.peek());

	}

}
