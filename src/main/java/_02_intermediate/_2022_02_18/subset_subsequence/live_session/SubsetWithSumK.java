package _02_intermediate._2022_02_18.subset_subsequence.live_session;

/*
sub array : continuous part of array
sub sequence : non-continuous part of array But order matters
sub sets : non-continuous part of array But order does not matters, No repetitions.
 */
public class SubsetWithSumK {
    //TC: 2^n * n (can be further reduced by backtracking and dynamic programming)
    public static boolean solve(int[] A, int B){
        for (int i = 0; i < Math.pow(2, A.length); i++) {
            // for every 'i', check all n bits if it is set or not.
            int sum = 0;
            for (int j = 0; j < A.length; j++) {
                if (checkBit(i, j)){
                    sum += A[j];
                }
            }
            if (sum == B) return true;
        }
        return false;
    }

    public static boolean checkBit(int num, int i){
        return (((num >> i) & 1) == 1);
    }
}

/*
given n distinct elements, check if there exists a subset with sum = k
ex: 3, -1, 0, 6, 2, -3, 5
 */
