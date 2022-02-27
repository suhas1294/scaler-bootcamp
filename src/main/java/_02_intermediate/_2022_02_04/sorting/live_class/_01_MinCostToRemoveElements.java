package _02_intermediate._2022_02_04.sorting.live_class;

import java.util.Arrays;
import java.util.Collections;

public class _01_MinCostToRemoveElements {
    public static void main(String[] args) {
        int[] arr = {2,1,4};
        int[] arrDesc = Arrays.stream(arr).boxed() // Arrays.sort descending cannot be used on primitive array
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        int cost = 0;
        for (int i = 0; i < arrDesc.length; i++) {
            cost += (arrDesc[i] * (i+1));
        }
        System.out.println(cost);
    }
}

/*
q1. minimum cost to remove all elements
Given integer array  - remove elements one by one, each removal has a cost.
cost of removal is sum of all elements present in array.
find min cost to remove all elements.

ex:  2,1,4

step-0: current cost : cost  = sum of elements = 7
step-1: remove 2, cost is {1,4} : 5
step-2: remove 1, cost is {4} : 4
step-3: remove 4, cost is { } : 0
total cost : 7 + 5 + 4 + 0 = 16

Answer : Remove in the order 4,2,1 : cost will be 7 + 3 + 1 = 11\
{4,2,1} = 7
{2,1} = 3
{1} = 1
{} = 0
____________________________________

ex-2 : {3, 5, 1, -3}, ans  = 2

say array is sorted {a,b,c,d}
{a,b,c,d}, cost : a + b + c + d
{b,c,d}, cost :       b + c + d
{c,d}, cost :             c + d
{d}, cost :                   d

total cost : a + 2b +3c + 4d

TC: nlogn + n = nlogn
SC : 1
 */