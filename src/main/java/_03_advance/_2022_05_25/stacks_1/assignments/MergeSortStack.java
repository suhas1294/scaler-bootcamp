package _03_advance._2022_05_25.stacks_1.assignments;

import java.util.Stack;

public class MergeSortStack {
    public int[] solve(int[] A) {
        Stack<Integer> input = new Stack<>();
        for (int i =0; i<A.length;i++){
            input.push(A[i]);
        }
        Stack<Integer> tmpStack = new Stack<>();
        while(!input.isEmpty()) { // pop out the first element
            int tmp = input.pop();
            while(!tmpStack.isEmpty() && tmpStack.peek() > tmp){
                input.push(tmpStack.pop());
            }
            tmpStack.push(tmp);
        }
        int [] ans = new int[tmpStack.size()];
        for (int i =0; i<tmpStack.size();i++){
            ans[i]= tmpStack.get(i);
        }
        return ans;
    }
}

/*
Given a stack of integers A, sort it using another stack.
Return the array of integers after sorting the stack using another stack.

Problem Constraints
1 <= |A| <= 5000
0 <= A[i] <= 10^9

Input Format :  The only argument is a stack given as an integer array A.
Output Format : Return the array of integers after sorting the stack using another stack.

Input 1: A = [5, 4, 3, 2, 1], Output 1: [1, 2, 3, 4, 5]
Input 2: A = [5, 17, 100, 11], Output 2: [5, 11, 17, 100]

Explanation 1:  Just sort the given numbers.
Explanation 2: Just sort the given numbers.
 */