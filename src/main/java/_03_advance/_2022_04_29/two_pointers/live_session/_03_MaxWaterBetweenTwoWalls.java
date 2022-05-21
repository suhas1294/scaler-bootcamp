package _03_advance._2022_04_29.two_pointers.live_session;

public class _03_MaxWaterBetweenTwoWalls {
    public static int getMaxWaterVolume(int[] A){
        int n =A.length, p1 = 0, p2 = n-1, ans = 0;
        while (p1 < p2){
            int height = Math.min(A[p1], A[p2]);
            int width = p2 - p1; // x-axis
            int vol = height * width;
            ans = Math.max(ans, vol);
            if (A[p2] < A[p1]){
                p2--;
            }else if(A[p1] < A[p2]){
                p1++;
            }else { // A[p1] == A[p2]
                p1++;
                p2--;
            }
        }
        return ans;
    }


    // bruteforce, TC: O(n^2), sc: O(1)
    public static int getMaxWaterVolumeBF(int[] a){
        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                int height = Math.min(a[i], a[j]);
                int width = j - i;
                int area = height * width;
                ans = Math.max(ans, area);
            }
        }
        return ans;
    }
}

/*
given an array of size n where a[i] represents height of each wall.
pick any 2 walls such that max water is accumulated between them.
ex: {3,7,4,5,2}, ans : 10, walls : 5 and 7
*/