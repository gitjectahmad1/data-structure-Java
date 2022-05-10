package hashing;

public class LinearProbingMain {

	public static void main(String[] args) {

		LinearProbing linearProbing = new LinearProbing(13);
		
		linearProbing.insertInHashTable("The");
		linearProbing.insertInHashTable("quick");
		linearProbing.insertInHashTable("brown");
		linearProbing.insertInHashTable("fox");
		linearProbing.insertInHashTable("over");
		linearProbing.displayHashTable();
		
		linearProbing.searchHashTable("f");
		linearProbing.deleteKeyhashTable("fox");
		linearProbing.displayHashTable();
		
		
	}

}
