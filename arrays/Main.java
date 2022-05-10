package arrays;

import java.util.Arrays;

class Main {

	public static void main(String[] args) {

	// declaring an array
		int[] intArray; // ------------------> O(1)
	// instantiating an array 	
		intArray = new int[3]; // -----------> O(1)
	// initialization of an array	
		intArray[0] = 1; // -----------------> O(1)
		intArray[1] = 2; // -----------------> O(1)      // ------>O(N)
		intArray[2] = 3; // -----------------> O(1)
		
		String sArray[] = {"a", "b", "c" };//--------------> O(1)
		
		System.out.println(Arrays.toString(sArray));
		
		SingleDimensionArray sda = new SingleDimensionArray(10);
		sda.insert(0, 0);
		sda.insert(1, 10);
		sda.insert(2, 20);
		sda.insert(1, 30);
		sda.insert(12, 120);
		
		//accesssing array elements
		var firstElement = sda.arr[0]; // ------------------> O(1)
		System.out.println(firstElement);
		var thirdElement = sda.arr[3]; // ------------------> O(1)
		System.out.println(thirdElement);
		
		// Array Traversal
		System.out.println("Array traversal");
		sda.traversearray();
		System.out.println();
		
		// search in array 
		sda.searchInArray(30);
		
		// delete an array element 
		sda.deleteValue(0);
		System.out.println(sda.arr[0]);
	}

}
