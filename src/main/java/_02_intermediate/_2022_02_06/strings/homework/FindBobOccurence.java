package _02_intermediate._2022_02_06.strings.homework;

public class FindBobOccurence {
    public static int solve(String A) {
        String targetString = "bob";
        int cnt = 0;
        for (int i = 0; i <= A.length()- targetString.length(); i++) {
            String curSubstring = A.substring(i, i + targetString.length());
            if (curSubstring.equals(targetString)){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(solve("bobob"));
    }
}

/*
Find number of occurrences of bob in the string A consisting of lowercase english alphabets.
1 <= |A| <= 1000
input format: The first and only argument contains the string A consisting of lowercase english alphabets.
output format: Return an integer containing the answer.
input 1: "abobc", output : 1, exp: The only occurrence is at second position.
input 1: "bobob", output : 2, exp: Bob occures at first and third position.
 */