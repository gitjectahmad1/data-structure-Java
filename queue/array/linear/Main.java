package queue.array.linear;

public class Main {

	public static void main(String[] args) {
		
		QueueArray newQueue = new QueueArray(3);
		
		boolean result = newQueue.isFull();
		System.out.println(result);
		
		boolean result1 = newQueue.isEmpty();
		System.out.println(result1);
		
		newQueue.enQueue(1);
		newQueue.enQueue(2);
		newQueue.enQueue(3);
	
		int result2 = newQueue.deQueue();
		System.out.println(result2);
		
		int result3 = newQueue.deQueue();
		System.out.println(result3);
		
		int result4 = newQueue.peek();
		System.out.println(result4);
		
		int result5 = newQueue.peek();
		System.out.println(result5);
		
		newQueue.deleteQueue();
		
	}

}
