package hashing;

public class QuadraticProbingMain {

	public static void main(String[] args) {
	
		QuadraticProbing quadraticProbing = new QuadraticProbing(13);
		
		quadraticProbing.insertKeyInHashTable("The");
		quadraticProbing.insertKeyInHashTable("quick");
		quadraticProbing.insertKeyInHashTable("brown");
		quadraticProbing.insertKeyInHashTable("fox");
		quadraticProbing.insertKeyInHashTable("over");
		quadraticProbing.insertKeyInHashTable("lazy");
		
		quadraticProbing.displayHashTable();
		quadraticProbing.searchHashTable("brown");
		quadraticProbing.deleteKeyhashTable("lazy");
		quadraticProbing.displayHashTable();

	}

}
