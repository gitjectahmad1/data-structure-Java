package hashing;
import java.util.ArrayList;

public class QuadraticProbing {
	
	String[] hashTable;
	int usedCellNumber;
	
	//constructor
	public QuadraticProbing(int size) {
		hashTable = new String[size];
		usedCellNumber = 0;
	}
	
	//hashFunction
	public int modASCIIHashFunction(String word, int M) {
		char ch[];
		ch = word.toCharArray();
		int i, sum;
		for(sum=0, i=0; i<word.length(); i++) {
			sum = sum + ch[i];
		}
		return sum % M;
	}

	//Returns loadfactor method
	public double getLoadFactor() {
		double loadFactor = usedCellNumber * 1.0/hashTable.length; // java doc 
		return loadFactor;
	}
	//Rehashing 2x size
	public void rehashKeys(String word) {
		usedCellNumber = 0;
		ArrayList<String> data = new ArrayList<String>();
		for(String s : hashTable) {
			if(s != null) {
				data.add(s);
			}
		}
			data.add(word);
			hashTable = new String[hashTable.length * 2];
			for(String s : data) {
				// Insert Hash Table
				insertKeyInHashTable(s);
			}
		}

	public void insertKeyInHashTable(String word) {
		double loadFactor = getLoadFactor();
		if(loadFactor >= 0.75) {
			rehashKeys(word);
		} else {
			int index = modASCIIHashFunction(word, hashTable.length);
			int counter = 0; // quadratic 
			for (int i=index; i<index+hashTable.length; i++) {
				int newIndex = (index + (counter*counter)) % hashTable.length;
				if(hashTable[newIndex] == null) {
					hashTable[newIndex] = word;
					System.out.println(word+ " has been successfully inserted");
					break;
				} else {
					System.out.println(newIndex+" is already occupied. Trying next one..");
				}
				counter++;
			}
		}
		usedCellNumber++;
	}
	
	// search method
	public boolean searchHashTable(String word) {
		int index = modASCIIHashFunction(word, hashTable.length);
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
		int index = modASCIIHashFunction(word, hashTable.length);
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
	}
}
