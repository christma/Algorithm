package leetCode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution232 {
    Deque<Integer> deque;

    public Solution232() {
        deque = new LinkedList<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        deque.addLast(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return deque.pollFirst();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return deque.peekFirst();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return deque.isEmpty();
    }
}
