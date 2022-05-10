package queue.array.circular;

public class Main {

	public static void main(String[] args) {
		CircularQueue newCQ = new CircularQueue(3);
		
		boolean result = newCQ.isEmpty();
		System.out.println(result);
		
		boolean result1 = newCQ.isFull();
		System.out.println(result1);
		
		newCQ.enQueue(10);
		newCQ.enQueue(20);
		newCQ.enQueue(30);
		
		int result2 = newCQ.deQueue();
		System.out.println(result2);
		

		int result3 = newCQ.deQueue();
		System.out.println(result3);
		
		int result4 = newCQ.peek();
		System.out.println(result4);
		
		int result5= newCQ.peek();
		System.out.println(result5);
		
		newCQ.deleteQueue();
		
	}

}
