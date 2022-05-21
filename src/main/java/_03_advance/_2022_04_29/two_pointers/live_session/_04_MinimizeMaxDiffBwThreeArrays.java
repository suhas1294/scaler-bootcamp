package _03_advance._2022_04_29.two_pointers.live_session;

// Class name is not appropriate
// TC: O(n), sc O(1)
public class _04_MinimizeMaxDiffBwThreeArrays {
    public static int getMinValue(int[] a, int[] b, int[] c){
        int n = a.length;
        int p1 = 0, p2 = 0, p3 = 0, ans = 0;
        while (p1 < n && p2 < n && p3 < n){
            int max = Math.max(a[p1], Math.max(b[p2], c[p3])); // max of (p1, p2, p3 values)
            int min = Math.min(a[p1], Math.min(b[p2], c[p3])); // min of (p1, p2, p3 values)
            int diff = max - min;
            ans = Math.min(ans, diff);
            //whichever value is least, increment its pointer.
            if (a[p1] < b[p2] && a[p1] < c[p3]){
                p1++;
            }else if(b[p2] < a[p1] && b[p2] < c[p3]){
                p2++;
            }else if(c[p3] < a[p1] && c[p3] < b[p2]){
                p3++;
            }
        }
        return ans;
    }
}

/*
given 3 sorted arrays : a[], b[], c[] - all of same size 'n', find i, j and k such that:
[Max(a[i],b[j],c[k]) - Min(a[i],b[j],c[k])]  value is minimized.
return the minimum value , not i, j k pointers values.
 */