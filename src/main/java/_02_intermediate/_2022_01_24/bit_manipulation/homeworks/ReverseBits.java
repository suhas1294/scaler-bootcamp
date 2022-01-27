package _02_intermediate._2022_01_24.bit_manipulation.homework;

public class ReverseBits {
    public static long reverse(long a) {
        int powerCounter = 0;
        long remainder, total = 0;
        while(a > 0){
            remainder = a % 2;
            if (remainder == 1){
                total += (long) Math.pow(2, (32-1-powerCounter));
            }
            powerCounter++;
            a = a / 2;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(reverse(3)); //3221225472
    }
}

/*
Reverse the bits of an 32 bit unsigned integer A.

0 <= A <= 2^32
input format: First and only argument of input contains an integer A.
output format: Return a single unsigned integer denoting the decimal value of reversed bits.

input 1:  0, output 1: 0,
explanation:
0 representation in binary : 00000000000000000000000000000000
reverse it =>      00000000000000000000000000000000
convert it to decimal, 0
input 1:  3, output 1: 3221225472,
explanation:
3 representation in binary : 00000000000000000000000000000011
reverse it =>      11000000000000000000000000000000
conver it to decimal : 3221225472

 */