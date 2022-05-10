package linkedlist.circular.doubly;

public class Main {

	public static void main(String[] args) {
		
		CircularDoublyLinkedList cdll = new CircularDoublyLinkedList();
		
		cdll.createCDLL(1);
	    System.out.println(cdll.head.value);
		
		cdll.insertNode(2, 0);
		cdll.insertNode(3, 2);
		cdll.insertNode(4, 5);
		System.out.println(cdll.head.next.value);
		
		cdll.traverseCDLL();
		
		cdll.reverseTraversal();
		
		cdll.searchNode(3);
		
		cdll.deleteNode(6);
		cdll.traverseCDLL();
		
		cdll.deleteCDDL();
		cdll.traverseCDLL();
	}

}
