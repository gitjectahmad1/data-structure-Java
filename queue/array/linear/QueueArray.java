package queue.array.linear;

public class QueueArray {
	
	int[] arr;
	int topOfQueue;
	int beginningOfQueue;
	
	public QueueArray(int size) {
		this.arr = new int[size];
		this.topOfQueue = -1;     // ---------------------------> O(1)
		this.beginningOfQueue = -1;// --------------------------> O(1)
		System.out.println("The Queue is successfully created with size of: " + size);//----> O(1)
		
		// Time Complexity O(1) Space Complexity O(N)
	}
	
	// IsFull
	public boolean isFull() {
		if (topOfQueue == arr.length-1) { // ---------------------------> O(1)
			return true;                  // ---------------------------> O(1)
		} else {
			return false;                 // ---------------------------> O(1)
		}
		// Time Complexity O(1) Space Complexity O(1)
	}

	//IsEmpty
	public boolean isEmpty() {
		if((beginningOfQueue == -1) || (beginningOfQueue == arr.length)) {
			return true;
		} else {
			return false;
		}
		// Time Complexity O(1) Space Complexity O(1)
	}
	
	// Enqueue
	public void enQueue(int value) {
		if(isFull()) {  // ---------------------------> O(1)
			System.out.println("The Queue is Full!");//----> O(1)
		} else if(isEmpty()){ // ---------------------------> O(1)
			beginningOfQueue = 0;   //|
			topOfQueue++;           //|-----------------> O(1)
			arr[topOfQueue] = value;//|
			System.out.println("Successfully inserted " +value+" in the queue");//----> O(1)
		} else {
			topOfQueue++; // ---------------------------> O(1)
			arr[topOfQueue] = value;// ---------------------------> O(1)
			System.out.println("Successfully inserted " +value+" in the queue");//----> O(1)
		}
		// Time Complexity O(1) Space Complexity O(1)
	}
	
	// Dequeue
	public int deQueue() {
		if(isEmpty()) { // ---------------------------> O(1)
			System.out.println("The Queue is Empty!");// -------> O(1)
			return -1;  // ---------------------------> O(1)
		} else {
			int result = arr[beginningOfQueue];// ---------------------------> O(1)
			beginningOfQueue++;                // ---------------------------> O(1)
			if(beginningOfQueue > topOfQueue) {// ---------------------------> O(1)
				beginningOfQueue = topOfQueue = -1;   // -----------------------> O(1)
			}
			return result;                     // ---------------------------> O(1)
		}
		// Time Complexity O(1) Space Complexity O(1)
	}
	
	// Peek Method
	public int peek() {
		if(!isEmpty()) { // ---------------------------> O(1)
			return arr[beginningOfQueue]; // ---------------------------> O(1)
		} else {
			System.out.println("The Queue is empty!"); // ---------------------------> O(1)
			return -1;                   // ---------------------------> O(1)
		} 
		// Time Complexity O(1) Space Complexity O(1)
	}
	
	// delete
	public void deleteQueue() {
		arr = null; // ---------------------------> O(1)
		System.out.println("The Queue is successfully deleted!");// -------> O(1)
		// Time Complexity O(1) Space Complexity O(1)
	}
}
