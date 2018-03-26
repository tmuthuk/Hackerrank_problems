package utils.Trie;

public class TrieNode {
    TrieNode children[];
    boolean isLeaf;

    public TrieNode() {
        children = new TrieNode[26];
    }
}
