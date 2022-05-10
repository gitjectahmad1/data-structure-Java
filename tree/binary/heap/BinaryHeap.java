package tree.binary.heap;

public class BinaryHeap {
	
	int arr[];
	int sizeOfTree;
	
	// create binary heap
	public BinaryHeap(int size) {
		arr = new int[size+1]; //-------------------> O(1)
		this.sizeOfTree = 0; //-------------------> O(1)
		System.out.println("Binary Heap has been created!");//-------------------> O(1)
		// Time Complexity O(1) Space Complexity O(N) contigious cells in memory
	}

	//isEmpty method
	public boolean isEmpty() {
		if(sizeOfTree == 0) {
			return true;
		} else {
			return false;
		}
		// Time Complexity O(1)
	}
	// peek method
	public Integer peek() {
		if(isEmpty()) { //-------------------> O(1)
			System.out.println("Binary Heap is empty");//-------------------> O(1)
			return  null;//-------------------> O(1)
		}
		return arr[1];//-------------------> O(1)
		// Time Complexity O(1)  Space Complexity O(1) 
	}
	
   // size method	
   public int sizeOfBP() {
	   return sizeOfTree;
	// Time Complexity O(1)  Space Complexity O(1) 
   }
   
   // traversal method
   public void levelorder() {
	   for(int i=1; i<=sizeOfTree; i++) {
		   System.out.print(arr[i]+ " "); //----------------> O(N)
	   }
	   System.out.println("\n"); //----------------->O(1)
		// Time Complexity O(N)  Space Complexity O(1) 
   }
   
   // Helper method heapify for Insert
   public void heapifyBottomToTop(int index, String heapType) {
	   int parent = index / 2; //---------------->O(1)
	   if(index <= 1) {  //---------------->O(1)
		   return;
	   }
	   if(heapType == "Min") {  //---------------->O(1)
		   if(arr[index] < arr[parent]) { 
			   int temp = arr[index];
			   arr[index] = arr[parent];      //---------------->O(1)
			   arr[parent] = temp;
		   }
	   } else if(heapType == "Max") {
		   if(arr[index] > arr[parent]) {
			   int temp = arr[index];         //---------------->O(1)
			   arr[index] = arr[parent];
			   arr[parent] = temp;
		   }
	   }
	   heapifyBottomToTop(parent, heapType); //---------------->O(LogN)
	// Time Complexity O(LogN)  Space Complexity O(LogN) 
   }
   
   public void insert(int value, String typeHeap) {
	   arr[sizeOfTree+1] = value; //---------------->O(1)
	   sizeOfTree++; //---------------->O(1) 
	   heapifyBottomToTop(sizeOfTree, typeHeap); //---------------->O(LogN)

      System.out.println("Inserted " +value+ " successfully in Heap");//---------------->O(1)
   // Time Complexity O(LogN)  Space Complexity O(LogN) 
   }
   
   //heapifyTopToBottom
   public void heapifyTopToBottom(int index, String heapType) {
	   int left = index * 2;
	   int right = index * 2 + 1; //|------------------>O(1)
	   int swapChild = 0;
	   
	   if(sizeOfTree < left) {
		   return;
	   }
	   if(heapType == "Max") {
		   // 1 child and 2 child coditions
		   if(sizeOfTree == left) {
			   if(arr[index] < arr[left]) {
				   int temp = arr[index];      //|------------------>O(1)
				   arr[index] = arr[left];
				   arr[left] = temp;
			   }
			   return;
		   } else {
			   if(arr[left] > arr[right]) {
				   swapChild = left;           //|------------------>O(1)
			   } else {
				   swapChild = right;
			   }
			   if(arr[index] < arr[swapChild]) {
				   int temp = arr[index];      //|------------------>O(1)
				   arr[index] = arr[swapChild];
				   arr[swapChild] = temp;
			   }
		   }
	   } else if(heapType == "Min") {
		   if(sizeOfTree == left) {
			   if(arr[index] > arr[left]) {
				   int temp = arr[index];      //|------------------>O(1)
				   arr[index] = arr[left];
				   arr[left] = temp;
			   }
			   return;
		   } else {
			   if(arr[left] < arr[right]) {
				   swapChild = left;
			   } else {
				   swapChild = right;
			   }
			   if(arr[index] > arr[swapChild]) {
				   int temp = arr[index];
				   arr[index] = arr[swapChild];  //|------------------>O(1)
				   arr[swapChild] = temp;
			   }
	   }
   }
	   heapifyTopToBottom(swapChild, heapType);//|------------------>O(LogN)
	   //Time Complexity O(LogN) Space Complexity O(LogN)
   }
   
   public int extractHeadOfBP(String heapType) {
	   if(isEmpty()) { //--------------> O(1)
		   return -1;
	   } else {
		   int extractedValue = arr[1]; //--------------> O(1) 
		   arr[1] = arr[sizeOfTree];  //--------------> O(1)
		   sizeOfTree--; //--------------> O(1)
		   heapifyTopToBottom(1, heapType);//--------------> O(LogN)
		   return extractedValue; //--------------> O(1)
		  
	   }
	   //Time Complexity O(LogN) Space Complexity O(LogN)
   }
   
   //delete
   public void deleteBH() {
	   arr = null;
	   System.out.println("BH has been succesfully deleted");
	   // Time Complexity O(1) Space Complexity O(1)
   }
}
