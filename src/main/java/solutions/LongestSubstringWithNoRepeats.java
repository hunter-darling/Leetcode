package src.main.java.solutions;

import java.util.HashSet;

/**
 * LC 3. Longest Substring Without Repeating Characters
 */
public class LongestSubstringWithNoRepeats {
  // First attempt: WRONG
  // public int lengthOfLongestSubstring(String s) {
  // HashSet<Character> charSet = new HashSet();
  // int start = 0;
  // int result = 0;
  // for (int end = 1; end < s.length(); ++end) {
  // while (charSet.contains(s.charAt(end))) {
  // charSet.remove(s.charAt(start));
  // start += 1;
  // }
  // charSet.add(s.charAt(end));
  // result = Math.max(result, charSet.size());
  // }
  // return result;
  // }
  public int lengthOfLongestSubstring(String s) {
    HashSet<Character> charSet = new HashSet<Character>();
    int start = 0;
    int result = 0;
    for (int end = 0; end < s.length(); ++end) {
      while (charSet.contains(s.charAt(end))) {
        charSet.remove(s.charAt(start));
        start += 1;
      }
      charSet.add(s.charAt(end));
      result = Math.max(result, charSet.size());
    }
    return result;
  }
}
