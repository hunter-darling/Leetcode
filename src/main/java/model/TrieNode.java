package src.main.java.model;

/*
 * LC 208. Implement Trie (Prefix Tree)
 */
public class TrieNode {
  TrieNode[] children;
  boolean endOfWord;

  public TrieNode() {
    children = new TrieNode[26];
    endOfWord = false;
  }
}
