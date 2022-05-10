package tree.binary.linkedlist;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLL {
	
	BinaryNode root;
	
	public BinaryTreeLL() {
		this.root = null; //---------------> O(1)
	// Time Complexity O(1) Space Complexity O(1)	
	}
	
	// Preorder Traversal
	void preOrder(BinaryNode node) {
		
		if(node == null) { //---------------> O(1)
			return;        //---------------> O(1)
		}
		System.out.print(node.value + " "); //---------------> O(1)
		preOrder(node.left);   //---------------> O(N/2)
		preOrder(node.right); //---------------> O(N/2)
	//Time Complexity O(N)->recursive Space Complexity O(N)->inserting nodes in stack memory
	}
	
	// InOrder traversal
	void inOrder(BinaryNode node) {
		// base condition
		if(node == null) { //---------------> O(1) 
			return;        //---------------> O(1)
		}
		inOrder(node.left);  //---------------> O(N/2) for two children
		System.out.print(node.value + " "); //---------------> O(1) 
		inOrder(node.right);//---------------> O(N/2) for two children
	//Time Complexity O(N)->recursive Space Complexity O(N)->inserting nodes in stack memory	
	}
	
	// PostOrder traversal
	void postOrder(BinaryNode node) {
		
		if(node == null) { //---------------> O(1) 
			return;        //---------------> O(1) 
		}
		postOrder(node.left);//---------------> O(N/2) for two children
		postOrder(node.right);//---------------> O(N/2) for two children
		System.out.print(node.value + " ");//---------------> O(1) 
	//Time Complexity O(N)->recursive Space Complexity O(N)->inserting nodes in stack memory
	}
	
	// Level Order
 public	void levelOrder() {
		
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();//---------------> O(1) 
		queue.add(root); //---------------> O(1) 
		while (!queue.isEmpty()) { //---------------> O(N) 
			BinaryNode presentNode = queue.remove(); //---------------> O(1) 
			System.out.print(presentNode.value + " "); //---------------> O(1) 
			if(presentNode.left != null) { //---------------> O(1) 
				queue.add(presentNode.left); //---------------> O(1) 
			}
			if(presentNode.right != null) { //---------------> O(1) 
				queue.add(presentNode.right);//---------------> O(1) 
			}
		}
	//Time Complexity O(N)->recursive Space Complexity O(N)->inserting nodes in stack memory
	}
	
	// Search Method
	public void search(String value) {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>(); //---------------> O(1) 
		queue.add(root); //---------------> O(1) 
		while (!queue.isEmpty()) { //---------------> O(N) 
			BinaryNode presentNode = queue.remove(); //---------------> O(1) 
			if(presentNode.value == value) { //---------------> O(1) 
				System.out.print("The value-"+value+" is found in Tree");//---------------> O(1) 
				return; //---------------> O(1) 
			} else {
				if(presentNode.left != null) {//---------------> O(1) 
					queue.add(presentNode.left);//---------------> O(1) 
				}
				if(presentNode.right != null) { //---------------> O(1) 
					queue.add(presentNode.right);//---------------> O(1) 
				}
			}
		}
		System.out.println("The value-"+value+" is not found in Tree");//---------------> O(1)
	//Time Complexity O(N)->recursive Space Complexity O(N)->inserting nodes in stack memory
	}
	
	// Insert method
	public void insert(String value) {
		//case-1: root node is null
		BinaryNode newNode = new BinaryNode(); //---------------> O(1) 
		newNode.value = value; //---------------> O(1) 
		if(root == null) {  //---------------> O(1) 
			root = newNode; //---------------> O(1) 
			System.out.println("Inserted new node at Root");//---------------> O(1) 
			return; //---------------> O(1) 
		}
		//case-2: search for vacant place using queue
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();//---------------> O(1) 
		queue.add(root); //---------------> O(1) 
		while(!queue.isEmpty()) { //---------------> O(N) 
			BinaryNode presentNode = queue.remove(); //---------------> O(1) 
			if(presentNode.left == null) {//---------------> O(1) 
				presentNode.left = newNode; //---------------> O(1) 
				System.out.println("Successfully inserted");//---------------> O(1) 
				break; //---------------> O(1)  
			} else if (presentNode.right == null) {//---------------> O(1) 
				presentNode.right = newNode; //---------------> O(1) 
				System.out.println("Successfully inserted");//---------------> O(1) 
				break; //---------------> O(1) 
			} else {
				queue.add(presentNode.left); //---------------> O(1) 
				queue.add(presentNode.right);//---------------> O(1) 
			}
		}
	//Time Complexity O(N)->recursive Space Complexity O(N)->inserting nodes in stack memory
	}
	
	// get Deepest Node
	public BinaryNode getDeepestNode() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		BinaryNode presentNode = null;;
		while(!queue.isEmpty()) {
			presentNode = queue.remove();
			if(presentNode.left !=null) {
				queue.add(presentNode.left);
			}
			if(presentNode.right !=null) {
				queue.add(presentNode.right);
			}
		}
		return presentNode;
	}
	
	// Delete Deepest Node
	public void deleteDeepestNode() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		BinaryNode previousNode, presentNode = null;
		while(!queue.isEmpty()) {
			previousNode = presentNode;
			presentNode = queue.remove();
			
			if(presentNode.left == null) {
				previousNode.right = null;
				return;
			} else if(presentNode.right == null) {
				presentNode.left = null;
				return;
			}
			queue.add(presentNode.left);
			queue.add(presentNode.right);
			
		}
	}
	
	// Delete Given Node
	public void deleteNode(String value) {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>(); //---------------> O(1) 
		queue.add(root); //---------------> O(1) 
		while(!queue.isEmpty()) {  //---------------> O(n) 
			BinaryNode presentNode = queue.remove();  //---------------> O(1) 
			if(presentNode.value == value) {  //---------------> O(1) 
				presentNode.value = getDeepestNode().value;  //---------------> O(n) 
				deleteDeepestNode();  //---------------> O(N) 
				System.out.println("The node is deleted!"); //---------------> O(1) 
				
			} else {
				if(presentNode.left != null) queue.add(presentNode.left); //-----------> O(1) 
				if(presentNode.right != null) queue.add(presentNode.right);//-----------> O(1) 
				
			}
		}
		System.out.println("The node does not exist in BT"); //---------------> O(1) 
		//Time Complexity O(N)->recursive Space Complexity O(N)->inserting nodes in stack memory
	}
	 
	// Delete BinaryTree
	public void deleteBT() {
		root = null; //---------------> O(1) 
		System.out.println("The BT has been successfully deleted!");//---------------> O(1) 
		//Time Complexity O(1) Space Complexity O(1)
	}
	
}
