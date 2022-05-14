package _03_advance._2022_04_13.sorting_2.live_session;

// TC: O(n log n), sc: O(n)
public class _02_InversionCount {
    public static int inversionCount(int[] a, int s, int e){
        if(s == e) return 0;
        int mid = (s + e)/2;
        int l = inversionCount(a, s, mid);
        int r = inversionCount(a, mid+1, e);
        int c = mergeInv(a, s, mid, e);
        return l + r + c;
    }

    // regular merge function from merge sort except little tweaks
    private static int mergeInv(int[] arr, int s, int m, int e){
        int[] tmp = new int[e-s+1];
        int c = 0; // tweak-1
        int p1 = s, p2 = m + 1, p3 = 0;
        while (p1 <= m && p2 <= e){
            if (arr[p1] <= arr[p2]){
                tmp[p3] = arr[p1]; p1++;p3++;
            }else {
                tmp[p3] = arr[p2]; p2++;p3++;
                c = c + (m- p1 + 1); // tweak-2
            }
        }
        while (p1 <= m){
            tmp[p3] = arr[p1];
            p1++;
            p3++;
        }
        while (p2 <= e){
            tmp[p3] = arr[p2];
            p2++;
            p3++;
        }
        for (int i = 0; i <= e-s ; i++) {
            arr[i+s] = tmp[i];
        }
        return c;
    }
}

/*
Given arr[n], find no of pairs of [i,j] such that i < j and a[i] > a[j]
ex: input: {6,2,9,3,5}, output : 5 pairs
ex: input: {10, 3, 8, 15, 16, 12, 2, 18, 7, 1}, output : 26 pairs

Brute force idea: check al pairs in two level nested loop, tc: O(n^2), sc: O(1)
efficient solution: split array into two parts, say A and B, then it will become similar to prev problem
(total pairs in A) + (total pairs in B) + (total pairs between A & B)
 */