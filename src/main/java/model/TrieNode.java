package src.main.java.model;

public class TrieNode {
  TrieNode[] children;
  boolean endOfWord;

  public TrieNode() {
    children = new TrieNode[26];
    endOfWord = false;
  }
}
