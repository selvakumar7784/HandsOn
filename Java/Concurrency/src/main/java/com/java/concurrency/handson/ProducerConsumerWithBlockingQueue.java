/**
 * 
 */
package com.java.concurrency.handson;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Selvakumar Samuel Dhanraj
 *
 *         Jan 22, 2018
 */
public class ProducerConsumerWithBlockingQueue {

	private BlockingQueue<Character> queue = new ArrayBlockingQueue<Character>(26);

	class Producer implements Runnable {

		public void run() {

			try {
				for (int i = 0; i < 26; i++) {
					char ch = (char) (i + 65);
					System.out.println("Producer: " + ch);
					queue.put(ch);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	class Consumer implements Runnable {

		public void run() {

			try {
				while (!queue.isEmpty()) {
					char ch = queue.take();
					System.out.println("Consumer: " + ch);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ProducerConsumerWithBlockingQueue main = new ProducerConsumerWithBlockingQueue();
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(main.new Producer());
		executor.execute(main.new Consumer());
		executor.shutdown();
		System.out.println("Main thread stopped..");

	}

}
