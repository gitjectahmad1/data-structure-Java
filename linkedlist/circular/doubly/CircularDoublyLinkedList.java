package linkedlist.circular.doubly;

public class CircularDoublyLinkedList {
	
	public DoublyNode head;
	public DoublyNode tail;
	public int size;
	
	// Create CDLL
	DoublyNode createCDLL(int nodeValue) {
		head = new DoublyNode(); //  ----------------------------------> O(1)
		DoublyNode newNode = new DoublyNode(); //  --------------------> O(1)
		newNode.value = nodeValue; //----------------------------------> O(1)
	    head = newNode;          //  ----------------------------------> O(1)
	    tail = newNode;          //  ----------------------------------> O(1)
	    newNode.next = newNode;  //  ----------------------------------> O(1)
	    newNode.prev = newNode;  //  ----------------------------------> O(1) 
		size = 1;                //  ----------------------------------> O(1)
		
		return head;             //  ----------------------------------> O(1)
		// Time Complexity O(1) Space Complexity O(1)
	}
	
	// Insert method
	public void insertNode(int nodeValue, int location) {
		
		DoublyNode newNode = new DoublyNode(); //  ----------------------------------> O(1)
		newNode.value = nodeValue;             //  ----------------------------------> O(1)
		
		if (head == null) {                    
			createCDLL(nodeValue);            //  ----------------------------------> O(1)
			return;
		} else if (location == 0) {           //  ----------------------------------> O(1)
			newNode.next = head;        //|
			newNode.prev = tail;        //|
			head.prev = newNode;        //|----------------------------------> O(1)
			tail.next = newNode;        //|
			head = newNode;             //|
		} else if (location >= size) {
			 newNode.next = head;       //|
			 newNode.prev = tail;       //|
			 head.prev = newNode;       //|----------------------------------> O(1)
			 tail.next = newNode;       //|
			 tail = newNode;            //|
		} else {
			DoublyNode tempNode = head; //  ----------------------------------> O(1)
			int index = 0;              //  ----------------------------------> O(1)
			
			while (index < location -1 ) {//----------------------------------> O(N)
				tempNode = tempNode.next; //----------------------------------> O(1)
				index++;		          //----------------------------------> O(1)		
			}
			newNode.prev = tempNode;      //|
			newNode.next = tempNode.next; //|----------------------------------> O(1)
			tempNode.next = newNode;      //|
			tempNode.next.prev = newNode; //|		
		}
		size++;                           //----------------------------------> O(1)
		// Time Complexity O(N) Space Complexity O(1)
	}
	
	// Traversal CDLL
	public void traverseCDLL() {
		if(head != null) {                //----------------------------------> O(1)
			DoublyNode tempNode = head;   //----------------------------------> O(1)
			for(int i=0; i<size; i++) {   //----------------------------------> O(N)
				System.out.print(tempNode.value);   //------------------------> O(1)
				if (i != size-1) {        //----------------------------------> O(1)
					System.out.print(" -> ");   //----------------------------> O(1)
				}
				tempNode = tempNode.next; //----------------------------------> O(1)
			} 
			
		} else {
			System.out.println("The CDLL does not exist.");   //--------------> O(1)
		}
		System.out.println();             //----------------------------------> O(1)
		// Time Complexity O(N) Space Complexity O(1)
	}

	// Reverse Traversal
	public void reverseTraversal() {
		
		DoublyNode tempNode = tail;         //----------------------------------> O(1)
		
		if (head != null) {                 //----------------------------------> O(1)
		for (int i=0; i<size; i++) {	    //----------------------------------> O(N)
			System.out.print(tempNode.value);//---------------------------------> O(1)
			if (i != size-1) {              //----------------------------------> O(1)
				System.out.print(" <- ");   //----------------------------------> O(1)
			}
			tempNode = tempNode.prev;       //----------------------------------> O(1)
		}
		
		} else {
			System.out.println("The CDLL does not exist.");//-------------------> O(1)
		}
		System.out.println();               //----------------------------------> O(1)
		// Time Complexity O(N) Space Complexity O(1)
	}
	
	// Search for a Node 
	public boolean searchNode(int nodeValue) {
		if (head != null) { //----------------------------------> O(1)
			DoublyNode tempNode = head; //----------------------------------> O(1)
			for (int i=0; i<size; i++) {//----------------------------------> O(N)
				if (tempNode.value == nodeValue) {//------------------------> O(1)
					System.out.println("The Node is found at location: " + i); //----------> O(1)
					return true;      
				}
				tempNode = tempNode.next;//---------------------------------> O(1)
			}
		} 
			System.out.println("The Node not found"); //--------------------> O(1)
			return false;
			// Time Complexity O(N) Space Complexity O(1)
	}
	// Deletion Method
	public void deleteNode(int location) {
		
		if (head == null) {                                //|
			System.out.println("The CDLL does not exist!");//|-------------->O(1)
			return;                                        //|
		} else if (location == 0) {
			// case -1 only one noode 
			if(size==1) {            //|
				head.prev = null;    //|
				head.next = null;    //|-------------->O(1)
				head = tail = null;  //|
				size--;              //|
				return;
				// case-2 more than one node 
			} else {
				head = head.next;    //|
				head.prev = tail;    //|-------------->O(1)
				tail.next = head;    //|
				size--;              //|
			}
		}  else if (location >= size) {
			if(size==1) {            //|
				head.prev = null;    //|
				head.next = null;    //|-------------->O(1)
				head = tail = null;  //|
				size--;              //|
				return;
				// case-2 more than one node 
			} else {
				tail = tail.prev;    //|
				tail.next = head;    //|-------------->O(1)
				head.prev = tail;    //|
				size--;
			}
		} else {
			DoublyNode tempNode = head;        //--------------------> O(1)
			for (int i=0; i< location-1; i++) {//--------------------> O(N)
				tempNode = tempNode.next;      //--------------------> O(1)
			}
			tempNode.next = tempNode.next.next;//|
			tempNode.next.prev = tempNode;     //|--------------------> O(1)
			size--;                            //|
		}
		// Time Complexity O(N) Space Complexity O(1)
	}
	
	// Delete Entire CDLL
	public void deleteCDDL() {
		
		DoublyNode tempNode = head; //---------------------------------> O(1)
		for (int i=0; i<size; i++) {//---------------------------------> O(N)
			tempNode.prev = null; 
			tempNode = tempNode.next;
		}
		head = null; //|---------------------------------> O(1)
		tail = null; //|
		System.out.println("The CDLL has been deleted!");//------------> O(1)
		// Time Complexity O(N) Space Complexity O(1)
	}

}
