package _03_advance._2022_05_30.stacks_2.live_session;

public class _02_MaxRectangularAreaInHistogram {

    // TC:  O(n), sc: O(n)
    public static int getMaxArea(int[] A){
        int ans = 0;
        int[] prevSmall = _01_NearestElement.nearestSmallOnLeftIDX(A);
        int[] nextSmall = _01_NearestElement.nextSmallerIdx(A);
        for (int i = 0; i < A.length; i++) {
            int height = A[i];
            // get nearest smallest index on left and right
            int left = prevSmall[i];
            int right = nextSmall[i];
            int width = right - left - 1;
            int area = height * width;
            ans = Math.max(ans, area);
        }
        return ans;
    }

    // TC : O(N^2), sc: O(1)
    public static int getMaxAreaSubOptimal(int[] a){
        int ans = 0;
        for (int s = 0; s < a.length; s++) {
            int cur_min = a[s];
            for (int e = s; e < a.length; e++) {
                cur_min = Math.min(cur_min, a[e]);
                int width = e-s+1 ;
                int height = cur_min;
                int area = width * height;
                ans = Math.max(ans, area);
            }
        }
        return ans;
    }

    // TC : O(N^3), sc: O(1)
    public static int getMaxAreaBruteforce(int[] a){
        int ans = 0;
        for (int s = 0; s < a.length; s++) {
            for (int e = s; e < a.length; e++) {
                int width = e-s+1 ;
                int height = getMinFromStoE(a, s, e); // we can minimise this by using carry forward.
                int area = width * height;
                ans = Math.max(ans, area);
            }
        }
        return ans;
    }

    public static int getMinFromStoE(int[] a, int s, int e){
        int ans = Integer.MAX_VALUE;
        for (int i = s; i < e; i++) {
            ans = Math.min(ans, a[i]);
        }
        return ans;
    }
}

/*
given continuous blocks of histogram, find max rectangular area
note : rectangular area should not exceed histogram
 */