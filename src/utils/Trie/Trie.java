package utils.Trie;

public class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the trie
    public void insert(String word) {
        TrieNode parent = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';

           // Character doesn't exist at the current level
           if (parent.children[index] == null) {
               TrieNode node = new TrieNode();
               parent.children[index] = node;
               parent = node;
           } else {
               parent = parent.children[index];
           }
        }
        parent.isLeaf = true;
    }

    // Search for the existence of a word in the Trie
    public boolean search(String word) {

        TrieNode parent = searchNode(word);
        if(parent==null){
            return false;
        }else{
            if(parent.isLeaf )
                return true;
        }
        return false;
    }

    public TrieNode searchNode(String word) {
        TrieNode parent = root;

        for (int i=0; i< word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (parent.children[index] != null) {
                parent = parent.children[index];
            } else {
                return null;
            }
        }
        if(parent == root) return null;
        return parent;
    }
}
