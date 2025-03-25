package src.main.java.model;

/*
 * LC 208. Implement Trie (Prefix Tree)
 */
public class Trie {
  private TrieNode root;

  public Trie() {
    this.root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode current = root;
    for (char c : word.toCharArray()) {
      if (current.children[c - 'a'] == null) {
        current.children[c - 'a'] = new TrieNode();
      }
      current = current.children[c - 'a'];
    }
    current.endOfWord = true;
  }

  public boolean search(String word) {
    TrieNode current = root;
    for (char c : word.toCharArray()) {
      if (current.children[c - 'a'] == null) {
        return false;
      }
      current = current.children[c - 'a'];
    }
    return current != null && current.endOfWord;
  }

  public boolean startsWith(String prefix) {
    TrieNode current = root;
    for (char c : prefix.toCharArray()) {
      if (current.children[c - 'a'] == null) {
        return false;
      }
      current = current.children[c - 'a'];
    }
    return current != null;
  }
}
