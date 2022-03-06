package _02_intermediate._2022_02_11.hashmap.homework;

import java.util.HashMap;
import java.util.Map;

public class AlienDictionary {
    public static int solve(String[] A, String B) {
        Map<Character, Integer> hm = new HashMap();

        for(int i = 0; i < B.length(); i ++){
            hm.put(B.charAt(i), i);
        }
        for(int i = 0; i < A.length - 1; i ++){
            int p = 0;
            int end = Math.min(A[i].length(), A[i+1].length());
            boolean same = true;
            while(p < end){
                if(hm.get(A[i].charAt(p)) > hm.get(A[i+1].charAt(p))){return 0;}
                if(hm.get(A[i].charAt(p)) < hm.get(A[i+1].charAt(p))){same = false; break;}
                p ++;
            }
            if(A[i].length() > A[i+1].length() && same){return 0;}
        }
        return 1;
    }

    public static void main(String[] args) {
        String[] A = {"fine", "none", "no"};
        String B = "qwertyuiopasdfghjklzxcvbnm";
        System.out.println(solve(A, B));
    }
}

/*
In an alien language, surprisingly they also use english lowercase letters,
but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
Given an array of words A of size N written in the alien language, and the order of the
alphabet denoted by string B of size 26, return 1 if and only if the given words are sorted
lexicographicaly in this alien language else return 0.

1 <= N, length of each word <= 10^5
Sum of length of all words <= 2 * 10^6

input format: First argument is a string array A of size N.
Second argument is a string B of size 26 denoting the order.

output :
Return 1 if and only if the given words are sorted lexicographicaly in this alien language else return 0.

Input 1:
 A = ["hello", "scaler", "interviewbit"]
 B = "adhbcfegskjlponmirqtxwuvzy"
Output : 1
Explanation 1: The order shown in string B is: h < s < i for the given words. So return 1.

Input 2:
 A = ["fine", "none", "no"]
 B = "qwertyuiopasdfghjklzxcvbnm"
output: 0
Explanation 2: "none" should be present after "no". Return 0.

 */
