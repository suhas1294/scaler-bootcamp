package _02_intermediate._2022_02_06.strings.assignments;

public class ReverseString {
    public static String reverseWord(String A) {
        String[] letters = A.split("");
        int start = 0, end = letters.length-1;
        while (start < end){
            String temp = letters[start];
            letters[start] = letters[end];
            letters[end] = temp;
            start++;
            end--;
        }
        return String.join("", letters);
    }
}
