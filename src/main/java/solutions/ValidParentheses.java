package src.main.java.solutions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LC 20. Valid Parentheses
 */
public class ValidParentheses {
  public boolean isValid(String s) {
    char[] charArray = s.toCharArray();
    Deque<Character> stack = new ArrayDeque<Character>();
    for (final char c : charArray) {
      if (c == '(')
        stack.push(')');
      else if (c == '{')
        stack.push('}');
      else if (c == '[')
        stack.push(']');
      else if (stack.isEmpty() || stack.pop() != c)
        return false;
    }
    return stack.isEmpty();
  }
}
