package _02_intermediate._2022_02_14.recursion_1.homeworks;

public class GuessOutput {
    static int bar(int x, int y){
        if (y == 0)   return 0;
        return (x + bar(x, y-1));
    }

    static int foo(int x, int y){
        if (y == 0) return 1;
        return bar(x, foo(x, y-1));
    }

    public static int fun(int x, int n) {
        if (n == 0)
            return 1;
        else if (n % 2 == 0)
            return fun(x * x, n / 2);
        else
            return x * fun(x * x, (n - 1) / 2);
    }

    public static void main(String args[]) {
        // Question - 1
        System.out.println(foo(3,5));

        // Question - 2
        int ans = fun(2, 10);
        System.out.println(ans);

    }
}
