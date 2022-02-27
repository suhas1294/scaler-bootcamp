package _02_intermediate._2022_02_04.sorting.live_class;

import utils.Util;

public class _03_SortByNoOfFactors {
    //public static int[] sortByNoOfFactors(int[] arr){}

    public static boolean comparator(int a, int b){
        int f1 = Util.getFactorsCount(a);
        int f2 = Util.getFactorsCount(b);
        if(f1 < f2) {
            return true;
        }else if( f1 > f2){
            return false;
        }else{
            // single line logic : return (a < b);
            if (a < b){
                return true;
            }else{
                return false;
            }
        }
    }
}

/*
given an array, sort in inc order of "number of factors". if the factors are same, lesser element comes first.
cannot use extra space.

ex:
arr: 9,3,4,8,16,37,6,13,15
fac: 3,2,3,4,5, 2, 4, 2, 4
ans: 3,13,37,4,9,6,8,15,16
 */