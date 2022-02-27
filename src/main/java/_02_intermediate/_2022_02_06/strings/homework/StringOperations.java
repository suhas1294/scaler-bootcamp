package _02_intermediate._2022_02_06.strings.homework;

//a-z : 97 to 122
//A-Z : 65 to 90
// to convert to lower case, just to +32
public class StringOperations {
    public static String solve(String A) {
        String concatenatedString = A + A;
        char[] letters = concatenatedString.toCharArray();
        StringBuilder ans = new StringBuilder();
        for (char letter : letters) {
            if (!(letter >= 65 && letter <= 90)) {
                switch (letter) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        ans.append("#");
                        break;
                    default:
                        ans.append(letter);
                }
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(solve("AbcaZeoB"));
    }
}

/*
Akash likes playing with strings. One day he thought of applying following operations on
the string in the given order:

Concatenate the string with itself.
Delete all the uppercase letters.
Replace each vowel with '#'.
You are given a string A of size N consisting of lowercase and uppercase alphabets.
Return the resultant string after applying the above operations.
NOTE: 'a' , 'e' , 'i' , 'o' , 'u' are defined as vowels.

1<=N<=100000

input format: First argument is a string A of size N.
output format: Return the resultant string.
ex: input : A="AbcaZeoB", output: "bc###bc###"
exp: First concatenate the string with itself so string A becomes "AbcaZeoBAbcaZeoB".
Delete all the uppercase letters so string A becomes "bcaeobcaeo".
Now replace vowel with '#'.
A becomes "bc###bc###".
 */