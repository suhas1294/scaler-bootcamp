package _01_beginner._2021_12_03.homework;

public class AreaOfSphere {
    public static void main(String[] args) {
        System.out.println(solve(1));
        System.out.println(solve(4));
    }
    public static int solve(int A) {
        return (int)Math.ceil(4 * Math.PI * Math.pow(A, 3) / 3);
    }
}
