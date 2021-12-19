package beginner._2021_12_17.homework;

/*
You are given a lowercase latin alphabetic character C. You have to tell whether it is a vowel or not.
The characters 'a', 'e', 'i', 'o', and 'u' are called vowels.
C ∈ ['a' - 'z']
The input consists of a single character C.
Print 1 if the given character is a vowel, else print 0.

Input 1:a
Input 2: b
Output 1:1
Output 2:0
Explanation 1:'a' is a vowel.
Explanation 2:'b' is a consonant (not a vowel).
*/

import java.util.Scanner;

public class VowelOrConsonent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String C = scanner.next();
        switch (C){
            case "a":
            case "e":
            case "i":
            case "o":
            case "u":
                System.out.println(1);
                break;
            default:
                System.out.println(0);
        }

    }
}
