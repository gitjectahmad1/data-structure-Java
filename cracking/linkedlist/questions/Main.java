package cracking.linkedlist.questions;

public class Main {

	public static void main(String[] args) {
		
		LinkedList ll = new LinkedList();
		
		ll.createLL(1);
		
		ll.insertNode(9);
		ll.insertNode(5);
		ll.insertNode(10);
		ll.insertNode(2);
		
		ll.traversalLL();
		
		Questions q = new Questions();
		q.deleteDups(ll);
				
		Node n = q.nthToLast(ll, 2);
		System.out.println(n.value);
		
		LinkedList t = q.partitiion(ll, 4);
		t.traversalLL();
		
		LinkedList llA = new LinkedList();
		llA.insertNode(3);
		llA.insertNode(1);
		llA.insertNode(5);
		llA.insertNode(9);
		
		LinkedList llB = new LinkedList();
		llB.insertNode(2);
		llB.insertNode(4);
		llB.insertNode(6);
		
		LinkedList result = q.sumList(llA, llB);
		result.traversalLL();
		
		q.addSameNode(llA, llB, 7);
		q.addSameNode(llA, llB, 2);
		q.addSameNode(llA, llB, 1);
		
		Node inter = q.findIntersection(llA, llB);
		System.out.println(inter.value);
	}

}
