package _03_advance._2022_04_27.binary_search_4.live_session;

// note : return the value, not the index.
// TC : log(h-l+1) * (log n + log m)
public class _04_kthIndexPositionInMergedArray {
    public static int kthIdxPosInMergedArray(int[] a, int[] b, int k){
        int n = a.length, m = b.length, ans = 0;
        int l = Math.min(a[0], b[0]);
        int h = Math.max(a[n-1], b[m-1]);
        while (l <= h){
            int mid = (l + h) / 2;
            // calculate no of elements less then mid in both arrays.
            int c = countLessThenKElementsBS(a, mid); // (log n)
            c = c + countLessThenKElementsBS(b, mid); // (log m)
            if (c > k) {
                h = mid-1;
            }else{
                ans = mid;
                l = mid + 1;
            }
        }
        return ans;
    }

    public static int countLessThenKElementsBS(int[] a, int k){
        int ans = 0, l = 0, h = a.length-1;
        while (l <= h){
            int m = (l + h) / 2;
            //System.out.printf("l : %d, h %d, mid = %d\n", l,h, m);
            if (a[m] < k){ // go right
                ans = m;
                l = m+1;
            }else{
                h = m - 1;
            }
        }
        return ans+1;
    }

    public static void main(String[] args) {
        int[] a = {2,5,6,11, 19,45, 79};
        int[] b = {1, 2, 4, 5, 8, 10};
        //System.out.println(countLessThenKElementsBS(a, 20));
        //System.out.println(countLessThenKElementsBS(b, 11));
        System.out.println(kthIdxPosInMergedArray(a, b, 10));
    }
}

/*
given 2 sorted arrays, find kth index position in merged array
 */