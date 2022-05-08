package _03_advance._2022_04_04.Combinatorics.assignment;

public class FindCombinationPrimeRepeated {

    public static int solve(int A, int B, int C){
        if(A<B) return 0;
        if(B==0) return 1;
        //As considering 1 as prime
        if(C==1) return 0;

        long aFact=fact(A,C);
        int bFact=(int)fact(B, C);

        int aminusbFact=(int)fact((A-B), C);
        long y=((long)inverMod(bFact,C)%C * inverMod(aminusbFact ,C)%C)%C;
        return (int)((aFact %C*y )%C);
    }

    public static int power(int A, int B, int C) {
        if(A==0) return 0;
        if(B==0)return 1;
        if(B==1)return A%C;
        long y = power(A,B/2,C);
        if(B%2==0){
            y = (y*y)%C;
            y = y%C;
        }else{
            y = A%C;
            y = (y%C*power(A,B-1,C)%C)%C;
        }

        return (int)(y%C);
    }

    //Calculating Inverse Mod
    static int inverMod(int A,int m){
        return power(A,(m-2),m);
    }

    //Calculating Factorial
    public static long fact(int n, long mod){
        if(n==0) return 1;
        long facto=1;
        for(int i=1;i<=n;i++){
            facto = (facto*i)%mod;
        }
        return facto % mod;
    }


}

/*
Given three integers A, B, and C, where A represents n, B represents r, and C represents p and
p is a prime number greater than equal to n, find and return the value of nCr % p
where nCr % p = (n! / ((n-r)! * r!)) % p.

x! means factorial of x i.e. x! = 1 * 2 * 3... * x.

NOTE: For this problem, we are considering 1 as a prime.

Problem Constraints
1 <= A <= 10^6
1 <= B <= A
A <= C <= 10^9+7

Input Format
The first argument given is the integer A ( = n).
The second argument given is the integer B ( = r).
The third argument given is the integer C ( = p).

Output Format
Return the value of nCr % p.

Input 1: A = 5 B = 2 C = 13 Output 1: 10,
explanaiton: nCr( n=5 and r=2) = 10. p=13. Therefore, nCr%p = 10.

Input 2: A = 6 B = 2 C = 13,output : 2
 */