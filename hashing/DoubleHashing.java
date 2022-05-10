package hashing;

import java.util.ArrayList;

public class DoubleHashing {

	
	String[] hashTable;
	int noOfCellsUsedInHashTable;
	
	//constructor
	DoubleHashing(int size){
		
	 hashTable = new String[size];
	 noOfCellsUsedInHashTable = 0;
	 
	}
	
	
	//hashFunction
	public int simpleASCIIHashFunction(String x, int M) {
		char ch[];
		ch = x.toCharArray();
		int i, sum;
		for(sum=0, i=0; i<x.length(); i++) {
			sum = sum + ch[i];
		}
		return sum % M;
	}
	
	
	//creates a new hashTable and does ReHashing
  public void rehashKeys(String newStringTobeInserted) {
	  noOfCellsUsedInHashTable = 0;
	ArrayList<String> data = new ArrayList<String>();
	for(String s : hashTable) {
		if(s != null) {
			data.add(s);
		}
	}
		data.add(newStringTobeInserted);
		hashTable = new String[hashTable.length * 2];
		for(String s : data) {
			// Insert Hash Table
			insertkeyInHashTable(s);
		}
	}
  
  //display hashtable
  public void displayHashTable() {
	if(hashTable == null) {
		System.out.println("\nHashTable does not exists!");
		return;
	} else {
		System.out.println("\n-----------HashTable------------------");
		for(int i=0; i<hashTable.length; i++){
		System.out.println("Index "+ i + ", Key:"+ hashTable[i]);	
		}
	}
	System.out.println("\n");
 }
  
//search method
	public boolean searchHashTable(String word) {
		int index = simpleASCIIHashFunction(word, hashTable.length);
		for(int i=index; i<index+hashTable.length;i++) {
			int newIndex = i % hashTable.length;
			if(hashTable[newIndex] !=null && hashTable[newIndex].equals(word)) {
				System.out.println(word+" found at location "+newIndex);
				return true;
			}
		}
		System.out.println(word+" not found in hashTable");
		return false; 
	}
	
	//delete method
  public void deleteKeyhashTable(String word) {
	int index = simpleASCIIHashFunction(word, hashTable.length);
	for(int i=index; i<index+hashTable.length; i++) {
		int newIndex = i % hashTable.length;
		if(hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
			hashTable[newIndex] = null;
			System.out.println(word+" has been deleted from hashTable");
			return;
		}
	}
	System.out.println(word+" not found in hashTable");
}
  
  //-------------------------------------------------------------------------
  //helper method for second hash function
  private int addAllDigitsTogether(int sum) {
	  int value = 0;
	  while(sum > 0) {
		  value = sum % 10;
		  sum = sum / 10;
	  }
	  return value;
  }
  //second hashFunction
  public int secondhashFunction(String x, int M) {
	  char ch[];
	  ch = x.toCharArray(); //ascii vslues of characters to ch here
	  int i, sum;
	  for(sum=0, i=0; i<x.length(); i++) {
		  sum += ch[i];
	  }
	  while (sum > hashTable.length) {
		  sum = addAllDigitsTogether(sum);
	  }
	  return sum % M;
  }
  //helper function for insert
  public double getLoadFactor() {
	  return noOfCellsUsedInHashTable * 1.0/hashTable.length;  
  }
  //insert method doublehashing
  public void insertkeyInHashTable(String value) {
	 double loadFactor =  getLoadFactor();
	 if(loadFactor >= 0.75) {
		 rehashKeys(value);
	 } else {
		 int x = simpleASCIIHashFunction(value, hashTable.length);
		 int y = secondhashFunction(value, hashTable.length);
		 for(int i=0; i<hashTable.length; i++) {
			 int newIndex = (x + i*y) % hashTable.length;
			 if(hashTable[newIndex] == null) {
				 hashTable[newIndex] = value;
				 System.out.println(value+" inserted at location: "+newIndex);
				 break;
			 } else {
				 System.out.println(newIndex+" is occupied.Trying next empty index..");
			 }
		 }
	 }
	 noOfCellsUsedInHashTable++;
  }
  
}
