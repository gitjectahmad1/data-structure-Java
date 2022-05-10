package arrays;

import java.util.Arrays;

// deep toString() method for 2d array
public class Main1 {

	public static void main(String[] args) {
		
		// step-1: declare
		int[][] int2DArray; // -----------------------------------------> O(1)
		// step-2: instantiate
		int2DArray = new int[2][2]; // ---------------------------------> O(1)
		// step-3: initialize // m is the number of rows and n is the number of columns
		int2DArray[0][0] = 1; //-----------------------------------------> O(1)|
		int2DArray[0][1] = 2; //-----------------------------------------> O(1)|--> O(mn) intotal
		int2DArray[1][0] = 3; //-----------------------------------------> O(1)|
		int2DArray[1][1] = 4; //-----------------------------------------> O(1)|
		
		System.out.println(Arrays.deepToString(int2DArray));
		
		// All together
		// space complexity is also O(mn) as we are allocating mn number of cells in the memory
		String s2DArray[][] = {{"a", "b"}, {"c", "d"}};// ----------------> O(1) | adviseable 
		
		System.out.println(Arrays.deepToString(s2DArray));
		

		TwoDimensionalArray sda = new TwoDimensionalArray(3, 3);
		sda.insertValueInTheArray(0, 0, 10);
		sda.insertValueInTheArray(0, 1, 20);
		sda.insertValueInTheArray(1, 0, 30);
		sda.insertValueInTheArray(2, 0, 40);
		System.out.println(Arrays.deepToString(sda.arr));
		
		sda.accessCell(0, 1);
		
		sda.traverse2DArray();
		
		sda.searchingValue(20);
		
		sda.deleteValuefromArray(0, 0);
		System.out.println(Arrays.deepToString(sda.arr));
		
		
		
		
		
	}

}
