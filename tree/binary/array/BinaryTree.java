package tree.binary.array;

public class BinaryTree {
	
	String[] arr;
	int lastUsedIndex;
	
	public BinaryTree(int size) {
		arr = new String[size+1]; //----------------> O(1)
		this.lastUsedIndex = 0; //----------------> O(1)
		System.out.println("Blank Tree of size " + size + " has been created");//------> O(1)
		
		// Time Complexity O(1) Space Complexity O(N)
	}
	
	// isFull
	public boolean isFull() {
		if(arr.length-1 == lastUsedIndex) {
			return true;
		} else {
			return false;
		}
	}

	// insert method
	public void insert(String value) {
		if(!isFull()) { //--------------------------> O(1)
			arr[lastUsedIndex+1] = value; //--------------------------> O(1)
			lastUsedIndex++; //--------------------------> O(1)
			System.out.println("The value of "+value+" has been inserted");//-------> O(1)
		} else {
			System.out.println("The BT is full");//--------------------------> O(1)
		}
		// Time Complexity O(1) Space Complexity O(1)
	}
	
	// preOrder Traversal
	public void preOrder(int index) {
		// recursive base case
		if(index > lastUsedIndex) { //--------------------------> O(1)
			return;
		}
		System.out.print(arr[index]+ " "); //--------------------------> O(1)
		preOrder(index * 2); //--------------------------> O(N/2)
		preOrder(index * 2 + 1);//--------------------------> O(N/2)
		// Time Complexity O(N)-> recursive Space Complexity O(N)-> stack memory
	}
	
	// inOrder Traversal
	public void inOrder(int index) {
		// recursive base case
		if(index > lastUsedIndex) { //--------------------------> O(1)
			return;
		}
		inOrder(index * 2); //--------------------------> O(N/2)
		System.out.print(arr[index]+ " "); //--------------------------> O(1)
		inOrder(index * 2 + 1); //--------------------------> O(N/2)
		// Time Complexity O(N)-> recursive Space Complexity O(N)-> stack memory
	}
	
	// inOrder Traversal
	public void postOrder(int index) {
		// recursive base case
		if(index > lastUsedIndex) { //--------------------------> O(1)
			return;
		}
		postOrder(2 * index); //--------------------------> O(N/2)			
		postOrder(2 * index + 1); //--------------------------> O(N/2)
		System.out.print(arr[index]+ " "); //--------------------------> O(1)
		// Time Complexity O(N)-> recursive Space Complexity O(N)-> stack memory
		}
		
	// level Order Traversal
	public void levelOrder() {
		for(int i=1; i<=lastUsedIndex; i++) { //--------------------------> O(N)	
			System.out.print(arr[i]+ " "); //--------------------------> O(1)
		}
		// Time Complexity O(N) Space Complexity O(1)
	}
	
	// search method
	public int search(String value) {
		for(int i=1; i<=lastUsedIndex; i++) { //--------------------------> O(N)	
			if(arr[i] == value) {  //--------------------------> O(1)
				System.out.println(value+" exists at the location "+ i);//-------> O(1)
				return i; //--------------------------> O(1)
			}
		}
		System.out.println("The value does not exist in BT");//-----------------> O(1)
		return -1;
		// Time Complexity O(N) Space Complexity O(1)
	}
	
	// delete method
	public void delete(String value) {
		int location = search(value); //--------------------------> O(N)	
		if(location == -1) { //-----------------> O(1)
			return; //-----------------> O(1)

		} else {
			// moving deepest node to location we want to delete
			arr[location] = arr[lastUsedIndex]; //-----------------> O(1)
			lastUsedIndex--; //-----------------> O(1)
			System.out.println("The node successfully deleted");//-----------------> O(1)
			// Time Complexity O(N) Space Complexity O(1)
		}
	}
	
	//Delete BT
	public void deleteBT() {
		try {
			arr = null;//-----------------> O(1)
			System.out.println("The BT has been successfully deleted");//------------> O(1)
		} catch (Exception e){//-----------------> O(1)
			System.out.println("There was an error deleting this tree");//------------> O(1)
		}
		// Time Complexity O(1) Space Complexity O(1)
	}
}
