package beginner._2021_12_17.homework;

import java.util.Scanner;

/*
You are given a string A.
Find the number of indices where the reverse of the given string and the original string are different.
1 <= Length of String A <= 10^5
input format : The first argument is the string A.
output format : Return an integer denoting the number of indices where the reverse and the original string are different.
input 1 : A = scaler, output : 6
explanation: The reversed form of scaler is relacs. We can see that all the corresponding indices are different. So, the answer is 6.
input 1 : A = kayak, output: 0
explanation: The given string is a palindrome, which means the reverse is equal to the original. So, no indices have different characters.

*/
public class ChangesInReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.next();
        int cnt = 0, left = 0, right = A.length()-1;
        while (left < right){
            if (A.charAt(left) != A.charAt(right)){
                cnt++;
            }
            left++;
            right--;
        }
        System.out.println(cnt*2);
    }
}
