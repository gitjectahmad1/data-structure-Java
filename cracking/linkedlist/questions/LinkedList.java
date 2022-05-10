package cracking.linkedlist.questions;

public class LinkedList {
	
	public Node head;
	public Node tail;
	public int size;
	
	// Create a Linked list
	public void createLL(int nodeValue) {
		
		Node newNode = new Node();
		newNode.value = nodeValue;
		newNode.next = null;
		head = newNode;
		tail = newNode;
		size++;
		
	}
	
	//Insert a Node at the end 
	public void insertNode(int nodeValue) {
		
		if(head == null) {
			createLL(nodeValue);
			return;
		}
		
		Node newNode = new Node();
		newNode.value = nodeValue;
		newNode.next = null;
		tail.next = newNode;
		tail = newNode;
		size++;
	}
	
	// Traverse Linkedlist
	public void traversalLL() {
		Node tempNode = head;
		for (int i=0; i<size; i++) {
			System.out.print(tempNode.value);
			if (i != size-1) {
				System.out.print(" -> ");
			}
			tempNode = tempNode.next;
		}
		System.out.println("\n");
	}

}
