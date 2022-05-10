package linkedlist.doubly;

public class DoublyLinkedList {
	
	DoublyNode head;
	DoublyNode tail;
	int size; // make easy for traverssal, insertion, search etc 
	
	// create DoublyLinkedList	
	public DoublyNode createDLL(int nodeValue) {
		head = new DoublyNode();              //   ------------------------------> O(1)
		DoublyNode newNode = new DoublyNode();  // ------------------------------> O(1)
		newNode.value = nodeValue;  //   ------------------------------> O(1)
		 newNode.next = null;  //   ------------------------------> O(1)
		 newNode.prev = null;  //   ------------------------------> O(1)
		 head = newNode;       //   ------------------------------> O(1)
		 tail = newNode;       //   ------------------------------> O(1)
		 size = 1; // ******** //   ------------------------------> O(1)
		 
		 return head;           //   ------------------------------> O(1)
		// Time Complexity O(1) Space Complexity O(1)
	}
	
	// Insertion method
	public void insertDLL(int nodeValue, int location) {
		DoublyNode newNode = new DoublyNode(); //   ------------------------------> O(1)
		newNode.value = nodeValue;             //   ------------------------------> O(1)
		
		if (head == null) {       //   ------------------------------> O(1)
			createDLL(nodeValue); //   ------------------------------> O(1)
			return;               //   ------------------------------> O(1)
			// insert in the beginnning
		} else if (location == 0) { //|
			newNode.next = head;    //|
			newNode.prev = null;    //| ------------------------------> O(1)
			head.prev = newNode;    //|
			head = newNode;         //|
			// inserting at the last
		} else if (location >= size) { //|
			newNode.next = null;       //|
			tail.next = newNode;       //|------------------------------> O(1)
			newNode.prev = tail;       //|
			tail = newNode;            //|       
			                                      //               |prev|7|next|
		                                          // 1-> 2 -> | |3| | -> | |4| | -> 5
		} else {                        //|    
			DoublyNode tempNode = head; //|------------------------------> O(1)
			int index = 0;              //|
			while (index < location-1) { //|
				tempNode = tempNode.next;//|------------------------------> O(N)
				index++;                 //|
			}
			newNode.prev = tempNode;      //|
			newNode.next = tempNode.next; //|------------------------------> O(1)
			tempNode.next = newNode;      //|
			newNode.next.prev = newNode;  //|
		}
		size++;                           //|
		// Time Complexity O(N) Space Complexity O(1)
	}
	
	// Traverse DLL
	public void traverseDLL() {
		if (head != null) {             //------------------------------> O(1)
			DoublyNode tempNode = head; //------------------------------> O(1)
			for (int i=0; i<size; i++) {//------------------------------> O(N)
				System.out.print(tempNode.value); //------------------------------> O(1)
				if (i != size -1) {               //|
					System.out.print(" -> ");    //|------------------------------> O(1)
				}                                 //|
				tempNode = tempNode.next;        //------------------------------> O(1)
			}
		} else {                                 //------------------------------> O(1)
			System.out.println("The DLL does not exist!"); //------------------------------> O(1)
		}
		System.out.println("\n");  //------------------------------> O(1)
		// Time Complexity O(N) Space Complexity O(1)
	} 
	
	// Reverse Traversal
	public void reverseTraverseDLL() {
		if(head != null) {                       //------------------------------> O(1)
			DoublyNode tempNode = tail;          //------------------------------> O(1)
			for (int i=0; i<size; i++) {         //------------------------------> O(N)
				System.out.print(tempNode.value);//------------------------------> O(1)
				if (i != size - 1) {            
					System.out.print(" <- ");    //------------------------------> O(1)
				}
				tempNode = tempNode.prev;        //------------------------------> O(1)
			}
			
		} else {
			System.out.println("The DLL does not exist!");//---------------------> O(1) 
		}
		System.out.println("\n");                //------------------------------> O(1)
		// Time Complexity O(N) Space Complexity O(1)
	}
	
	// Search Node
	public boolean searchNode(int nodeValue) {
		if (head != null) {                            //------------------------------> O(1)
			DoublyNode tempNode = head;                //------------------------------> O(1)
			for (int i=0; i<size; i++) {               //------------------------------> O(N)
				if (tempNode.value == nodeValue) {     //------------------------------> O(1)
					System.out.println("The node is  found at location " + i);//-------> O(1)
					return true;                       //------------------------------> O(1)
				}
				tempNode = tempNode.next;              //------------------------------> O(1)
			}
		} 
			System.out.println("The node is not found! ");//---------------------------> O(1)
			return false;		                       //------------------------------> O(1)
			// Time Complexity O(N) Space Complexity O(1)
	}
	
	// Deletion Method
	public void deleteNodeDLL(int location) {
		
		if (head == null) {
			System.out.println("The DLL des not exist!");//---------------------------> O(1)
			return;
		// deleting first node
		} else if (location == 0) {  //---------------------------> O(1)
			// case 1 - only one node 
			if (size == 1) {   //|
				head = null;   //|
				tail = null;   //|---------------------------> O(1)
				size--;        //|
				return;        //|
			// case 2 - more than one node 
			} else { 	
				head = head.next;  //|
				head.prev = null;  //|---------------------------> O(1)
				size--;            //|
			} 
		 // deleting last node 
		}  else if (location >= size) {                      //|
			//temporary node which points to second last node//|---------------------> O(1)
			DoublyNode tempNode = tail.prev;                 //| 
			// case 1 - only one node 
			if (size == 1) {     //|
				head = null; 	 //|
				tail = null;     //|---------------------> O(1)
				size--;			 //|
				return;          //|
			} else {
				tempNode.next = null;    //|
				tail = tempNode;         //|---------------------> O(1)
				size--;                  //|
			}
		// Deleting from any given location 
		} else {
			DoublyNode tempNode = head;        //---------------------> O(1)
			for (int i=0; i<location-1; i++) { //---------------------> O(N)
				tempNode = tempNode.next;      //---------------------> O(1)
			}
			tempNode.next = tempNode.next.next;//|
			tempNode.next.prev = tempNode;     //|---------------------> O(1)
			size--;                            //|
		}		
		// Time Complexity O(N) Space Complexity O(1)		
	}
	
	// Delete entire DLL
	public void deleteDLL() {
		DoublyNode tempNode = head;    //------------------------------> O(1)
		for (int i=0; i<size; i++) {   //------------------------------> O(N)
			tempNode.prev = null;      //------------------------------> O(1)
			tempNode = tempNode.next;  //------------------------------> O(1)
		}
		head = null;  //------------------------------> O(1)
		tail = null;   //------------------------------> O(1)
		System.out.println("The DLL has been deleted!");  //	-----------> O(1)
		// Time Complexity O(N) Space Complexity O(1)		
	}
	
}
