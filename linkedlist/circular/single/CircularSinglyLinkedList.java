package linkedlist.circular.single;

public class CircularSinglyLinkedList {
	
	public Node head;
	public Node tail;
	public int size;
	
	// create circularSingleLinked List only one element 
	public Node createCSLL(int nodeValue) {
		head = new Node(); // -------------------------------> O(1)
		Node node = new Node();// ---------------------------> O(1)
		node.value = nodeValue; //|
		node.next = node; //      |
		head = node; // 		  |--------------------------> O(1)
		tail = node; //			  |
		size = 1;  //			  |
	
		return head; //  ------------------------------------> O(1)
		// Space Complexity is also O(1) creating only one node and consists of only one node 
		// Time Complexity O(1)
	}
    //Insertion 
	public void insertCSLL(int nodeValue, int location) {
		
		Node node = new Node(); // -------------------------------> O(1)
		node.value = nodeValue; // -------------------------------> O(1)
		
		if (head == null) {        // |
			createCSLL(nodeValue); // |---------------------------> O(1)
			return;                // |
			// inserting in the beginning 
		} else if (location == 0) { // ---------------------------> O(1)
			node.next = head;      // |
			head = node;		   // |---------------------------> O(1)
			tail.next = head;      // | 
			// inserting at the end 
		} else if (location >= size) {  // -----------------------> O(1)
			tail.next = node;     // |
			tail = node;          // |----------------------------> O(1)
			tail.next = head;     // |
			
		} else {
			Node tempNode = head;  // ----------------------------> O(1)
			int index = 0;          // ---------------------------> O(1)
			while (index < location - 1) { // --------------------> O(N)
				tempNode = tempNode.next;  // --------------------> O(1)
				index++;   // ------------------------------------> O(1)
			}
			node.next = tempNode.next;  // -----------------------> O(1)
			tempNode.next = node;  // ----------------------------> O(1)
		}
		size++;
		// Time Complexity O(N) Space Complexity O(1)
	}
	
	// Traversal method
	public void traverseCSLL() {
		if (head != null) {       // -------------------------------> O(1)
			Node tempNode = head; // -------------------------------> O(1)
			for (int i=0; i<size; i++) {// -------------------------> O(N)
				System.out.print(tempNode.value);// ----------------> O(1)
				if (i != size -1 ) { // ----------------------------> O(1)
					System.out.print(" -> "); // -------------------> O(1)
				}
				tempNode = tempNode.next; // -----------------------> O(1)
			}
			System.out.println("\n"); // ---------------------------> O(1)
		} else {
			System.out.println("\nCSLL does not exist!");  //-------> O(1)
		}
		// Time Complexity O(N) Space Complexity O(1)
	}
	
	// Search method
	public boolean searchNode(int nodeValue) {
		if (head != null) {              // -------------------------------> O(1)
			Node tempNode = head;        // -------------------------------> O(1)
			for(int i=0; i<size; i++) {  // -------------------------------> O(N )
				if(tempNode.value == nodeValue) { //                    |
					System.out.println("Found Node at location: " + i);// |--> O(1)
					return true;   //                                   |
				}
				tempNode = tempNode.next; // ------------------------------> O(1)
			}
		}
		System.out.println("Node not found!");  // ------------------------> O(1)
		return false;                    // -------------------------------> O(1)
		// Time Complexity O(N) Space Complexity O(1)
	}
	
	// delete method 
	public void deleteNode(int location) {
		if(head == null) {                                  //|
			System.out.println("The CSLL des not exist! "); //|-------------------------> O(1)
			return;											//|
		} else if (location == 0) {
			// more than 1 element
			head = head.next;                               //|
			tail.next = head;                               //|-------------------------> O(1)
			size--;                                         //|
			// only 1 element
			if(size == 0) {
				tail = null;                                //|
				head.next = null;                           //|-------------------------> O(1)
				head = null;                                //|
			}
		} else if (location >= size) {
			Node tempNode = head; // ------------------------------> O(1)
			for (int i=0; i<size-1; i++) { //|---------------------> O(N)
				tempNode = tempNode.next;  //|
			}
			if (tempNode == head) {//|
				head.next = null;  //|
				tail = head = null;//|------------------------------> O(1)
				size--;            //|
				return;            //|
			}
			tempNode.next = head; //|
			tail = tempNode;      //|------------------------------> O(1)
			size--;               //|
		} else {
			Node tempNode = head;  // ------------------------------> O(1)
			for (int i=0; i < location -1; i++) { //|
				tempNode = tempNode.next;         //|--------------> O(N)
			}                                     //|
			tempNode.next = tempNode.next.next; // ----------------> O(1)
			size--; // ------------------------------> O(1)
		}
		// Time Complexity O(N) Space Complexity O(1)
	}
	
	// Delete CSLL
	public void deleteCSLL() {
		if (head == null) {            // ------------------------------> O(1)
			System.out.println("The CSLL does not exist! ");//----------> O(1)
		} else {
			head = null;        //|
			tail.next = null;   //| ------------------------------------> O(1)
			tail = null;        //|
			System.out.println("The CSSL has been deleted!");//----------> O(1)
		}
		
	}
	
}
