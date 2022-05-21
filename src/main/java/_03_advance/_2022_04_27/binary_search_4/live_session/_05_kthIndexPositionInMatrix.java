package _03_advance._2022_04_27.binary_search_4.live_session;

// note : return the value, not the index. matrix is sorted row wise only,
// i.e., (matrix is not completely sorted)
// TC : log(h-l+1) * n * log m, sc: O(1)
// Since we can find kth position, we can find mean of a
// 1. array
// 2. sorted arrays
// 3. matrix
public class _05_kthIndexPositionInMatrix {
    public static int kthIdxPosInMergedArray(int[][] mat, int k){
        int rows = mat.length, cols = mat[0].length, ans = 0;

        // for low, get least value in 1st column
        int l = Integer.MAX_VALUE, h = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            l = Math.min(l, mat[i][1]);
        }
        // for high, get highest value in last column
        for (int i = 0; i < rows; i++) {
            h = Math.max(l, mat[i][cols-1]);
        }

        while (l <= h){
            int mid = (l + h) / 2;
            int c = 0 ;
            for (int i = 0; i < rows; i++) {
                c = c + countLessThenKElementsBS(mat[i], mid);
            }
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
        System.out.println(kthIdxPosInMergedArray(new int[][]{a,b}, 10));
    }
}

/*
given a matrix, find kth index position in flattened and sorted matrix.
 */