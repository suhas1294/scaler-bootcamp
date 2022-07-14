package _03_advance._2022_07_08.greedy.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class FinishMaxJobs {
    // TC : O(NlogN) | SC:O(N)
    public int solve(int[] A, int[] B) {
        int Input[][] = new int[A.length][2];
        for (int i = 0; i < A.length; i++) {
            Input[i][0] = A[i];
            Input[i][1] = B[i];
        }
        Arrays.sort(Input, (a, b) -> Integer.compare(a[1], b[1])); // You can also implement //merge sort on the basis of end time.
        int ans = 0;
        int time = 0;
        for (int i = 0; i < A.length; i++) {
            if (time <= Input[i][0]) {
                ans++;
                time = Input[i][1];
            }
        }
        return ans;
    }

    //  ------------------ using custom class, TC(n logn), sc: O(N) ------------------
    class Activity {
        int start = 0;
        int finish = 0;

        Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }

    public class CustomComparator implements Comparator<Activity> {
        @Override
        public int compare(Activity o1, Activity o2) {
            return o1.finish - o2.finish;
        }
    }

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        //we will have to sort both start and end and check the st[i+1]>et[i]
        //we need custom comparator for that
        int maxJobCount = 1;
        ArrayList<Activity> activityList = new ArrayList();
        for (int i = 0; i < B.size(); i++) {
            activityList.add(new Activity(A.get(i), B.get(i)));
        }
        Collections.sort(activityList, new CustomComparator());
        // for(Activity obj:activityList){
        // System.out.println(obj.finish+" ===== "+obj.start);
        // }
        int i = 0;
        for (int j = 1; j < activityList.size(); j++) {
            if (activityList.get(j).start >= activityList.get(i).finish) {
                i = j;
                maxJobCount++;
            }
        }
        return maxJobCount;
    }

}

/*
There are N jobs to be done, but you can do only one job at a time.
Given an array A denoting the start time of the jobs and an array B denoting
the finish time of the jobs.
Your aim is to select jobs in such a way so that you can finish the maximum number of jobs.
Return the maximum number of jobs you can finish.

Problem Constraints
1 <= N <= 10^5
1 <= A[i] < B[i] <= 10^9

Input Format
The first argument is an integer array A of size N, denoting the start time of the jobs.
The second argument is an integer array B of size N, denoting the finish time of the jobs.

Output Format:  Return an integer denoting the maximum number of jobs you can finish.

Input 1:  A = [1, 5, 7, 1]  B = [7, 8, 8, 8], Output 1: 2
Explanation 1: We can finish the job in the period of time: (1, 7) and (7, 8).

Input 2: A = [3, 2, 6] B = [9, 8, 9] Output 2: 1
Explanation 2:Since all three jobs collide with each other. We can do only 1 job.
 */