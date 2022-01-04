package _01_beginner._2021_12_03.homework;

public class AreaOfCircle {
    public static void main(String[] args) {
        System.out.println(solve(4));
        System.out.println(solve(1));
    }
    public static int solve(int A) {
        return (int)Math.ceil(Math.PI * A * A);
    }
}
