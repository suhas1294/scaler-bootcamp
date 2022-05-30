package _03_advance._2022_05_25.stacks_1.live_session;

import java.util.Stack;

public class _02_MergeTwoSortedArrays {
    public static Stack<Integer> mergeStack(Stack<Integer> A, Stack<Integer> B){
        Stack<Integer> c = new Stack<>();
        while (A.size() > 0 && B.size() > 0){
            if (A.peek() > B.peek()){
                c.push(A.pop());
            }else {
                c.push(B.pop());
            }
        }
        while (A.size() > 0){
            c.push(A.pop());
        }
        while (B.size() > 0){
            c.push(B.pop());
        }
        _01_ReverseStackRecursion.reverseStack(c);
        return c;
    }
}
