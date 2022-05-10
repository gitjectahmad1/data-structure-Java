package queue.linkedlist;

public class QueueLinkedList {

	LinkedList list;
	// creating Queue
	public QueueLinkedList() {
		
		list = new LinkedList(); //----------------------------------------> O(1)
		System.out.println("The Queue is successfully created!");//--------> O(1)
		
		//Time Complexity O(1) Space Complexity O(1)
	}
	
	
	// isEmpty
	public boolean isEmpty() {
		if(list.head == null) {  //----------------------------------------> O(1)
			return true;    //----------------------------------------> O(1)
		} else {
			return false;   //----------------------------------------> O(1)
		}
		//Time Complexity O(1) Space Complexity O(1)
	}
	
	// enQueue
	public void enQueue(int value) {
		
		list.insertInLinkedList(value, list.size); //---------------------------> O(1)
		System.out.println("Successfully inserted "+ value +" in the queue"); //-----> O(1)
		
		//Time Complexity O(1) Space Complexity O(1)
	}
	
	// deQueue
	public int deQueue() {
		int value = -1; //---------------------------> O(1)
		if(isEmpty()) { //---------------------------> O(1)
			System.out.println("The Queue is Empty");//-----------> O(1)
		} else {
			value = list.head.value; //---------------------------> O(1)
			list.deletionOfNode(0);  //---------------------------> O(1)
		}
		return value;                //---------------------------> O(1)
		//Time Complexity O(1) Space Complexity O(1)
	}
	
	// peek 
	public int peek() {
		if(isEmpty()) { //---------------------------> O(1)
			System.out.println("The Queue is Empty");//-----------> O(1)
			return -1; //---------------------------> O(1)
		} else {
			return list.head.value; //---------------------------> O(1)
		}
		//Time Complexity O(1) Space Complexity O(1)
	}
	
	// delete 
	public void delete() {
		
		list.head = null; //---------------------------> O(1)
		list.tail = null; //---------------------------> O(1)
		System.out.println("The Queue is successfully deleted!");//--------> O(1)
		
		//Time Complexity O(1) Space Complexity O(1)
	}
}
