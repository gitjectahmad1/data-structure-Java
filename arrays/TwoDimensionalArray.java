package arrays;

public class TwoDimensionalArray {

	int[][] arr = null; 
	
	public TwoDimensionalArray(int numberOfRows, int numberOfColumns) {
		arr = new int [numberOfRows][numberOfColumns];
		for(int row=0; row<arr.length; row++) {
			for(int col=0; col<arr.length; col++) {
				arr[row][col] = Integer.MIN_VALUE;
			}
		}
	}
	
	// Inserting value in the array 
	public void insertValueInTheArray(int row, int col, int value) {
		try {
			if (arr[row][col] == Integer.MIN_VALUE) { //-------------------------> O(1)
				arr[row][col] = value; // ---------------------------------------> O(1)
				System.out.println("The value is successfully inserted");//------> O(1)
			} else {
				System.out.println("This cell is already occupied!");//----------> O(1)
			}
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid index for 2D array");//------------------> O(1)
		}
		// space complexity is also O(1)
	}
	
	// Accessing the cell value from a given array 
	public void accessCell(int row, int col) {
		System.out.println("\nAccessing row#" + row + " col#" + col);//----------> O(1)
		try {
			System.out.println("Cell value is: " + arr[row][col]);//-------------> O(1)
		}catch (ArrayIndexOutOfBoundsException e) {
		  System.out.println("Invalid index for 2D array");//--------------------> O(1)
		  //dspace complexity is also O(1)
		}
	}
	
	// Traverse 2D array
	public void traverse2DArray() {
		for (int row=0; row<arr.length; row++) { // --------------------> O(m)|  //O(mn) multiply
			for(int col=0; col<arr[0].length; col++) { // --------------> O(n)|  
				System.out.print(arr[row][col] + " "); //---------------> O(1)
			}
			System.out.println(); //------------------------------------> O(1)
		}
		// space complexity O(1) no additional memory reqired
	}
	
	// Searching a single value from the Array 
	// arr[0].length returns number of columns in each iteration
	public void searchingValue(int value) {
		for (int row=0; row<arr.length; row++) {//------------------> O(m)|  //O(mn) multiply
		 for (int col=0; col<arr[0].length; col++) {//--------------> O(n)| 
			if (arr[row][col] == value) {  //-----------------------> O(1)
				System.out.println("Value is found at row: " + row + " Col: " + col);//--> O(1)
					return;
				}
			}
		}
		System.out.println("Value is not found!");//-----------------> O(1)
		// space complexity O(1) no additional memory reqired
	}
	
	// Deleting a value from array 
	// whenever dealing with row and column in parameter use try catch for bad situation cover
	public void deleteValuefromArray(int row, int col) {
		try {
			System.out.println("Successfully deleted:" + arr[row][col]); // -----> O(1)
			arr[row][col] = Integer.MIN_VALUE; // -------------------------------> O(1)
			
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("This index is invalid for array"); //------------> O(1)
		}
		// space complexity O(1) no extra memory reqired
	}
	
	
	
	
	
	
}
