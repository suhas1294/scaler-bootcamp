package _03_advance._2022_07_11.backtracking_1.live_session;

import java.util.Arrays;

public class NDigitsFormedBy1and2 {
    // tc : O(2^n*n) , sc : n + n (one for array and one more for call stack size in recursion)
    static void printAll(int a[], int n, int i){
        if (i == n){                // base condition
            System.out.println(Arrays.toString(a));
            return;
        }
        a[i] = 1;                   // make change
        printAll(a, n , i+1);     // call function
        a[i] = 2;                   // revert changes
        printAll(a, n, i+1);      // call function
    }

    public static void main(String[] args) {
        int n = 3;
        int[] a = new int[n];
        printAll(a, n, 0);
    }

    // similar question : given n, print all n digit numbers formed by digits {1,2,3,4,5} in increasing order
    // TC: O(5^n * n n for printing full array), sc : n + n
    static void printAll12345(int a[], int n, int i){
        /*if (i == n){
            System.out.println(Arrays.toString(a));
            return;
        }
        a[i] = 1;
        printAll(a, n , i+1);
        a[i] = 2;
        printAll(a, n, i+1);
        a[i] = 3;
        printAll(a, n , i+1);
        a[i] = 4;
        printAll(a, n, i+1);
        a[i] = 5;
        printAll(a, n, i+1);*/
        for (int v = 1; v <= 5; v++) {
            a[i] = v;
            printAll(a, n, i+1);
        }
    }
}


/* given n digits, print all n digit numbers formed by using only 1 and 2
in  increasing order of numbers,
ex, n = 3, output :
111
112
121
122
211
212
221
222

note  : solving this using bit masking will take O(2^n * n) as TC
*/
