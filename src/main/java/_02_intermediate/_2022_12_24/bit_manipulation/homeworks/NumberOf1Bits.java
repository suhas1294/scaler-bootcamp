package _02_intermediate._2022_12_24.bit_manipulation.homework;

public class NumberOf1Bits {
    public static int numSetBits(int A) {
        int count = 0;
        while (A > 0){
            if (A % 2 == 1) count++;
            A = A/2;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numSetBits(11));
    }
}

/*
Write a function that takes an integer and returns the number of 1 bits it has.
1 <= A <= 10^9
input format: First and only argument contains integer A
output format: Return an integer as the answer
input : 11, output: 3, explanation: 11 is represented as 1011 in binary.
 */