package _02_intermediate._2022_02_25.stacks_queues.assignments;

import java.util.Stack;

public class BalancedParanthesis {
    // homework problem
    public static int solve(String A) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            char letter = A.charAt(i);
            if (letter == '(' || letter == '{'|| letter == '['){
                stack.push(String.valueOf(letter));
            }else if(!stack.isEmpty() &&
                    (letter == ')' && stack.peek().equals("(")) ||
                    (letter == '}' && stack.peek().equals("{")) ||
                    (letter == ']' && stack.peek().equals("["))
            ){
                stack.pop();
            } else if (stack.isEmpty() &&
                    (letter == ')' || letter == '}' || letter == ']')
            ){
                return 0;
            }
        }
        return stack.isEmpty() ? 1  : 0;
    }

    // assignment problem
    public static int solve2(String A) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '('){
                stack.push("(");
            }else if(!stack.isEmpty() && A.charAt(i) == ')' && stack.peek().equals("(")){
                stack.pop();
            } else if (stack.isEmpty() && A.charAt(i) == ')'){
                return 0;
            }
        }
        return stack.isEmpty() ? 1  : 0;
    }

    public static void main(String[] args) {
        //System.out.println(solve2(")(("));
        System.out.println(solve("}}}}}}}}}}}}}}}}}}"));
    }
}

/*
Given a string A consisting only of '(' and ')'.
You need to find whether parentheses in A are balanced or not, if it is balanced then return 1 else return 0.

Problem Constraints
1 <= |A| <= 10^5

Input Format : First argument is an string A.
Output Format : Return 1 if parantheses in string are balanced else return 0.

Input 1: A = "(()())"
Output 1: 1
Explanation 1: Given string is balanced so we return 1.

Input 2: A = "(()"
Output 2: 0
Explanation 2: Given string is not balanced so we return 0.
 */