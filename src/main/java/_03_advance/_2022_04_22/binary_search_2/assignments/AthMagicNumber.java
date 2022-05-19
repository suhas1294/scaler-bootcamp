package _03_advance._2022_04_22.binary_search_2.assignments;

public class AthMagicNumber {
    public static int solve(int A, int B, int C) {
        long lcm=(long) B*C/gcd(B,C);
        long low=Math.min(B,C), high=(long) Math.min(B,C)*A, ans=2;
        while(low<=high){
            long mid=low+((high-low)/2);
            long cntb=mid/B;
            long cntc=mid/C;
            long cntbc=mid/lcm;

            if(cntb + cntc - cntbc>=A){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return (int)(ans%1000000007);
    }

    static int gcd(int x, int y){
        if(x==0){
            return y;
        }

        return gcd(y%x,x);
    }
}

/*
You are given three positive integers, A, B, and C.
Any positive integer is magical if divisible by either B or C.
Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.

Problem Constraints
1 <= A <= 10^9
2 <= B, C <= 40000

Input Format
The first argument given is an integer A.
The second argument given is an integer B.
The third argument given is an integer C.

Output Format
Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.

Input 1: A = 1 B = 2 C = 3, Output 1: 2
Input 2: A = 4 B = 2 C = 3, Output 2: 6

Explanation 1: 1st magical number is 2.
Explanation 2: First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.
 */