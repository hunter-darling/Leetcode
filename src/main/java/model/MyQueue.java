package src.main.java.model;

import java.util.ArrayList;

class MyQueue {

  ArrayList<Integer> queue = new ArrayList<Integer>();

  public void push(int x) {
    queue.add(x);
  }

  public int pop() {
    int poppedElement = this.peek();
    queue.remove(queue.size());
    return poppedElement;
  }

  public int peek() {
    return queue.get(queue.size());
  }

  public boolean empty() {
    return queue.size() == 0;
  }
}
