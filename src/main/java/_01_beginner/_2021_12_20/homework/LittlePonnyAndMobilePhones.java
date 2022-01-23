package _01_beginner._2021_12_20.homework;

import utils.Util;

import java.util.ArrayList;

/**
 *
 * Little pony is going to buy some mobile phones for his friends.
 * As there many models available in the market at different prices,
 * He is confused and wants to know the maximum distinct models of a mobile phone
 * he can buy for his friends, given that he has a total X amount of money.
 * You are given an array A of size N. denoting the size of prices of different models.
 * The array is sorted based on prices in increasing order.
 * You are given another array B of size Q denoting the queries.
 * In i'th query, you need to tell the maximum distinct models of mobile phones he can buy with B[i] money.
 * 1 <= N, Q <= 10^5
 * 1 <= A[i] <= 10^4
 * 1 <= B[i] <= 10^9
 *
 * Input format
 * The 1st argument of the input is the array A.
 * The 2nd argument of the input is the array B containing the description of the queries.
 *
 * output format:
 * Your function should return the answer to all queries in an array (in the same order they were
 * asked in the input).
 *
 * ex : inuput 1:
 *  A: [3, 4, 4, 6]
 *  B: [20, 4, 10, 2]
 *  output : [4, 1, 2, 0]
 *
 *  explanation:
 *
 For the 1st query, he has 20 amount of money and he can buy the phones in just 3 + 4 + 4 + 6 = 17 rupees.
 For the 2nd query, he has 4 amount of money and he can buy any the second or first phone .
 For the 3rd query, he has 10 amount of money and he can buy the third and fourth phone in 6 + 4 = 10 amount of money
 For the 2nd query, he has 2 amount of money and he can't buy any phone with it
 *
 * */

public class LittlePonnyAndMobilePhones {


    public static void main(String[] args) {
        int[] A = {3, 4, 4, 6};
        int[] B = {20, 4, 10, 2};
        System.out.println(solve(Util.arrayToList(A), Util.arrayToList(B)));
    }

    // optimized approach using prefix sum technique, time xomplexity : (q log n)
    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        // calculate prefix sum
        for (int i = 1; i < A.size(); i++) {
            int sum = A.get(i) + A.get(i-1);
            A.set(i, sum);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < B.size(); i++) {
            result.add(binarySearch(A, B.get(i)) + 1); // +1 because of zero based indexing
        }
        return result;
    }

    static int binarySearch(ArrayList<Integer> arr, int targetNo){
        int ans = -1; // -1 is because - try with targetNo 2
        int n = arr.size();
        int start = 0;
        int end = n-1;
        while (start <= end){
            int mid = (start + end)/2;
            if (arr.get(mid) <= targetNo){
                ans = mid; // store potential answer
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return ans;
    }

    // overloaded function with int[]
    static int binarySearch(int[] arr, int targetNo){
        int ans = -1;
        int n = arr.length;
        int start = 0;
        int end = n-1;
        while (start <= end){
            int mid = (start + end)/2;
            if (arr[mid] < targetNo){
                ans = mid; // store potential answer
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return ans;
    }

    // brute force solution
    public static ArrayList<Integer> solve2(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < B.size(); i++) {
            int amount = B.get(i);
            int noOfItemsBuyable = 0;
            for (int j = 0; j < A.size(); j++) {
                if (amount - A.get(j) < 0){
                    break;
                }else {
                    noOfItemsBuyable++;
                    amount -= A.get(j);
                }
            }
            result.add(noOfItemsBuyable);
        }
        return result;
    }
}
