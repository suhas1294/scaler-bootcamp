package _03_advance._2022_05_25.stacks_1.assignments;

import java.util.HashMap;
import java.util.Stack;

public class InfixExpToPostfixExp {
    public static String solve(String A) {
        Stack < Character > stack = new Stack < > ();
        StringBuilder sb = new StringBuilder();
        HashMap < Character, Integer > map = getPrecedenceMap();
        
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);

            if (c >= 'a' && c <= 'z') {
                sb.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop(); //pop out opening bracket -> '('
            } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                while (!stack.isEmpty() && stack.peek() != '(' && map.get(c) <= map.get(stack.peek())) {
                    sb.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    private static HashMap < Character, Integer > getPrecedenceMap() {
        HashMap < Character, Integer > map = new HashMap < > ();
        map.put('+', 1);
        map.put('-', 1);
        map.put('/', 2);
        map.put('*', 2);
        map.put('^', 3);
        return map;
    }
}

/*

Given string A denoting an infix expression. Convert the infix expression into a postfix expression.
String A consists of ^, /, *, +, -, (, ) and lowercase English alphabets where lowercase
English alphabets are operands and ^, /, *, +, - are operators.
Find and return the postfix expression of A.

NOTE:

    ^ has the highest precedence.
    / and * have equal precedence but greater than + and -.
    + and - have equal precedence and lowest precedence among given operators.


Problem Constraints : 1 <= length of the string <= 500000
Input Format : The only argument given is string A.
Output Format : Return a string denoting the postfix conversion of A.

Input 1: A = "x^y/(a*z)+b"
Input 2: A = "a+b*(c^d-e)^(f+g*h)-i"

Output 1: "xy^az*\/b+"        // Note :  \-> escape character for editor, ignore it as output
Output 2: "abcd^e-fgh*+^*+i-"

Explanation 1: Ouput dentotes the postfix expression of the given input.
 */