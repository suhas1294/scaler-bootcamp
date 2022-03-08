package _02_intermediate._2022_02_25.stacks_queues.assignments;

import java.util.ArrayList;
import java.util.List;

/*
    while pushing to stack, if the element is < current element,
    then store (2 x element - curMin) in stack and update curMin = x;

    while popping , pop the number say x,
    if x < curMin,
        print curMin
        curMin = (2 * curMin - x), return
*/

public class MinStack {
    List<Integer> list = new ArrayList<>();
    int minEle = -1;

    public void push(int x) {
        if (list.isEmpty()){
            minEle = x;
            list.add(x);
        }else if (x < minEle){
            list.add(2 * x - minEle);
            minEle = x;
        }else{
            list.add(x);
        }
    }

    public void pop() {
        if (!list.isEmpty()) {
            int poppedElement = list.remove(list.size()-1);
            if (poppedElement < minEle){
                int temp = minEle;
                minEle = (2 * minEle - poppedElement);
                //System.out.println(temp);
            }
        }
    }

    public int top() {
        if (list.isEmpty()) return -1;
        int topEle = list.get(list.size() - 1);
        if (topEle < minEle){
            return minEle;
        }else{
            return topEle;
        }
    }

    public int getMin() {
        if (list.isEmpty()) return -1;
        return minEle;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(10);
        minStack.push(9);
        minStack.getMin(); // 9
        minStack.push(8);
        minStack.getMin(); // 8
        minStack.push(7);
        minStack.getMin(); // 7
        minStack.push(6);
        minStack.getMin(); // 6

        minStack.pop();
        minStack.getMin();

        minStack.pop();
        minStack.getMin();

        minStack.pop();
        minStack.getMin();

        minStack.pop();
        minStack.getMin();

        minStack.pop();
        minStack.getMin();

    }
}

/*
Design a stack that supports push, pop, top, and retrieve the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

NOTE:
All the operations have to be constant time operations.
getMin() should return -1 if the stack is empty.
pop() should return nothing if the stack is empty.
top() should return -1 if the stack is empty.


Problem Constraints
1 <= Number of Function calls <= 10^7

Input Format : Functions will be called by the checker code automatically.
Output Format : Each function should return the values as defined by the problem statement.

Example Input

Input 1:
    push(1)
    push(2)
    push(-2)
    getMin()
    pop()
    getMin()
    top()

Input 2:
    getMin()
    pop()
    top()


Example Output
Output 1: -2 1 2
Output 2: -1 -1

Explanation 1:
Let the initial stack be : []
1) push(1) : [1]
2) push(2) : [1, 2]
3) push(-2) : [1, 2, -2]
4) getMin() : Returns -2 as the minimum element in the stack is -2.
5) pop() : Return -2 as -2 is the topmost element in the stack.
6) getMin() : Returns 1 as the minimum element in stack is 1.
7) top() : Return 2 as 2 is the topmost element in the stack.

Explanation 2:
Let the initial stack be : []
1) getMin() : Returns -1 as the stack is empty.
2) pop() :  Returns nothing as the stack is empty.
3) top() : Returns -1 as the stack is empty.
 */