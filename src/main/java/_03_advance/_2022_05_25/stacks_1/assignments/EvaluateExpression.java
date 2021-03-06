package _03_advance._2022_05_25.stacks_1.assignments;

import java.util.Stack;

public class EvaluateExpression {
    public static int evalRPN(String[] A) {
        Stack<Integer> stack = new Stack<>();

        for (String opr : A) {
            if (opr.equals("+") || opr.equals("-") || opr.equals("*") || opr.equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (opr) {
                    case "+":
                        int sum = num1 + num2;
                        stack.push(sum);
                        break;
                    case "-":
                        int diff = num2 - num1;
                        stack.push(diff);
                        break;
                    case "*":
                        int mult = num1 * num2;
                        stack.push(mult);
                        break;
                    case "/":
                        int div = num2 / num1;
                        stack.push(div);
                }
            } else {
                stack.push(Integer.parseInt(opr));
            }
        }

        return stack.pop();
    }
}

/*
An arithmetic expression is given by a character array A of size N.
Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /. Each character may be an integer or an operator.

Problem Constraints :  1 <= N <= 10^5
Input Format : The only argument given is character array A.
Output Format : Return the value of arithmetic expression formed using reverse Polish Notation.

Input 1: A =   ["2", "1", "+", "3", "*"], Output 1: 9

Explaination 1:
    starting from backside:
    * : () * ()
    3 : () * (3)
    + : (() + ()) * (3)
    1 : (() + (1)) * (3)
    2 : ((2) + (1)) * (3)
    ((2) + (1)) * (3) = 9

Input 2: A = ["4", "13", "5", "/", "+"], Output 2: 6

Explaination 2:
    + : () + ()
    / : () + (() / ())
    5 : () + (() / (5))
    13 : () + ((13) / (5))
    4 : (4) + ((13) / (5))
    (4) + ((13) / (5)) = 6
 */