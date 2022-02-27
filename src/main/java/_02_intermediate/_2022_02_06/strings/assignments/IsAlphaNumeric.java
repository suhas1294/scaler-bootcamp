package _02_intermediate._2022_02_06.strings.assignments;

//a-z : 97 to 122
//A-Z : 65 to 90
// to convert to lower case, just to +32

public class IsAlphaNumeric {
    public static int isAlphaNumeric(char[] A) {
        boolean isCaps, isLower, isNumeric;
        for (int i = 0; i < A.length; i++) {
            isCaps = A[i] >= 65 && A[i] <= 90;
            isLower = A[i] >= 97 && A[i] <= 122;
            isNumeric = A[i] >= 48 && A[i] <= 57;
            if (!(isCaps || isLower || isNumeric)){
                return 0;
            }
        }
        return 1;
    }
    public static int isAlpha(char[] A) {
        boolean isCaps, isLower;
        for (int i = 0; i < A.length; i++) {
            isCaps = A[i] >= 65 && A[i] <= 90;
            isLower = A[i] >= 97 && A[i] <= 122;
            if (!(isCaps || isLower)){
                return 0;
            }
        }
        return 1;
    }
}
