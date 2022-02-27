package _02_intermediate._2022_02_04.sorting.live_class;

import java.util.Arrays;

public class _02_CountNobleIntegers {
    // distinct integers in array
    public static int getCountOfNobleInt(int[] arr){
        int ans = 0;
        Arrays.sort(arr);
        if(arr[0] > 0) return 0; // if a[0] > 0, then no noble elements (after sorting)
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i) ans++;
        }
        return ans;
    }

    // duplicate integers in array, {0,2,2,4,4,6}
    public static int getCountOfNobleIntDuplicate(int[] arr){
        int ans = 0;
        int less = 0;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i-1]) {
                less = i;
            } // else less will not change, no need to do anything
            if (arr[i] == less) ans++;
        }
        if (arr[0] == 0) ans++;
        return ans;
    }
}

/*
    count number of noble integers in given array
    question can be of two types : arr has distinct integers and duplicate integers
    arr[i] number is set ot be noble if
    arr[i] = no of elements < arr[i]

    ex: arr = [1, -5, 3, 5, -10, 4]
    numbers less then 1 : 2
    numbers less then -5 : 1
    numbers less then 3 : 3     (nobel)
    numbers less then 5 : 5     (nobel)
    numbers less then -10 : 0
    numbers less then 4 : 4     (nobel)

    ex2:
    arr:    -3, 0, 2, 5
    less:   0, 1, 2, 3
    number of nobel elements : 1

    answer : when array is sorted, count of less  = index

    arr:    -10 1 1 1 4 4 4 7 10
    less:     0 1 1 1 4 4 4 7 8
    idx:      0 1 2 3 4 5 6 7 8
    ans : 7

    arr:    -3 0 2 2 5 5 5 5 8 8 10 10 10 14
    less:    0 1 2 2 4 4 4 4 8 8 10 10 10 13
    idx:     0 1 2 3 4 5 6 7 8 9 10 11 12 13
    ans :

    obs 1 : if element is same, less is same
    obs 2 : if element is diff from prev element, less = idx

 */
