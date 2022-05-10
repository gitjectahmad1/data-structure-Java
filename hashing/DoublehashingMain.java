package hashing;

public class DoublehashingMain {

	public static void main(String[] args) {
		
		DoubleHashing doubleHashing = new DoubleHashing(13);
		
		doubleHashing.insertkeyInHashTable("The");
		doubleHashing.insertkeyInHashTable("quick");
		doubleHashing.insertkeyInHashTable("brown");
		doubleHashing.insertkeyInHashTable("fox");
		doubleHashing.insertkeyInHashTable("over");
		doubleHashing.insertkeyInHashTable("lazy");
		
		doubleHashing.displayHashTable();
		doubleHashing.searchHashTable("lazy");
		doubleHashing.deleteKeyhashTable("lazy");
		doubleHashing.displayHashTable();
		
	}

}
