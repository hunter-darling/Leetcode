package src.main.java.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 242. Valid Anagram
 */
public class ValidAnagram {
  public boolean isAnagram(String s, String t) {
    // First submission: not a terrible idea, but the sums are not necessary 1:1
    // with any given set of characters...
    // int sSum = 0;
    // int tSum = 0;
    // for (int i = 0; i < s.length(); i++){
    // char c = s.charAt(i);
    // int ascii = (int) c;
    // sSum += ascii;
    // }
    // for (int i = 0; i < t.length(); i++){
    // char c = t.charAt(i);
    // int ascii = (int) c;
    // tSum += ascii;
    // }
    // if (sSum == tSum) {
    // return true;
    // } else {
    // return false;
    // }
    if (s.length() != t.length()) {
      return false;
    }
    Map<String, Integer> characterCountMap = new HashMap<String, Integer>();
    for (int i = 0; i < s.length(); i++) {
      String c = s.substring(i, i + 1);
      if (characterCountMap.get(c) == null) {
        characterCountMap.put(c, 1);
      } else {
        characterCountMap.put(c, characterCountMap.get(c) + 1);
      }
    }
    for (int i = 0; i < t.length(); i++) {
      String c = t.substring(i, i + 1);
      if (characterCountMap.get(c) == null) {
        return false;
      } else {
        characterCountMap.put(c, characterCountMap.get(c) - 1);
      }
    }
    System.out.println(characterCountMap.keySet());
    System.out.println(characterCountMap.values());
    for (int count : characterCountMap.values()) {
      if (count > 0) {
        return false;
      }
    }
    return true;
  }
}
