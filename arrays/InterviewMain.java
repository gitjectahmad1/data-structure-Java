package arrays;

import java.util.Arrays;

public class InterviewMain {

	public static void main(String[] args) {
		
		InterviewMain main = new InterviewMain();
			
		int intArray[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
		 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42,
		 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64,
		 65, 66, 67, 68, 69, 70, 71, 72, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87,
		 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100
		};
		
		main.missingNumber(intArray);
		
		int[] int1Array = {2, 7, 11, 15};
		int[] result = main.twoSum(int1Array, 18);
		System.out.println(Arrays.toString(result));
		
		int[] int2Array = {1,2,3,4,5,6};
		main.linearSearch(int2Array, 6);
		
		
		int[] int3Array = {10, 60, 30, 40, 50};
		String pairs = main.maxProduct(int3Array);
		System.out.println(pairs);
		
		
		int[] int4Array = {1, 2, 3, 6, 5, 6};
		boolean result1 = main.isUnique(int4Array);
		System.out.println(result1);
		
		int[] array5 = {1,2,3,4,5};
		int[] array6 = {5,4,3,2,1};
		boolean result2 = main.permutation(array5, array6);
		System.out.println(result2);
		
		
		int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
		main.rotateMatrix(matrix);
		System.out.println(Arrays.deepToString(matrix));
		
	}
	
	// missing number find
	public void missingNumber(int[] intArray) {
	  int sum1 = 0;
	  int sum2 = 0;
	  
	  for(int i: intArray) {
		  sum1 += i;
	  }
	  
	  sum2 = 100*(100+1)/2;
	  
	  int difference = sum2 - sum1;
	  System.out.println("Missing Number is " + difference);
	  
	}
	
	// Two Sum
	public int[] twoSum(int[] nums, int target) {
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				if(nums[i]+nums[j] == target) {
					return new int[] {i, j};
				}
			}
		}
		throw new IllegalArgumentException("No Solution Found");
	}
	
	// Search Method
	public void linearSearch(int[] intArray, int value) {
		for(int i=0; i<intArray.length; i++) {
			if(intArray[i] == value) {
				System.out.println("The value is found at index " + i);
				return;
			} 
		}
		System.out.println(value + " is not found");
	}
	
	// Max Product
	public String maxProduct(int[] intArray) {
		int maxProduct = 0;
		String pairs = "";
		for(int i=0; i<intArray.length; i++) {
			for (int j=i+1; j<intArray.length; j++) {
				if(intArray[i]*intArray[j]>maxProduct) {
					maxProduct = intArray[i]*intArray[j];
					pairs = Integer.toString(intArray[i]) + "," + Integer.toString(intArray[j]);
				}
			}
		}
		return pairs;
	}
	
	// Is Unique
	public boolean isUnique(int[] intArray) {
		for(int i=0; i<intArray.length; i++) {
			for(int j=i+1; j<intArray.length; j++) {
				if(intArray[i] == intArray[j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	// Permutation
	public boolean permutation(int[] array1, int[] array2) {
		if(array1.length != array2.length) {
			return false;
		}
		int sum1 = 0;
		int sum2 = 0;
		
		int mul1 = 1;
		int mul2 = 1;
		
		for(int i=0; i<array1.length; i++) {
			sum1 +=array1[i];
			sum2 +=array2[i];
			mul1 *=array1[i];
			mul2 *=array2[i];
		}
		if(sum1 == sum2 && mul1 == mul2) {
			return true;
		}
		return false;
		
	}
	
	// Rotate Matrix
	public boolean rotateMatrix(int[][] matrix) {
		if(matrix.length ==0 || matrix.length != matrix[0].length) 	return false;
		
			int n = matrix.length;	
			
			for(int layer=0; layer<n/2; layer++) {
				int first = layer;
				int last = n -1 - layer;
				
				for(int i=first; i<last; i++) {
					int offset = i - first;
					int top = matrix[first][i];
					matrix[first][i] = matrix[last-offset][first];
					matrix[last-offset][first] = matrix[last][last-offset];
					matrix[last][last-offset] = matrix[i][last];
					matrix[i][last] =  top;
				}
			}
		return true;
	}

}
