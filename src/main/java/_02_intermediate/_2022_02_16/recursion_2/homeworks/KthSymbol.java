package _02_intermediate._2022_02_16.recursion_2.homeworks;

public class KthSymbol {
    public static int kthGrammar(int n, int k) {
        if(n == 1 && k==1) return 0;
        int mid = (int)Math.pow(2,n-1)/2;
        //System.out.printf("n = %d, k = %d, mid = %d, k <= mid = %d <= %d\n", n, k, mid, k, mid);
        if(k <= mid){
            return kthGrammar(n-1, k);
        }
        return 1 - kthGrammar(n-1, k-mid);
    }
}

/*
On the first row, we write a 0. Now in every subsequent row, we look at the previous row and
replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
Given row n and index k, return the kth indexed symbol in row n. (The values of k are 1-indexed.) (1 indexed).

1 <= n <= 20
1 <= k <= 2^(A - 1)

Input Format : First argument is an integer n. Second argument is an integer k.
Output Format : Return an integer denoting the kth indexed symbol in row n.

Input 1: n = 2 k = 1 , output: 0
Explanation 1: Row 1: 0 Row 2: 01

Input 2: n = 2 k = 2 , output: 1
Explanation 2: Row 1: 0 Row 2: 01
 */