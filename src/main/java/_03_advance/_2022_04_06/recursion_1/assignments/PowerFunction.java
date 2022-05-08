package _03_advance._2022_04_06.recursion_1.assignments;

public class PowerFunction {
    public int pow(int A, int B, int C) {
        if (A==0) return 0;
        if (B==0) return 1;
        long he= pow(A,B/2,C);
        long ha= ((he%C)*(he%C))%C;
        if ((B&1)==0) return (int)ha;
        else{
            int x= (int)((ha % C * (long) (A % C))%C);
            if (x < 0){
                return C+(int)((ha % C * (long) (A % C))%C);
            } else{
                return x;
            }
        }
    }
}

/*
Implement pow(A, B) % C.
In other words, given A, B and C, Find (AB % C).
Note: The remainders on division cannot be negative. In other words,
make sure the answer you return is non-negative.

Problem Constraints
-10^9 <= A <= 10^9
0 <= B <= 109
1 <= C <= 109

Input Format : Given three integers A, B, C.
Output Format : Return an integer.

Input : A = 2, B = 3, C = 3, Output : 2, Explanation : 23 % 3 = 8 % 3 = 2
 */