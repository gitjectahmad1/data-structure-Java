package arrays;

public class SingleDimensionArray {
	
	// insert array
	int arr[] = null; // for not having default 0 value
	
	// constructor
	public SingleDimensionArray(int sizeOfArray) {
		arr = new int[sizeOfArray];
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.MIN_VALUE;
		}
		
	}
	
	public void insert(int location, int valueToBeInserted) {
		try {
			// accessing an element in an array 
			if(arr[location] == Integer.MIN_VALUE) {// -------------------------> O(1)
				arr[location] = valueToBeInserted;  // -------------------------> O(1)
				System.out.println("Successfully Inserted"); //-----------------> O(1)
			} else {
				System.out.println("This cell is already occupied");//----------> O(1)
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("In valid index to access array!"); //------------> O(1)
		}
		
	}
	
	// Array Traversal
	public void traversearray() {
		try {
			// looping through each elemnets of the array if the number of elements is n
			for (int i=0; i<arr.length; i++) { // ---------------> O(N)
		    // accessing an element in an array
				System.out.print(arr[i] + " "); // --------------> O(1)
			}
		} catch (Exception e) {
			System.out.println("Array lo longer exists!");//-----> O(1)
		}
		// space coplexity is O(1) as no extra memory is required
	}
	
	
	// search for an element in an array 
	public void searchInArray(int valueToSearch) {
		for (int i=0; i<arr.length; i++) { // --------------------------------------> O(N)
			if (arr[i] == valueToSearch) { // --------------------------------------> O(1)
				System.out.println("Value is found at the index of " + i);//--------> O(1)
				return; // ---------------------------------------------------------> O(1)
			}
		} 
		System.out.println(valueToSearch + " is not found"); // --------------------> O(1)
		
		// space coplexity is O(1) as no extra memory is required
	}
	
	// Delete value from array 
	public void deleteValue(int valueToBeDeleteIndex) {
		
		try {	
			arr[valueToBeDeleteIndex] = Integer.MIN_VALUE;  // ---------------------------> O(1)
			System.out.println("The value has been successfully deleted"); // ------------> O(1)
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("The value that is provided is not in range of array");//--> O(1)
		}
		
		// space coplexity is O(1) as no additional memory is required
	}
	
	
	
	

}
