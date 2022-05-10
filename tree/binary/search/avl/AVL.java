package tree.binary.search.avl;

import java.util.LinkedList;
import java.util.Queue;

public class AVL {
	
	BinaryNode root;
	
	// construction
	AVL(){
		root = null;
	}
	
	// preOrer traversal
	public void preOrder(BinaryNode node) {
		if(node == null) {
			return;
		}
		System.out.println(node.value + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
	// inOrer traversal
	public void inOrder(BinaryNode node) {
		if(node == null) {
			return;
		}
		inOrder(node.left);
		System.out.println(node.value + " ");		
		inOrder(node.right);
	}
	
	// inOrer traversal
	public void postOrder(BinaryNode node) {
		if(node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.value + " ");		
		
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
	}
	// search method
	public BinaryNode search(BinaryNode node, int value) {
		if(node == null) {
			System.out.println("Value "+value +" not found in AVL");
			return null;
		} else if(node.value == value) {
			System.out.println("Value"+ value+ " found in the AVL");
			return node;
		} else if (value < node.value) {
			return search(node.left, value);
		} else {
			return search(node.right, value);
		}
		// Time Complexity O(LogN) Space Complexity O(LogN)
	}
	
	// getHeight hm(helper method)
	public int getHeight(BinaryNode node) {
		if(node == null) {
			return 0;
		}
		return node.height;
	}
	
	// roatateRight
	private BinaryNode rotateRight(BinaryNode disbalancedNode) {
		// creating new root based on disbalencedNode's left child
		BinaryNode newRoot = disbalancedNode.left;
		// set disbalanced node's left child's right child to left child of disbalancedNode
		disbalancedNode.left = disbalancedNode.left.right;
		// set disbalncedNode to this right child of this newRoot
		newRoot.right = disbalancedNode;
		// update height of disbalcendNode and newRootNode
		disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
		newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
		return newRoot;
		// Time and Space Complexity O(1) since just creating and updating 
	}
	
	// rotateLeft
	private BinaryNode rotateLeft(BinaryNode disbalancedNode) {
		// creating new root based on disbalencedNode's right child
		BinaryNode newRoot = disbalancedNode.right;
		// set disbalanced node's right child's left child to right child of disbalancedNode
		disbalancedNode.right = disbalancedNode.right.left;
		// set disbalncedNode.right to this left child of this newRoot
		newRoot.left = disbalancedNode;
		// update height of disbalcendNode and newRootNode
		disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
		newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
		return newRoot;
		// Time and Space Complexity O(1) since just creating and updating 
	}
	
	// getBalance
	public int getBalance(BinaryNode node) {
		if(node == null) {
			return 0;
		}
		return getHeight(node.left) - getHeight(node.right);
		// Time and Space Complexity O(1)
	}
	
	// insertNode Method
	private BinaryNode insertNode(BinaryNode node, int nodeValue) {
		if(node == null) {                         //| 
			BinaryNode newNode = new BinaryNode(); //|
			newNode.value = nodeValue;             //|---------------------> O(1)
			newNode.height = 1;                    //|
			return newNode;                        //|
		} else if(nodeValue < node.value) {
			node.left = insertNode(node.left, nodeValue); //---------------------> O(LogN)
			
		} else {
			node.right = insertNode(node.right, nodeValue);//---------------------> O(LogN)
		}
		
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));//----------> O(1)
		int balance = getBalance(node); //---------------------> O(1)
		
		//LL
		if(balance > 1 && nodeValue < node.left.value) {
			return rotateRight(node);      //---------------------> O(1)
		}
		// LR
		if(balance > 1 && nodeValue > node.left.value) {
			node.left = rotateLeft(node.left); //---------------------> O(1)
			return rotateRight(node);
		}
		//RR
		if(balance < -1 && nodeValue > node.right.value) {
			return rotateLeft(node); //---------------------> O(1)
		}
		//RL
		if(balance < -1 && nodeValue < node.right.value) {
			node.right = rotateRight(node.right);
			return rotateLeft(node); //---------------------> O(1)
		}
		
		return node;
		// Time and Space Complexity O(LogN)
	}
	
	public void insert(int value) {
		root = insertNode(root, value);
	}
	
	// Minimum Node
	public static BinaryNode minimumNode(BinaryNode root) {
		if(root.left == null) {
			return root;
		} 
		return minimumNode(root.left); //-------------------> O(LogN)
	}
	
	// Delete Node 
	public BinaryNode deleteNode(BinaryNode node, int value) {
		if(node == null) {
			System.out.println("Value not found in AVL");
			return node;
		} if (value < node.value) {
			node.left = deleteNode(node.left, value);
		} else if (value > node.value) {
			node.right = deleteNode(node.right, value);
		} else {
			// 3 cases of rotation is not required 
			// 2 child
			if(node.left != null && node.right != null) {
				BinaryNode temp = node;
				BinaryNode minNodeForRight = minimumNode(temp.right);
				node.value = minNodeForRight.value;
				node.right = deleteNode(node.right, minNodeForRight.value);
			} else if(node.left != null) {
				node = node.left;
			} else if(node.right != null) {
				node = node.right;
			} else {
				node = null;
			}
			// whole part above Time Complexity O(LogN) 
		}
		//check disbalanced node
		int balance = getBalance(node);
		//LL
		if(balance > 1 && getBalance(node.left) >=0) {
			return rotateRight(node);
		}
		//LR
		if(balance > 1 && getBalance(node.left) <0) {
			node.left = rotateLeft(node.left);
			return rotateRight(node);
		}
		//RR
		if(balance < -1 && getBalance(node.right) <=0) {
			return rotateLeft(node);
		}
		//RL
		if(balance < -1 && getBalance(node.right) >0) {
			node.right = rotateRight(node.right);
			return rotateLeft(node);
		}
		return node;
		// whole part above Time Complexity O(1)
		// Combined Time Complexity O(LogN) Space Complexity O(LogN)
	}
	
	public void delete(int value) {
		root = deleteNode(root, value);
	}
	
	// delete entire avl tree
	public void deleteAVL() {
		root = null;
		System.out.println("AVL has been successfully deleted");
		//Time Complexity O(1) Space Complexity O(1)
	}
}
