package _02_intermediate._2022_01_14.carry_forward.homework;

import utils.Util;

import java.util.ArrayList;

public class EvenSubArrays {
    public static String solve(ArrayList<Integer> A) {
        // array size should not be odd.
        // first & last element should be even
        if ((A.size() % 2 != 0) || (A.get(0) % 2 != 0) || (A.get(A.size()-1) %2 != 0) ) return "NO";
        // since entire array can be considered as subarray
        if (A.size() % 2 == 0 && A.get(0) %2 == 0 &&  A.get(A.size()-1) %2 == 0) return "YES";
        // now find two continious even numbers where we can divide
        for (int i = 0; i < A.size()-1; i++) { // (i % 2 != 0) because of zero based indexing else ulta
            if ((A.get(i) % 2 == 0) && (A.get(i+1) % 2 == 0) && (i % 2 != 0)) return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) {
        //ArrayList<Integer> input = Util.fillArrayList(new int[]{654, 50, 694, 750, 712, 275, 736, 146, 279, 816, 707, 396, 406, 589, 370, 742, 840, 290, 505, 23, 249, 447, 618, 80, 968, 189, 600, 662, 91, 604, 575, 689, 72, 196, 475, 198, 850, 844, 361, 419, 617, 911, 268, 628, 408, 404, 477, 921, 478, 806, 204, 637, 403, 911, 589, 529, 867, 584, 768, 257, 437, 380, 698, 452, 368, 97, 977, 582, 775, 103}); // expected NO
        //ArrayList<Integer> input = Util.fillArrayList(new int[]{978, 847, 95, 729, 778, 586, 188, 782, 813, 870, 871, 940, 312, 693, 580, 101, 760, 837, 564, 633, 680, 155, 241, 374, 682, 290, 850, 601, 433, 922, 773, 959, 530, 290, 990, 50, 516, 409, 868, 131, 664, 851, 721, 880, 20, 450, 745, 387, 787, 823, 392, 242, 674, 347, 65, 135, 819, 324, 651, 678, 139, 940 }); // expected YES
        ArrayList<Integer> input = Util.arrayToList(new int[]{796, 483, 671, 998, 149, 374, 801, 191, 457, 802, 903, 329, 191, 286, 153, 600, 917, 189, 724, 741, 306, 253, 520, 372 }); // expected YES
        System.out.println(solve(input));
    }
}

/*
You are given an integer array A.
Decide whether it is possible to divide the array into one or more subarrays of even
length such that first and last element of all subarrays will be even.
Return "YES" if it is possible otherwise return "NO" (without quotes).

constraints: 1 <= |A|, A[i] <= 10^6
input format: The first and the only input argument is an integer array, A.
output format: Return a string "YES" or "NO" denoting the answer.


input 1: A = [2, 4, 8, 6], output : "YES", explanation:  We can divide A into [2, 4] and [8, 6].
Input 2: A = [2, 4, 8, 7, 6], output : "NO", explanation: There is no way to divide the array into even length subarrays.

 */