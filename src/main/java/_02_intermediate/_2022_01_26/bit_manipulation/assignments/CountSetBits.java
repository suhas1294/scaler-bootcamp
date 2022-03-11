package _02_intermediate._2022_01_26.bit_manipulation.assignments;

// refer notes from feb 27th, last page.
// how many set bits are there, that much +1 operations we need to make.
public class CountSetBits {
    // check how many bits are set
    public static int solve(int A) {
        int counter = 0;
        while (A > 0) {
            if ((A & 1) == 1) counter++;
            A = A >> 1;
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(solve(5));
    }
}

/*
problem-1:
Alex and Sam are very good friends. Alex is doing programming a lot these days.
He has set a target A for himself. Initially, Alex score is zero. Alex can only double
his score by doing a question or Alex can seek help from Sam for doing questions which
will contribute 1 to Alex score. Alex wants his score to be exactly A. Also,
he does not want to take much help from Sam.
Find and return the minimum number of times Alex needs to take help from Sam to
achieve a score of exactly A.

The only argument given is integer A.
Return the minimum number of times help taken from Sam.
0 <= A <= 10^9

Input 1:
    A = 5
Output 1:
    2
    Initial score : 0
    Takes help from Sam, score : 1
    Alex solves a question, score : 2
    Alex solves a question, score : 4
    Takes help from Sam, score: 5

Input 2:
    A = 3
Output 2:
    2
    Initial score : 0
    Takes help from Sam, score : 1
    Alex solves a question, score : 2
    Takes help from Sam, score : 3s

____________________________________

problem-2:
Arjun has a cat called Boomer. He decides to put his cat to the test for eternity.
He starts on day 1 with a stash of food unit, every next day the stash doubles.
If Boomer is well behaved during a certain day, she receives food worth equal to the stash on that day.
Boomer receives a net worth of A units of food. What is the number of days he was well behaved?

1 <= A <= 2^32-1
input format: First and only argument is an integer A.
output format: Return an integer denoting the number of days Boomer was well behaved.

Input 1: A = 5, output : 2, explanation: To eat a total of 5 units of food, Boomer behaved normally on Day 1 and on the Day 3.
Input 2: A = 8, output : 1, explanation: To eat a total of 8 units of food, Boomer behaved normally only on day 4.
 */