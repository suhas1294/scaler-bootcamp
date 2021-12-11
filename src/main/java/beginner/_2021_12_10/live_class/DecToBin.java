package beginner._2021_12_10.live_class;

public class DecToBin {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(decToBin(n));
    }

    public static int decToBin(int n){
        int p = 1;
        int ans = 0;
        while (n > 0){
            int rem = n % 2;
            ans = ans + rem * p;
            System.out.printf("n = %d, rem = %d, p = %d, ans = %d\n", n , rem, p, ans);
            p *= 10;
            n = n/2;
        }
        return ans;
    }
}
