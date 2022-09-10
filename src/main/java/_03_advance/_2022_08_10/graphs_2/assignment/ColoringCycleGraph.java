package _03_advance._2022_08_10.graphs_2.assignment;

public class ColoringCycleGraph {
    public int solve(int A) {
        return (A%2 == 0) ? 2 : 3;
    }
}

/*
Given the number of vertices A in a Cyclic Graph.
Your task is to determine the minimum number of colors required to color the
graph so that no two Adjacent vertices have the same color.

Problem Constraints
3 <= A <= 10^9

Input Format : First argument is an integer A denoting the number of vertices in the Cyclic Graph.
Output Format : Return an single integer denoting the minimum number of colors required
to color the graph so that no two Adjacent vertices have the same color.

Input 1: 5
Input 2: 4

Output 1: 3
Output 2: 2

explanation :  refer pics attached

 */