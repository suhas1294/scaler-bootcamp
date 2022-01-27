package _02_intermediate._2022_01_24.bit_manipulation.assignments;

public class AddBinaryStrings {
    public static String addBinary(String A, String B) {
        String[] ad = A.split("");
        String[] bd = B.split("");
        int carry = 0;
        String result = "";
        int i = ad.length-1, j = bd.length-1;
        for (; i >= 0 && j >= 0; i--, j--) {
            int sum = Integer.parseInt(ad[i]) + Integer.parseInt(bd[j]) + carry;
            int value = sum % 2;
            carry  = sum/2;
            result = value + result;
        }
        if (i >= 0){
            while (i >= 0){
                int sum = Integer.parseInt(ad[i]) + carry;
                result = sum%2 + result;
                carry = sum/2;
                i--;
            }
        }
        if(j >= 0){
            while (j >= 0){
                int sum = Integer.parseInt(bd[j]) + carry;
                result = sum%2 + result;
                carry = sum/2;
                j--;
            }
        }
        if(carry > 0){
            result = carry + result;
        }
        return result;
    }

    public static void main(String[] args) {
        String[][] inputs = {
                {"100", "11", "111"},
                {"1", "1", "10"},
                {"11", "1", "100"},
                {"1010110111001101101000", "1000011011000000111100110", "1001110001111010101001110"},
                {"110100001010010000110110100001", "100100111000111011110011011111111001101011111110101011001111110110001101010001011110011", "100100111000111011110011011111111001101011111110101011010110010111011111011000010010100"}
        };
        for (String[] input : inputs) {
            String actualOutput = addBinary(input[0], input[1]);
            if (!actualOutput.equalsIgnoreCase(input[2])){
                System.out.printf("expected %s\ngot\t\t%s\ninputs : \n%s\n%s\n\n", input[2], actualOutput, input[0], input[1]);
            }
        }
    }
}


/*
Given two binary strings, return their sum (also a binary string).
a = "100"
b = "11"
Return a + b = "111".

 */