package linkedlist.single;

public class Main {

	public static void main(String[] args) {
		
		SinglyLinkedList sLL = new SinglyLinkedList();
		sLL.createSingleLinkedList(5);
		System.out.println(sLL.head.value);
		
		sLL.insertInLinkedList(6, 1);
		sLL.insertInLinkedList(7, 3);
		sLL.insertInLinkedList(8, 4);
		sLL.insertInLinkedList(9, 0);
		System.out.println(sLL.head.next.next.value);
		
		
		sLL.traverseSinglyLinkedList();
		
		sLL.searchNode(10);
		
		sLL.deletionOfNode(6);
		sLL.traverseSinglyLinkedList();
		
		sLL.deleteSLL();
		sLL.traverseSinglyLinkedList();
	}

}
