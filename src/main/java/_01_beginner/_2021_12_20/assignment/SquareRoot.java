package _01_beginner._2021_12_20.assignment;

public class SquareRoot {
    public static void main(String[] args) {
        //System.out.println(sqrt4(930675566));
        System.out.println(sqrt3(1332));
    }

    // most efficient way
    // credits: https://medium.com/edureka/java-sqrt-method-59354a700571
    public static int sqrt4(int A){
        if (A == 0) return 0;
        if (A == 1) return 1;
        double t;
        double squareroot = A / 2;
        do {
            t = squareroot;
            squareroot = (t + (A / t)) / 2;
        }
        while ((t - squareroot) != 0);
        return (int)Math.floor(squareroot);
    }

    // using binary search  recursive way
    public static int sqrt(int A, int start, int end, int ans){
        if (A == 0 || A == 1) return A;
        int mid = (start + end)/2;
        System.out.printf("start=%d\t\t\tend=%d\tmid=%d\tmid*mid=%d\n", start, end, mid, mid*mid);
        if (start >= end) return ans;
        if (mid * mid == A) return mid;
        if (mid * mid < A) {
            ans = mid;
            return sqrt(A, mid+1, end, ans);
        }else {
            return sqrt(A, start, mid-1, ans);
        }
    }

    // Babylonian algorithm
    public static int sqrt(int A) {
        float x = A;
        float y = 1;

        double e = 0.000001; // e decides the accuracy level
        while (x - y > e) {
            x = (x + y) / 2;
            y = A / x;
        }
        System.out.println(x);
        return (int)Math.floor(x);
    }

    // using power function
    public static int sqrt2(int A) {
        return (int)Math.floor(Math.pow(A, (1/2)));
    }

    // using binary search - iterative way
    public static int sqrt3(int A) {
        if (A == 0 || A == 1) return A;
        int start = 1, end = A, ans=0;
        while (start <= end){
            int mid = (start + end) / 2;
            //System.out.printf("start=%d\t\t\tend=%d\tmid=%d\tmid*mid=%d\n", start, end, mid, mid*mid);
            if (mid*mid == A) return (int)mid;
            if (mid*mid < A) {
                start = mid + 1;
                ans = mid;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

}
