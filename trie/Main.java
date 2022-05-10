package trie;

public class Main {

	public static void main(String[] args) {
		
		Trie newTrie = new Trie();
		newTrie.insert("API");
		newTrie.insert("APIS");
		
		newTrie.search("APIS");
		newTrie.delete("API");
		newTrie.search("API");

	}

}
