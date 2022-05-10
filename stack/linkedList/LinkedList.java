package stack.linkedList;

public class LinkedList {
	
	public Node head;
	public Node tail;
	// easier for transactions as everytime we add a node we increase size
	public int size;  // with this we will know how many nodes we have in our list
	
	
	// as always returns head which is a type of node 
	public Node createSingleLinkedList(int nodeValue) {
		head = new Node(); // --------------------> O(1)
		Node node = new Node(); // ---------------> O(1)
		node.next = null; //  --------------------> O(1)
		node.value = nodeValue; // ---------------> O(1)
		// referring pysical address of node 
		head = node; // --------------------------> O(1)
		tail = node; // --------------------------> O(1)
		size = 1;  // ----------------------------> O(1)
		
		return head;
	}
	
	// insert method for singlelinked linked list 	
	public void insertInLinkedList(int nodeValue, int location) {		
		// create a node 
		Node node = new Node();// |  
							   // | --------------------------> O(1)
		node.value = nodeValue;// |
		
		//  check if a linkedlist is created or not then create it
		// linkedlist does not exist
		if(head == null) {  //------------------------------------------> O(1)
			createSingleLinkedList(nodeValue); //-----------------------> O(1)
			return;
		// so insert at the beginning of the linkedlist
		} else if (location == 0) { // | assignment and if else 
			 node.next = head;      // | --------------------------------> O(1)
			 head = node;			// |
		// if the location in parameter exceeds size insert at the last	
		} else if(location >= size) { //--------------------------------> O(1)
			node.next = null; //--------------------------------> O(1)
			tail.next = node; // last node's address -----------> O(1)
			tail = node; // --------------------------------> O(1)
		} else { 
			// take the value of head 
			Node tempNode = head;  // --------------------------------> O(1)
			int index = 0;  // --------------------------------> O(1)
			 // till we reach the specified node
			while (index < location -1) { // -------------------> O(N) ############
				tempNode = tempNode.next;
				index++;  // --------------------------------> O(1)
				// tempNode hass reference after which we should insert a node	
			}
		   // storing next node's reference
			Node nextNode = tempNode.next;            //   |
			// setting new nodes's addreess to current one | 
			tempNode.next = node;					//	   |----------------> O(1)
			// new node pointing to eaarlier nextnode      | 
			node.next = nextNode; //                       |
		}
		size++; // --------------------------------> O(1)
		// Time Complexity O(N)
		// space Complexity O(1)
	}
	
	// SinglyLinkedList Traversal
	public void traverseSinglyLinkedList() {
		if(head == null) {   // -------------------------------------------> O(1)
			System.out.println("SLL does not exist");
		} else {
			Node tempNode = head; // --------------------------------------> O(1)
			for(int i=0; i<size; i++) { // --------------------------------> O(N)
				System.out.print(tempNode.value); // ----------------------> O(1)
				if(i != size - 1) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.next; //--------------------------------> O(1)
			}
		}
		System.out.println("\n");// ----------------------------------------> O(1)
		// Time Complexity O(N) , Space Complexity is O(1)
	}
	
	// search for a node 
	boolean searchNode(int nodeValue) {
		if(head != null) { // -------------------------------------------> O(1)
			// while we are looping we start from head value
			Node tempNode = head;// -------------------------------------> O(1)
			for(int i=0; i<size; i++) { // ------------------------------> O(N)
				if(tempNode.value == nodeValue) { // --------------------> O(1)
					System.out.println("Found the node at location: " + i);
					return true;
				}
				tempNode = tempNode.next; ;// ---------------------------> O(1)
			}
		}
		  System.out.println("Node not found"); // ----------------------> O(1)
		  return false;
		// Time Complexity O(N) , Space Complexity is O(1)
		}
	
	// Deleting a node from SinglyLinkedList
	public void deletionOfNode(int location) {
		if(head == null) { // -----------------------------------------------> O(1)
			System.out.println("The SLL does not exist");
			return;
			// deleting first element from the list
		} else if(location == 0) {// ----------------------------------------> O(1)
			// case 1 - having more than one element set head reference to second node 
			head = head.next;//  --------------------------------------------> O(1)
			size--;          // ---------------------------------------------> O(1)
			// case 2 - having only one element after deleting if size = 0
			if (size == 0) { // |
				tail = null; // | --------------------------------------------> O(1)
			} 	             // |
		// deleting from the end of the singlylinked list
		} else if(location >= size) { // -------------------------------------> O(1)
			// find a node before last node // two cases 1 element and more than 1 element
			Node tempNode = head;     // -------------------------------------> O(1)
			for(int i=0; i<size-1; i++) { // ---------------------------------> O(N)
				tempNode = tempNode.next; // ---------------------------------> O(1)
			} 
			// for 1 element tempnode is equal to head as checked
			if(tempNode == head) {  // |
				tail = head = null; // |
				size--;				// |--------------------------------------> O(1)
				return;				// |
			}
			// more than 1 element  in the singly linked list
			tempNode.next = null; //|
			tail = tempNode;//		|c
			size--;//				|
		} else {                     // ---------------------------------------> O(1)
			// deleting from a given location 
			Node tempNode = head;//---------------------------------------------> O(1)
			for (int i=0; i<location-1; i++) {// -------------------------------> O(N)
				tempNode = tempNode.next; //------------------------------------> O(1)
			}
			tempNode.next = tempNode.next.next;//-------------------------------> O(1)
			size--;              //---------------------------------------------> O(1)
		}
		// Time Complexity O(N) , Space Complexity is O(1)
	}
	
	// Delete Entire SinglyLinkedList
	public void deleteSLL() {
		head = null; 	  // ---------------------------------------> O(1)
		tail = null;        // ---------------------------------------> O(1)
		
		System.out.println("The SLL  is deleted successfully!"); //------> O(1)
	}
	
	// Time Complexity O(1) , Space Complexity is O(1)
	
}
