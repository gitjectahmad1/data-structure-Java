package tree.binary.search;


import java.util.LinkedList;
import java.util.Queue;



public class BinarySearchTree {
	
	 BinaryNode root;
	
	 BinarySearchTree() {
		root = null; //------------------> O(1)
		//Time Complexity O(1) Space Complexity O(1)
	}
	
	// Insert Method
	private BinaryNode insert(BinaryNode currentNode, int value) {
		
		if(currentNode == null) { //------------------> O(1)
			BinaryNode newNode = new BinaryNode(); //------------------> O(1)
			newNode.value = value; //------------------> O(1)
			System.out.println("The value successfully inserted"); //------------------> O(1)
			return newNode; //------------------> O(1)
		} else if(value <= currentNode.value){ //------------------> O(1)
			currentNode.left = insert(currentNode.left, value); //------------------> O(N/2)
			return currentNode; //------------------> O(1)
		} else {
			currentNode.right = insert(currentNode.right, value);//------------------> O(N/2)
			return currentNode; //------------------> O(1)
		}
	//Time Complexity O(LogN) Space Complexity O(LogN)
	}
	
	 void insert(int value) {
		root = insert(root, value);
	}
	
	// Pre Order Traversal 
	public void preOrder(BinaryNode node) {
		if(node == null) {
			return;
		}
		System.out.print(node.value + " ");
		preOrder(node.left);
		preOrder(node.right);	
		// Time Complexity O(N)visit all nodes Space Complexity O(N) stack recursive
		
	}
	
	//In Order traversal
	public void inOrder(BinaryNode node) {
		if(node == null) {
			return;
		}		
		inOrder(node.left);
		System.out.print(node.value + " ");
		inOrder(node.right);
		//Time Complexity O(N)visit all nodes Space Complexity O(N) stack recursive
	}
	
	//Post Order traversal
		public void postOrder(BinaryNode node) {
			if(node == null) {
			 return;			
			}		
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.value + " ");
			//Time Complexity O(N)visit all nodes Space Complexity O(N) stack recursive
		}
		
	// level Order traversal
	public void levelOrder() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			System.out.print(presentNode.value + " ");
			if(presentNode.left != null) {
				queue.add(presentNode.left);
			}
			if(presentNode.right != null) {
				queue.add(presentNode.right);
			}
		}
		//Time Complexity O(N)visit all nodes Space Complexity O(N) stack recursive enqueing
	}
	
	// Search Method
	BinaryNode search(BinaryNode node, int value) {
		if(node == null) {                                              //|
			System.out.println("Value: "+ value + " not found in BST"); //|------------------> O(1)
			return null;                                                //|
		} else if(node.value == value){                             //|
			System.out.println("Value: "+ value + " found in BST"); //|------------------> O(1)
			return node;                                            //|
		} else if(value < node.value) {
			return search(node.left, value);  //------------------> O(N/2)
		} else {
			return search(node.right, value);  //------------------> O(N/2)
		}
		//Time Complexity O(LogN) Space Complexity O(LogN)
	}
	
	// Minimum node - successor
	public static BinaryNode minimumNode(BinaryNode root) {
		if(root.left == null) {
			return root;
		} else {
			return minimumNode(root.left);
		}
	}
	
	// Delete Node
	public BinaryNode deleteNode(BinaryNode root, int value) {
		if(root == null) {                               //|
			System.out.println("Value not found in BST");//|-------------> O(1)
			return null;                                 //|
		}
		if (value < root.value) {
			root.left = deleteNode(root.left, value); //---------------------->O(N/2)
		} else if (value > root.value) {
			root.right = deleteNode(root.right, value);//---------------------->O(N/2)
		} else { // current node that we want  to delete
			// two children
			if(root.left != null && root.right != null) { //------------------->O(1)
				BinaryNode temp = root; //------------------->O(1)
				BinaryNode minNodeForRight = minimumNode(temp.right); //--------< O(LogN)
				root.value = minNodeForRight.value; //------------------->O(1)
				root.right = deleteNode(root.right, minNodeForRight.value); //----------->O(N/2)
			} else if(root.left != null) { // only one child
				root = root.left;  //------------------->O(1)
			} else if(root.right != null) {
				root = root.right; //------------------->O(1)
			} else { // leaf node 
				root = null;  //------------------->O(1)
			}
		}
		return root;
		// Time Complexity O(LogN) Space Complexity O(LogN) recursice insert some nodes to satck 
	}
	
	// delte Entire Binary search tree
	public void deleteBST(){
		root = null; //------------------->O(1)
		System.out.println("BST has been successfully deleted");
		// Time Complexity O(1) Space Complexity O(1)
		
	}
}
