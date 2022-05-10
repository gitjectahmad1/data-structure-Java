package trie;

public class Trie {

	private TrieNode root;
	
	public Trie() {
		root = new TrieNode();
		System.out.println("The trie has been created");
		//Time Complexity O(1) Space Complexity O(1)
	}
	
	public void insert(String word) {
		TrieNode current = root;
		
		for(int i=0; i<word.length(); i++) { 
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if(node == null) {
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;
		}
		current.endOfString = true;
		System.out.println("Successfully inserted "+ word + " in Trie");
		//Time Complexity O(N) Space Complexity O(N) worst case insert all in a node
	}
	
	// search for a word in trie
	public boolean search(String word) {
		TrieNode currentNode = root;
		for(int i=0; i<word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = currentNode.children.get(ch);
			if(node == null) {
				System.out.println("Word "+word+ " does not exist in trie");
				return false;
			}
			currentNode = node;
		}
		if(currentNode.endOfString == true) {
			System.out.println("Word "+word+ " exists in trie");
			return true;
		} else {
			System.out.println("Word "+word+ " does not exist in trie.But it is a prefix of another string");
		}
		return currentNode.endOfString;
		//Time Complexity O(M) Space Complexity O(1) worst case insert all in a node
	  }
	
	// Delete a String from Trie
	
	// helper method 
	private boolean delete(TrieNode parentNode, String word, int index) {
		// 4 cases
		char ch = word.charAt(index);
		TrieNode currentNode = parentNode.children.get(ch);
		boolean canThisNodeBeDeleted;
		//case -1
		if(currentNode.children.size() > 1) {
			delete(currentNode, word, index+1);
			return false;
		}
		// case-2 
		if(index == word.length() -1) {
			if(currentNode.children.size() >=1) {
				currentNode.endOfString = false;
				return false;
			} else {
				parentNode.children.remove(ch);
				return true;
			}
		}
		//case-3
		if(currentNode.endOfString == true) {
			delete(currentNode, word, index+1);
			return false;
		}
		//case-4
		canThisNodeBeDeleted = delete(currentNode, word, index+1);
		if(canThisNodeBeDeleted == true) {
			parentNode.children.remove(ch);
			return true;
		} else {
			return false;
		}
	}
	
	// 
	public void delete(String word) {
		if(search(word) == true) {
			delete(root, word, 0);
		}
	}
	
	
	
}
