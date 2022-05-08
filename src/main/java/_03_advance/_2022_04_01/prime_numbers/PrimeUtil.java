package _03_advance._2022_04_01.prime_numbers;

public class PrimeUtil {
    public static boolean isPrime(int n){
        int c = 0;
        for (int i = 1; i <= Math.ceil(Math.sqrt(n)); i++) {
            if (n % i == 0){
                c = (i == n/i) ? c + 1 : c + 2;
            }
        }
        return c == 2;
    }

    // more cleaner solution
    public boolean isPrime2(int N){
        if(N<2) return false;
        for(int i = 2; i * i <= N; i++){
            if(N % i == 0) return false;
        }
        return true;
    }
}
