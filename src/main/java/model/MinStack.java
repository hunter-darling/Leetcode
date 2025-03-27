package src.main.java.model;

// import java.util.ArrayDeque;
// import java.util.Deque;
import java.util.Stack;

public class MinStack {
  // How about a stack that combines the minimum check from 1st implementation
  // with storage of the val, essentially as a tuple
  private Stack<int[]> minStack;

  public MinStack() {
    minStack = new Stack<int[]>();
  }

  public void push(int val) {
    if (minStack.isEmpty()) {
      minStack.push(new int[] { val, val });
    } else {
      minStack.push(new int[] { val, Math.min(val, minStack.peek()[1]) });
    }
  }

  public void pop() {
    minStack.pop();
  }

  public int top() {
    return minStack.peek()[0];
  }

  public int getMin() {
    return minStack.peek()[1];
  }
}

// First implementation, needed consistent pop() behavior, two stacks not ideal
// class MinStack {
// public Deque<Integer> mainStack;
// public Deque<Integer> minStack;

// public MinStack() {
// mainStack = new ArrayDeque<Integer>();
// minStack = new ArrayDeque<Integer>();
// }

// public void push(int val) {
// mainStack.push(val);
// System.out.println("mainStack: " + mainStack);
// if (minStack.size() > 0 && minStack.peek() < val) {
// System.out.println("val: " + val);
// System.out.println("minStack.peek(): " + minStack.peek());
// int min = minStack.pop();
// minStack.push(val);
// minStack.push(min);
// } else {
// minStack.push(val);
// }
// System.out.println("minStack: " + minStack);
// }

// public void pop() {
// mainStack.pop();
// }

// public int top() {
// return mainStack.pop();
// }

// public int getMin() {
// return minStack.pop();
// }
// }
