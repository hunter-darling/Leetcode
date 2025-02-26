package src.main.java.solutions;

import java.util.HashMap;

public class LongestPalindrom {

  public int longestPalindromeFirstAttempt(String s) {
    HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
    int endsLength = 0;
    for (char c : s.toCharArray()) {
      if (charMap.get(c) == null) {
        charMap.put(c, 1);
      } else if (charMap.get(c) != null) {
        charMap.replace(c, charMap.get(c) + 1);
      }
    }
    int centerpieceLength = 0;
    for (char c : charMap.keySet()) {
      if (charMap.get(c) % 2 == 0) {
        endsLength += charMap.get(c);
      } else if (charMap.get(c) % 2 == 1) {
        if (charMap.get(c) > centerpieceLength) {
          centerpieceLength = charMap.get(c);
        }
      }
    }
    return endsLength + centerpieceLength;
  }

  public int longestPalindromeSecondAttempt(String s) {
    HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
    int length = 0;
    for (char c : s.toCharArray()) {
      charMap.put(c, charMap.getOrDefault(c, 0) + 1);
    }
    boolean hasOddOne = false;
    for (int i : charMap.values()) {
      if (i % 2 == 0) {
        length += i;
      } else {
        length += i - 1;
        hasOddOne = true;
      }
    }
    return hasOddOne ? length + 1 : length;
  }

}
