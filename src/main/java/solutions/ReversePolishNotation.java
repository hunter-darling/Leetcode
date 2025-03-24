package src.main.java.solutions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LC 150. Evaluate Reverse Polish Notation
 */
public class ReversePolishNotation {
  // First solution, works, but exceeded output limit, also a bit over-engineered
  public int evalRPNv1(String[] tokens) {
    // Stack! (thanks wikipedia)
    Deque<Integer> tokenStack = new ArrayDeque<Integer>();
    for (String s : tokens) {
      try {
        int sInt = Integer.parseInt(s);
        tokenStack.push(sInt);
        System.out.println(s + " pushed to stack: " + tokenStack);
      } catch (NumberFormatException e) {
        int b = tokenStack.pop();
        int a = tokenStack.pop();
        System.out.println("s: " + s + " expression: " + a + s + b);
        System.out.println("stack: " + tokenStack);
        switch (s) {
          case ("*"):
            tokenStack.push(a * b);
            System.out.println("result pushed to stack: " + tokenStack);
            break;
          case ("+"):
            tokenStack.push(a + b);
            System.out.println("result pushed to stack: " + tokenStack);
            break;
          case ("-"):
            tokenStack.push(a - b);
            System.out.println("result pushed to stack: " + tokenStack);
            break;
          case ("/"):
            tokenStack.push(a / b);
            System.out.println("result pushed to stack: " + tokenStack);
            break;
        }
      }
    }
    return tokenStack.pop();
  }

  // Second solution, no need for error catching, just check for symbols first,
  // then use parseInt, still O(n) complexity but absolute runtime is faster
  public int evalRPNv2(String[] tokens) {
    // Stack! (thanks wikipedia)
    Deque<Integer> tokenStack = new ArrayDeque<Integer>();
    for (String s : tokens) {
      if (s.equals("+")) {
        int num1 = tokenStack.pop();
        int num2 = tokenStack.pop();
        tokenStack.push(num2 + num1);
      } else if (s.equals("-")) {
        int num1 = tokenStack.pop();
        int num2 = tokenStack.pop();
        tokenStack.push(num2 - num1);
      } else if (s.equals("*")) {
        int num1 = tokenStack.pop();
        int num2 = tokenStack.pop();
        tokenStack.push(num2 * num1);
      } else if (s.equals("/")) {
        int num1 = tokenStack.pop();
        int num2 = tokenStack.pop();
        tokenStack.push(num2 / num1);
      } else {
        // Push integer values directly to the stack
        tokenStack.push(Integer.parseInt(s));
      }
    }
    return tokenStack.pop();
  }
}
