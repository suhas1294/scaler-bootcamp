package mentor_session._2022_03_13.mock_interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextHigherFrequency {
    public static int[] solve(int[] arr){
        int n = arr.length;
        // step-1 : prepare o frequency map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i])){
                map.put(arr[i], 1);
            }else{
                int cnt = map.get(arr[i]);
                map.put(arr[i], cnt+1);
            }
        }

        Stack<Integer> stack = new Stack<>(); // store the position of array element
        stack.push(0);

        int[] result = new int[n];
        for (int i = 1; i < n; i++){
            // If the frequency of the element which is pointed by the top of stack is greater
            // than frequency of the current element then push the current position i in stack
            if (map.get(arr[stack.peek()]) > map.get(arr[i])) {
                stack.push(i);
            }else {
                // If the frequency of the element which is pointed by the top
                // of stack is less than frequency of the current element
                while( !stack.isEmpty() && map.get(arr[stack.peek()]) < map.get(arr[i])){
                    result[stack.peek()] = arr[i];
                    stack.pop();
                }
                stack.push(i);
            }
        }

        while (!stack.isEmpty()){
            result[stack.peek()] = -1;
            stack.pop();
        }
        return result;
    }
}

/*
Given an array, for each element find the value of the nearest element to the right
which is having a frequency greater than as that of the current element.
If there does not exist an answer for a position, then make the value ‘-1’.

Examples:
Input :  [1,   1, 2, 3, 4, 2,  1]
Output : [-1, -1, 1, 2, 2, 1, -1]
 */