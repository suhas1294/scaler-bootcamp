package _02_intermediate._2022_02_16.recursion_2.homeworks;

import java.util.ArrayList;
import java.util.List;

public class GreyCode {

    public List<Integer> grayCode1(int n) {
        if(n==0){
            List<Integer> result = new ArrayList<Integer>();
            result.add(0);
            return result;
        }

        List<Integer> result = grayCode1(n-1);
        int numToAdd = 1<<(n-1);

        for(int i=result.size()-1; i>=0; i--){ //iterate from last to first
            result.add(numToAdd+result.get(i));
        }
        return result;
    }


    /* Approach --> to get gray code of n, we need grayCode of n-1 i.e recursive
    Intuition -- >  gc(1) = {0,1}, gc(2) = all the elements of gc(1) + [2^(n-1)+a[i] (from right to left)]
    num = 2^2-1 = 2 : means gc of 2 = {0, 1, 1+num, 0+num} = {0, 1, 3, 2}
    gc(3) --> num = 2^(3-1) = 4
    gc(3) = {0, 1, 3, 2, 2+num, 3+num, 1+num, 0+num} = {0, 1, 3, 2, 6, 7, 5, 4}
    ans so on... */
    public List<Integer> grayCode2(int n) {
        //TC --> O(N*2^N), SC --> O(N)
        if(n == 1) {  //base-case
            ArrayList<Integer> bRes = new ArrayList<>();
            bRes.add(0);
            bRes.add(1);
            return bRes;
        }
        List<Integer> list = new ArrayList<Integer>();
        list = grayCode2(n-1);
        int num = 1<<(n-1);

        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0; i<list.size(); i++) { //TC--> O(2^n)
            res.add(list.get(i));
        }
        for(int i=list.size()-1; i>=0; i--) {
            res.add(list.get(i) + num);
        }
        return res;
    }

}

/*
The gray code is a binary numeral system where two successive values differ in only one bit.
Given a non-negative integer A representing the total number of bits in the code, print the
sequence of gray code. A gray code sequence must begin with 0.

Problem Constraints : 1 <= A <= 16

Input Format : The first argument is an integer A.
Output Format : Return an array of integers representing the gray code sequence.

Input 1: A = 2, output 1: [0, 1, 3, 2]

Explanation 1:
for A = 2 the gray code sequence is:
    00 - 0
    01 - 1
    11 - 3
    10 - 2
So, return [0,1,3,2].

Input 2: A = 1, output 2: [0, 1]
Explanation 2:
for A = 1 the gray code sequence is:
    00 - 0
    01 - 1
So, return [0, 1].

credits:
https://www.programcreek.com/2014/05/leetcode-gray-code-java/#:~:text=The%20gray%20code%20is%20a,sequence%20must%20begin%20with%200.
https://leetcode.com/problems/gray-code/discuss/1782334/Java-oror-5ms-oror-faster-than-88-oror-Intuition-discussed-with-TC-and-SC
 */