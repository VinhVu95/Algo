package test;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {
	public static void main(String[] args){
		List<Integer> sharedQueue = new ArrayList<Integer>();
		Thread P = new Thread(new Producer(sharedQueue,4));
		Thread C = new Thread(new Consumer(sharedQueue,4));
		P.start();
		C.start();
	}
	
	public static class Producer implements Runnable{
		List<Integer> queue;
		int size;
		
		public Producer(List<Integer> queue,int size){
			this.queue = queue;
			this.size = size;
		}
		
		public void produce(int i) throws InterruptedException{
			synchronized(queue){
				while(queue.size() == size){
					System.out.println(Thread.currentThread() + " is waiting for next empty slot to produce");
					queue.wait();
				}
//			}
//			synchronized(queue){
				queue.add(i);
				System.out.println("Producing item" + i);
				queue.notifyAll();
			}	
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
			for(int j = 0; j < 8; j++)
				
					produce(j);
			
			} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		
		}
	}
	
	public static class Consumer implements Runnable{
		List<Integer> queue;
		int size;
		
		public Consumer(List queue, int size){
			this.queue = queue;
			this.size = size;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try{
				while(true){
					consume();
					//Thread.sleep(50);
				}
				
				
			} catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
		public void consume() throws InterruptedException{
			synchronized(queue){
				while(queue.isEmpty()){
					System.out.println(Thread.currentThread() + " is waiting for next available items to consume");
					queue.wait();
				}
//			}
//			synchronized(queue){
				int c = queue.remove(0);
				System.out.println("Consuming item" + c);
				queue.notifyAll();
			}
		}
		
	}
}
