package queue.array.circular;

public class CircularQueue {
	
	int[] arr;
	int topOfQueue;
	int beginningOfQueue;
	int size;
	
	// create CQ
	public CircularQueue(int size) {
		this.arr = new int[size];  //--------------------------------> O(1)
		this.size = size;          //--------------------------------> O(1)
		this.topOfQueue = -1;      //--------------------------------> O(1)
		this.beginningOfQueue = -1;//--------------------------------> O(1)
		System.out.println("The CQ is successfuly created with size of "+ size);//----> O(1)
		
		// Time Complexity O(1) Space Complexity O(N)
	}
	
	// isEmpty
	public boolean isEmpty() {
		if (topOfQueue == -1) { //--------------------------------> O(1)
			return true;        //--------------------------------> O(1) 
		} else {
			return false;       //--------------------------------> O(1)
		}
		// Time Complexity O(1) Space Complexity O(1)
	}
	
	// isFull
	public boolean isFull() {
		if(topOfQueue+1 == beginningOfQueue) { //--------------------------------> O(1)
			return true; //--------------------------------> O(1)
		} else if (beginningOfQueue==0 && topOfQueue+1==size) {//-----------------> O(1)
			return true; //--------------------------------> O(1)
		} else {
			return false;//--------------------------------> O(1)
		}
		// Time Complexity O(1) Space Complexity O(1)
	}
	
	// enQueue
	public void enQueue(int value) {
		if(isFull()) { //--------------------------------> O(1)
			System.out.println("The CQ is full!");//--------------------------------> O(1)
		} else if(isEmpty()) { //--------------------------------> O(1)
			beginningOfQueue = 0; 	//--------------------------------> O(1)
			topOfQueue++;           //--------------------------------> O(1)
			arr[topOfQueue] = value;//--------------------------------> O(1)
			System.out.println("Successfully inserted "+ value+" in the queue");// ----> O(1)
		} else {
			// insert at the begiining empty cells
			if(topOfQueue+1 == size) {//--------------------------------> O(1)
				topOfQueue = 0;   //--------------------------------> O(1)
			} else {
				topOfQueue++;    //--------------------------------> O(1)
			}
			arr[topOfQueue] = value; //--------------------------------> O(1)
			System.out.println("Successfully inserted "+  value +" in the queue");// ----> O(1)
			
		}
		// Time Complexity O(1) Space Complexity O(1)
	}
	
	//deQueue
	public int deQueue() {
		if(isEmpty()) { //--------------------------------> O(1)
			System.out.println("The CQ is empty!");//--------------------------------> O(1)
			return -1; //--------------------------------> O(1)
		} else {
			int result = arr[beginningOfQueue];//--------------------------------> O(1)
			arr[beginningOfQueue] = 0; //--------------------------------> O(1)
			// only one element check condition
			if(beginningOfQueue == topOfQueue) {   //--------------------------------> O(1)
				beginningOfQueue = topOfQueue = -1;//--------------------------------> O(1)
			} else if(beginningOfQueue+1 == size) {//--------------------------------> O(1)
				 beginningOfQueue = 0;             //--------------------------------> O(1)
			} else {
				beginningOfQueue++;                //--------------------------------> O(1)
			}
			return result;                         //--------------------------------> O(1)
		}
		// Time Complexity O(1) Space Complexity O(1)
	}
	
	// peek 
	public int peek() {
		if(isEmpty()) {  //--------------------------------> O(1)
			System.out.println("The CQ is empty!"); //--------------------------------> O(1)
			return -1;  //--------------------------------> O(1)
		} else {
			return arr[beginningOfQueue];  //--------------------------------> O(1)
		}
		// Time Complexity O(1) Space Complexity O(1)
	}
	
	// deleteQueue
	public void deleteQueue() {
		
		arr = null; //--------------------------------> O(1)
		System.out.println("The CQ successfully deleted!");//-----------------> O(1)
		
		// Time Complexity O(1) Space Complexity O(1)
	}

}
