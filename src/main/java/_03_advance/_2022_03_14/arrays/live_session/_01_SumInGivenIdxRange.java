package _03_advance._2022_03_14.arrays.live_session;

public class _01_SumInGivenIdxRange {
    public static void solve(int[] arr, int[][] queries){
        // step-1 : construct prefix array
        int[] pf = new int[arr.length];
        pf[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            pf[i] = pf[i-1] + arr[i];
        }

        // step-2 : loop through queries and get their sum
        for (int[] query: queries) {
            if (query[0] != 0){
                int sum = pf[query[1]] - pf[query[0]-1] ;
                System.out.println("sum from i to j :" + sum);
            }else{
                System.out.println("sum from i to j :" + pf[query[1]]);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, -1, 5, 6, 8, 2, 3, 2, 6};
        int[][] queries = {
                {1, 4}, // calculate sum from idx 1 to 4 both inclusive
                {3, 6},
                {1, 7}
        };
        solve(arr, queries);
    }
}
