package _03_advance._2022_04_20.binary_search_1.live_session;

// TC : logn
public class _06_SearchInRotatedbyKArray {
    public static boolean searchElement(int[] a, int k, int target){
        int searchResult1 = _01_SearchForElement.searchElement(a, 0, k-1, target);
        int searchResult2 = _01_SearchForElement.searchElement(a, k, a.length-1, target);
        return !(searchResult1 != -1 && searchResult2 != -1);
    }
}

/*
given an array, which is formed by rotating a distinct sorted array by k time (in clock wise),
search for a given element.
ex:  7, 11, 14, 19, 23, 27, -20, -14, -8, -4, 1,2, 4
( originally array : -20, -14, -8, -4, 1,2, 4, 7, 11, 14, 19, 23, 27 is rotated by 6 times)
 */