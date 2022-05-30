package _03_advance._2022_05_25.stacks_1.live_session;

import java.util.Stack;

// TC: n log n, sc : O(n)
public class _03_MergeSortStack {
    public static Stack<Integer> mergeSortStack(Stack<Integer> input){
        if (input.size() <= 1) return input;
        Stack<Integer> tmp = new Stack<>();
        int n = input.size();
        for (int i = 0; i < (n / 2); i++) {
            tmp.push(input.pop());
        }
        input = mergeSortStack(input);
        tmp = mergeSortStack(tmp);
        return _02_MergeTwoSortedArrays.mergeStack(input, tmp);
    }
}
