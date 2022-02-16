package _02_intermediate._2022_01_26.bit_manipulation.homework;

public class UnsetXBitsFromRight {
    public static long solve(long A, int B) {
        // step-1 : in last B bits, check how many of them are already set - say cnt = 3
        long copyOfA = A;
        int cnt = 0;
        for (int i = 0; i < B; i++) {
            if((copyOfA & 1) == 1) cnt++;
            copyOfA = copyOfA >> 1;
        }
        System.out.println("set count " + cnt);
        // step-2 : for cnt number of times, do n = (n & n-1) : this step is to unset the right most bit
        for (int i = 0; i < cnt; i++) {
            A = (A & (A-1));
        }
        return A;
    }

    public static void main(String[] args) {
        System.out.println(solve(93, 4));
        System.out.println(solve(25, 3));
        System.out.println(solve(37, 3));
    }
}

/*
Given an integer A. Unset B bits from the right of A in binary.
For eg:-
A = 93, B = 4
A in binary = 1011101
A should become = 1010000 = 80. Therefore return 80.

1 <= A <= 10^18
1 <= B <= 60

The first argument is a single integer A.
The second argument is a single integer B.
Return the number with B unset bits from the right.

Input 1: A = 25 B = 3, output : 24, explanation: A = 11001 to 11000
Input 2: A = 37 B = 3, output: 32, explanation: A = 100101 to 100000
 */