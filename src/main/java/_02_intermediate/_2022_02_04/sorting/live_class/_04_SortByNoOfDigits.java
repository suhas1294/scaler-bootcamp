package _02_intermediate._2022_02_04.sorting.live_class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class _04_SortByNoOfDigits {
    public static boolean comparator(int a, int b){
        int d1 = noOfDigits(a);
        int d2 = noOfDigits(b);
        if (d1 < d2){
            return true;
        }else if(d1 > d2){
            return false;
        }else{
            if (a < b) {
                return false;
            }else {
                return true;
            }
        }
    }

    private static int noOfDigits(int num) {
        // TODO: implement functionality
        return 0;
    }
}

/*
given an array, sort in inc order of "number of digits". if the same number of digits
larger element comes first. cannot use extra space.

input:  93 2 37 639 8 100
ans:    8, 2, 93, 37, 639, 100

 */