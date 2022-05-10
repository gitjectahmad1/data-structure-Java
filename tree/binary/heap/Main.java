package tree.binary.heap;

public class Main {

	public static void main(String[] args) {
		
		BinaryHeap newBP = new BinaryHeap(5);
		newBP.peek();
		newBP.levelorder();
		
		newBP.insert(10, "Max");
		newBP.insert(5, "Max");
		newBP.insert(15, "Max");
		newBP.insert(1, "Max");
		newBP.levelorder();
		
		newBP.extractHeadOfBP("Max");
		newBP.levelorder();
		
		newBP.deleteBH();
		
	}

}
