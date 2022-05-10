package stack.array;

public class Stack {

	int[] arr;
	int topOfStack;
	// creation of stack
	public Stack(int size) {
		
		this.arr = new int[size]; // ----------------------------------------------> O(1)
		this.topOfStack = -1;     // ----------------------------------------------> O(1)
		System.out.println("The Stack is created with size of: "+ size);//---------> O(1)
		
		// Time Complexity is O(1) Space Complexity is O(N)
		//-allocate n number of contigious cell in memory 
		
	}
	
	// isEmpty
	public boolean isEmpty() {
		
		if(topOfStack == -1) { // ----------------------------------------------> O(1)
			return true;       // ----------------------------------------------> O(1)
		} else {
			return false;      // ----------------------------------------------> O(1)
		}
		// Time Complexity is O(1) Space Complexity is O(1)
		// no operation about space consuming
	}
	
	// isFull
	public boolean isFull() {
		
		if (topOfStack == arr.length-1) {   // --------------------------> O(1)
		//	System.out.println("The Stack is full!");//------------------> O(1)
			return true;                   //----------------------------> O(1)
		} else {
			return false;                  //----------------------------> O(1)
		}
		// Time Complexity is O(1) Space Complexity is O(1)
		// no extra memory is required
	}
	
	// Push 
	public void push(int value) {
		
		if(isFull()) { // --------------------------------------------> O(1)
			System.out.println("The Stack is Full!");
		} else {
			arr[topOfStack+1] = value;//---------*------------------------------> O(1)
			topOfStack++;          //-------------------------------------------> O(1)
			System.out.println("The Value is successfully inserted");//---------> O(1)
		}
		// Time Complexity is O(1) Space Complexity is O(1)
		// just updating the value of array so space complexity is O(1)
	}
	
	//Pop
	public int pop() {
	
		if (isEmpty()) { // --------------------------------------------> O(1)
			System.out.println("The stack is empty!");
			return -1;
		} else {
		   int topStack = arr[topOfStack]; // --------------------------> O(1)
			topOfStack--;// --------------------------------------------> O(1)
			return topStack;// -----------------------------------------> O(1)
		}
		// Time Complexity is O(1) Space Complexity is O(1)
	}
	
	// Peek method
	public int peek() {
		if(isEmpty()) { // --------------------------------------------> O(1)
			System.out.println("The stack is empty!");// --------------> O(1)
			return -1;  // --------------------------------------------> O(1)
		} else {
			return arr[topOfStack];// ---------------------------------> O(1)
		}
		// Time Complexity is O(1) Space Complexity is O(1)
	}
	
	// Delete Method
	public void deleteStack() {
		arr = null;                // ---------------------------------> O(1)
		System.out.println("The stack is successfully deleted!"); //---> O(1)
		// Time Complexity is O(1) Space Complexity is O(1)
	}
	
}
