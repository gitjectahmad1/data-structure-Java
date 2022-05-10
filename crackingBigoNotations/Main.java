package crackingBigoNotations;

import java.util.Arrays;

class Main {

	public static void main(String[] args) {
		
		Main main = new Main();
		int[] customArray = { 1, 3, 4, 5};
		main.spofArray(customArray);
		
		main.printPairs(customArray);
		
		main.reverse(customArray);

	}
	// sum and product of array 
	void spofArray(int[] array) {
		int sum =0; // -----------------------------------> O(1) assignment
		int product = 1;  // -----------------------------> O(1)
		//loop starts from 0 traverse to n all elements
		for(int i=0; i<array.length; i++) { // -----------> O(N) 
			sum += array[i];  // -------------------------> O(1)
		}
		for(int i=0; i<array.length; i++) { // -----------> O(N)
			product *= array[i]; // ----------------------> O(1)
		}
		System.out.println(sum + " " + product); //-------> O(1)
	}
	
	// print pairs
	void printPairs(int[] array) {
		// looping through array with n number of elements 
		for (int i=0; i<array.length; i++) { //--------------> O(N) 
			for (int j=0; j<array.length; j++) {//-----------> O(N) 
			 System.out.println(array[i] + ","+array[j]);//--> O(1)
			}
		}
	}
	
	// reverse an array 
	void reverse(int[] array) {
		for (int i=0; i<array.length/2; i++) {// ---------------> O(n/2)
			//last element until reach the middle
			int other = array.length - i - 1; // ---------------> O(1)
			// element at the index of i
			int temp = array[i]; //-----------------------------> O(1)
			// replace last element with index i first element
			array[i] = array[other];//--------------------------> O(1)
			//set first element to this element here 
			array[other] = temp; //-----------------------------> O(1)
			
		}
		System.out.println(Arrays.toString(array));
	}
	
	
	

}
