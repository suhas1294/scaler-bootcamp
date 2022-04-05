package _03_advance._2022_03_21.arrays_3.live_session;

import java.util.ArrayList;
import java.util.List;

public class _03_MergeIntervals {
    public static List<int[]> mergeIntervalWithNewInterval(int[][] arr, int[] newInterval){
        int n = arr.length;
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] ith_interval = arr[i];
            // arr[i].end = arr[i][1]
            // arr[i].start = arr[i][0]
            // interval.start = newInterval[0]
            // interval.end = newInterval[1]
            if (arr[i][1] < newInterval[0]) {
                ans.add(arr[i]);
            }else if(newInterval[1] < arr[i][0]){
                ans.add(newInterval);
                for (int j = 0; j < n; j++) {
                    ans.add(arr[j]);
                }
                return ans;
            }else { // overlapping, merge arr[i] and newInterval
                newInterval[0] = Integer.min(arr[i][0], newInterval[0]);
                newInterval[1] = Integer.max(arr[i][1], newInterval[1]);
            }
        }
        ans.add(newInterval);
        return ans;
    }
}

/*
Given n non overlapping intervals and they are sorted based on start, given new interval 'I' comes, merge all.
Note : even if there is overlapping at one element, that is considered overlapping

In below question, given new interval = {12, 22}

ex:  arr = {                    new interval            new non overlapping interval (ans)
            {1, 3},                                     {1,3}
            {4, 7},                                     {4, 7}
            {10, 14},           {12, 22} => {10, 22}    {10, 24}
            {16, 19},           {10, 22} => {10, 22}    {27, 30}
            {21, 24},           {10, 22} => {10, 24}    {32, 35}
            {27, 30},           {10, 24}                {38, 41}
            {32, 35},
            {38, 41}
        }
 */