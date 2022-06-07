package _03_advance._2022_06_01.queues_1.live_session;

import java.util.Stack;

public class QueueUsingStacks {

    static Stack<Integer> stackA = new Stack<>();
    static Stack<Integer> stackB = new Stack<>();

    /** Initialize your data structure here. */
    QueueUsingStacks() {
    }

    /** Push element X to the back of queue. */
    static void push(int X) {
        stackA.push(X);
    }

    /** Removes the element from in front of queue and returns that element. */
    static int pop() {
        if (stackB.isEmpty()){
            while (!stackA.isEmpty()){
                stackB.push(stackA.pop());
            }
            return stackB.pop();
        }
        return stackB.pop();
    }

    /** Get the front element of the queue. */
    static int peek() {
        if (stackB.isEmpty()){
            while (!stackA.isEmpty()){
                stackB.push(stackA.pop());
            }
            return stackB.peek();
        }
        return stackB.peek();
    }

    /** Returns whether the queue is empty. */
    static boolean empty() {
        return stackA.empty() && stackB.isEmpty();
    }
}
