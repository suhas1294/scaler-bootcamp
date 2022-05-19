package _03_advance._2022_04_22.binary_search_2.live_session;

// TC: log n
public class SearchForUniqueElement {
    public static int findUnique(int[] a){
        int n = a.length;
        int l = 0, h = n-1;
        // 3 edge cases:
        if (n == 1) return a[0];
        if (a[0] != a[1]) return a[0];
        if (a[n-1] != a[n-2]) return a[n-1];
        // normal case, binary search
        while (l <= h){
            int m = (l+h)/2;
            if (a[m-1] != a[m] && a[m] != a[m+1]) { // we directly land on unique element
                return a[m];
            }
            if (a[m] == a[m-1]){ // go to right occurence
                m = m-1;
            }
            if (m % 2 == 0){ // even index, go to right
                l = m+2;
            }else{ // odd index, go to left
                h = m-1;
            }
        }
        return -1;
    }
}

/*
given an array of length n, every element occurs twice except one element,
find the unique element , Note : Duplicate element are adjacent to each other

idea-1 : xor all elements, which will take o(n) time.
ex: {3,3,1,1,8,8,10,10,19,6,6,2,2,4,4}, ans : 19

Using binary search we can do it in logn time

 */