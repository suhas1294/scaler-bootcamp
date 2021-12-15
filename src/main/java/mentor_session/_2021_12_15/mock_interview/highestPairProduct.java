package mentor_session._2021_12_15.mock_interview;

import java.util.Arrays;

/*
    Find a pair with maximum product in array of Integers
    Given an array with both +ive and -ive integers, return a pair with highest product.
    Input: arr[] = {1, 4, 3, 6, 7, 0}
    Output: {6,7}

    Input: arr[] = {-1, -3, -4, 2, 0, -5}
    Output: {-4,-5}
*/

/*
feedback:
1. use ternary whenever applicable
2. If interviewer is giving a hint then it must be possible that way
3. cover edge cases
4. throw exception for : null checks, empty checks in array
5. No debugger
6. dry run using pen and paper
 */

public class highestPairProduct {
    public static void main(String[] args) {
        //int[] input = {6,1, 4, 3, 7, 0};
        int[] input = {-1, -3, -4, 2, 0, -5} ;
        int[] result = getPairOfHighestProductOptimizedReadable(input);
        System.out.println(Arrays.toString(result));
    }

    // approach-1 : bruteforce solution-1 whose time complexity is n log(n)
    static int[] getPairOfHighestProduct(int[] input) {
        Arrays.sort(input);
        int leastProduct = input[0] * input[1];
        int HigherProduct = input[input.length-1] * input[input.length-2];
        int[] result = leastProduct > HigherProduct ? new int[]{input[0], input[1]} : new int[]{input[input.length-1], input[input.length-2]};
        return result;
    }

    // approach-2 : time complexity : n
    static int[] getPairOfHighestProductOptimized(int[] input){
        int h1 = Integer.MIN_VALUE, h2 = Integer.MIN_VALUE;
        int l1 = Integer.MAX_VALUE, l2 = Integer.MAX_VALUE;

        for(int i = 0; i < input.length ; i++){
            if(input[i] > h1) {
                h2 = h1;
                h1 = input[i];
            };
            if(input[i] < h1 && input[i] > h2) h2 = input[i];

            if(input[i] < 0 && input[i] < h2 ) {
                l2 = l1;
                l1 = input[i];
            };
            if(input[i] < 0 && input[i] < l1 ) l2 = input[i];
        }
        int[] result = (h1 * h2) > (l1 *l2) ? new int[]{h1, h2} : new int[]{l1, l2};
        return result;
    }

    static int[] getPairOfHighestProductOptimizedReadable(int[] input){
        int highest1 = Integer.MIN_VALUE, highest2 = Integer.MIN_VALUE;
        int lowest1 = Integer.MAX_VALUE, lowest2 = Integer.MAX_VALUE;

        for(int i = 0; i < input.length ; i++){

            if (input[i] > highest1){
                highest2 = highest1; // always while updating first highest, make sure to unload first highest value to second highest
                highest1 = input[i];
            }
            if (input[i] < highest1 && input[i] > highest2){
                highest2 = input[i];
            }
            if (input[i] < 0 && input[i] < highest2){
                lowest2 = lowest1; // always while updating first lowest, make sure to unload first lowest value to second lowest
                lowest1 = input[i];
            }
            // dont go by variables names, lowest2 will be actual lowest compared to lowest1
            if (input[i] < 0 && input[i] < lowest1 ){
                lowest2 = input[i];
            }
        }
        System.out.printf("highest1 : %d, highest2 : %d, lowest1 : %d,lowest2 (actual lowest) : %d\n", highest1, highest2, lowest1, lowest2);
        int[] result = (highest1 * highest2) > (lowest1 * lowest2) ? new int[]{highest1, highest2} : new int[]{lowest1, lowest2};
        return result;
    }
}
