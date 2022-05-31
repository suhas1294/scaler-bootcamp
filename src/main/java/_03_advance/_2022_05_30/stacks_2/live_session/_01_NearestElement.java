package _03_advance._2022_05_30.stacks_2.live_session;

import java.util.Arrays;
import java.util.Stack;

public class _01_NearestElement {

    // Note : for all below functions, TC: O(n) , sc: O(n)

    // given an array of positive integers, for every index i, find the nearest element
    // on left side of i which is smaller than a[i], give -1 if no such element exists
    public static int[] nearestSmallOnLeft(int[] a){
        int[] ans = new int[a.length];
        Arrays.fill(ans, -1); // filling with default values
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < a.length; i++) {
            while (stack.size() > 0 && a[i] <= stack.peek()){
                stack.pop();
            }
            if (stack.size() > 0) ans[i] = stack.peek();
            stack.push(a[i]);
        }
        return ans;
    }

    // Note: storing indices will also work if input array contains negative numbers.
    // given an array of positive integers, for every index i, return the index of the nearest
    // element on left side of i which is smaller than a[i], give -1 if no such element exists
    public static int[] nearestSmallOnLeftIDX(int[] a){
        int[] ans = new int[a.length];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            while (stack.size() > 0 && a[i] <= a[stack.peek()]){    // MINOR CHANGE
                stack.pop();
            }
            if (stack.size() > 0) ans[i] = stack.peek();
            stack.push(i);                                          // MINOR CHANGE
        }
        return ans;
    }

    // Follow up question : get distance of nearest smallest element on the left side.
    public static int[] nearestSmallestDistanceOnLeft(int[] a){
        int[] ans = new int[a.length];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            while (stack.size() > 0 && a[i] <= a[stack.peek()]){
                stack.pop();
            }
            if (stack.size() > 0) ans[i] = stack.peek();
            stack.push(i);
        }
        // calculating distance array
        int[] dist = new int[ans.length];
        Arrays.fill(dist, -1);
        for (int i = 1; i < dist.length; i++) {
            dist[i] = i - ans[i];
        }
        return dist;
    }

    // exactly same as nearestSmallOnLeft, but reverse loop
    public static int[] nearestSmallestOnRight(int[] a){
        int[] ans = new int[a.length];
        Arrays.fill(ans, -1); // filling with default values
        Stack<Integer> stack = new Stack<>();

        for (int i = a.length-1; i >=0 ; i--) {
            while (stack.size() > 0 && a[i] <= stack.peek()){
                stack.pop();
            }
            if (stack.size() > 0) ans[i] = stack.peek();
            stack.push(a[i]);
        }
        return ans;
    }

    // nearest smaler element towards right , return their index
    public static int[] nextSmallerIdx(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && A[i] <= A[st.peek()]){
                st.pop();
            }

            ans[i] = st.size() > 0 ? st.peek() : n;
            st.push(i);
        }
        return ans;
    }

    // exactly same as nearestSmallOnLeft, but reverse loop, reverse condition
    public static int[] nearestHigherOnRight(int[] a){
        int[] ans = new int[a.length];
        Arrays.fill(ans, -1); // filling with default values
        Stack<Integer> stack = new Stack<>();

        for (int i = a.length-1; i >=0 ; i--) {
            while (stack.size() > 0 && a[i] >= stack.peek()){
                stack.pop();
            }
            if (stack.size() > 0) ans[i] = stack.peek();
            stack.push(a[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(nearestSmallOnLeftIDX(new int[]{4,6,10,11,7,8,3,5}))); // -1, 0, 1, 2, 1, 4, -1, 6
        //System.out.println(Arrays.toString(nearestSmallestOnRight(new int[]{2, 9, 7, 1, 4, 7, 2, 6, 5}))); // 1, 7, 1, -1, 2, 2, -1, 5, -1
        System.out.println(Arrays.toString(nearestHigherOnRight(new int[]{2, 9, 7, 1, 4, 7, 2, 6, 5}))); // {9, -1, -1, 4, 7, -1, 6, -1, -1}
    }

    // TC: O(n^2)
    public static int[] nearestSmallOnLeftBruteforce(int[] a){
        int[] ans = new int[a.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < a.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (a[j] < a[i]){
                    ans[i] = a[j];
                    break;
                }
            }
        }
        return ans;
    }

}

/*
Nearest smallest on left examples:
input : {4,5,2,10,8,2}, output: {-1, 4, -1, 2, 2, -1}
input : {4,6,10,11,7,8,3,5}, output: {-1, 4,6,10,6,7,-1,3}
 */