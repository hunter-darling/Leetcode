package src.main.java.solutions;

// import java.util.ArrayDeque;
// import java.util.Deque;

/**
 * LC 125. Valid Palindrome
 */
public class ValidPalindrome {

  /**
   * First submission:
   * java.lang.NullPointerException: Cannot invoke
   * "java.lang.Character.charValue()" because the return value of
   * "java.util.Deque.peek()" is null
   */
  // public boolean isPalindrome(String s) {
  // char[] charArray = s.toCharArray();
  // Deque<Character> stack = new ArrayDeque();
  // if (charArray.length <= 1) {
  // return true;
  // }
  // for (int i = 0; i < charArray.length; i++) {
  // if (i < charArray.length / 2) {
  // if (Character.isDigit(charArray[i]) || Character.isLetter(charArray[i])) {
  // stack.push((Character.toLowerCase(charArray[i])));
  // }
  // } else if ((Character.isDigit(charArray[i]) ||
  // Character.isLetter(charArray[i]))) {
  // if (Character.toLowerCase(charArray[i]) == stack.peek())
  // stack.pop();
  // } else {
  // continue;
  // }
  // }
  // System.out.println(stack.toString());
  // return stack.isEmpty() || stack.size() == 1;
  // }

  /**
   * Second submission:
   * Missed edge case where s is 2 different characters because of return
   * condition
   */
  // public boolean isPalindrome(String s) {
  // char[] charArray = s.toCharArray();
  // Deque<Character> stack = new ArrayDeque();
  // if (charArray.length <= 1) {
  // return true;
  // }
  // for (int i = 0; i < charArray.length; i++) {
  // if (i < charArray.length / 2) {
  // if (Character.isDigit(charArray[i]) || Character.isLetter(charArray[i])) {
  // stack.push((Character.toLowerCase(charArray[i])));
  // }
  // } else if ((Character.isDigit(charArray[i]) ||
  // Character.isLetter(charArray[i]))) {
  // if (!stack.isEmpty() && Character.toLowerCase(charArray[i]) == stack.peek())
  // stack.pop();
  // } else {
  // continue;
  // }
  // }
  // System.out.println(stack.toString());
  // return stack.isEmpty() || stack.size() == 1;
  // }

  public boolean isPalindrome(String s) {
    // Closing window method
    int start = 0;
    int end = s.length() - 1;
    while (start < end) {
      while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
        ++start;
      }
      while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
        --end;
      }
      if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
        return false;
      }
      ++start;
      --end;
    }
    return true;
  }

}
