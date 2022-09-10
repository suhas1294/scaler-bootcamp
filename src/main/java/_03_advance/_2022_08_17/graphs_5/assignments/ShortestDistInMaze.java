package _03_advance._2022_08_17.graphs_5.assignments;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistInMaze {
    // Add Gloabl Varibles for all possible directions
    // For making the problem easy i have divided it into left(0), right(1), up(2), down(3)
    // Normally we take enum while coding but i have assumed here that Kth index(0 to 3)
    // will denote all possible directions. For example if at index 0 or left if i add dx[0] and dy[0]
    // to my original x,y then my ball will move left and same for other indexs.
    int[] dx = {
            0,
            0,
            -1,
            1
    };
    int[] dy = {
            -1,
            1,
            0,
            0
    };
    // Gloabl Varibles for Queue and Visited Array(It is divided into four halfs where the direction is denoted
    // by index as i have suggested in above comment)
    Queue<Pair> q = new ArrayDeque<>();
    Vis[][] vis;

    public int solve(int[][] A, int[] B, int[] C) {
        int N = A.length;
        int M = A[0].length;
        vis = new Vis[N][M];
        // Set the start and end position int the variables
        // I have assumed that start and end position will not be same for the questions sake.
        int iSrc = B[0];
        int jSrc = B[1];
        int iDst = C[0];
        int jDst = C[1];
        // Filled my Visited Array
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                vis[i][j] = new Vis();
        // Add all possible moves from left, right, up, down
        for (int i = 0; i < 4; i++) {
            int xx = iSrc + dx[i];
            int yy = jSrc + dy[i];
            // If there is no wall and not out of bounds add it to Queue.
            if (xx < N && xx >= 0 && yy >= 0 && yy < M && A[xx][yy] != 1) {
                q.add(new Pair(xx, yy, i, 1));
            }
        }
        // Ans max value will update it if we find a better path
        int ans = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            // Checks if this is the end destination and will ball stop here
            if (pair.i == iDst && pair.j == jDst) {
                if (dstFound(pair, A)) {
                    // Update the ans if the destination is found
                    ans = Math.min(ans, pair.dis);
                    continue;
                }
            }
            // Mark the direction we are coming in from visted
            vis[pair.i][pair.j].dir[pair.dir] = true;
            int dir = pair.dir;
            int xx = pair.i + dx[pair.dir];
            int yy = pair.j + dy[pair.dir];
            // Checks if ball will role to the same direction or else we hit the wall and need to find all
            // possible directions to go again.
            if (xx >= 0 && xx < N && yy >= 0 && yy < M && A[xx][yy] != 1) {
                if (!vis[xx][yy].dir[dir])
                    q.add(new Pair(xx, yy, dir, pair.dis + 1));
            } else {
                addPossibleDirections(pair.i, pair.j, A, pair.dis);
            }

        }
        // Means that we cannot reach the destination
        if (ans == Integer.MAX_VALUE)
            return -1;

        return ans;
    }

    void updateVisited(Pair pair, Vis[][] vis) {
        vis[pair.i][pair.j].dir[pair.dir] = true;
    }

    void addPossibleDirections(int i, int j, int[][] A, int steps) {
        int N = A.length;
        int M = A[0].length;
        for (int k = 0; k < 4; k++) {
            int xx = i + dx[k];
            int yy = j + dy[k];
            if (xx < N && xx >= 0 && yy >= 0 && yy < M && A[xx][yy] != 1 && !vis[xx][yy].dir[k]) {
                //System.out.println("Adding to Queue "+ "Pair-: "+xx+" "+yy+" "+k+" "+(steps+1));
                q.add(new Pair(xx, yy, k, steps + 1));
            }
        }
    }

    boolean dstFound(Pair pair, int A[][]) {
        int N = A.length;
        int M = A[0].length;
        int dir = pair.dir;
        int xx = pair.i + dx[dir];
        int yy = pair.j + dy[dir];
        if (xx >= 0 && xx < N && yy >= 0 && yy < M && A[xx][yy] != 1) {
            return false;
        } else {
            return true;
        }
    }

    class Pair {
        int i, j, dir, dis;

        // direction 0-> left 1-> right 2-> up 3-> down
        Pair(int i, int j, int dir, int dis) {
            this.i = i;
            this.j = j;
            this.dir = dir;
            this.dis = dis;
        }
    }

    class Vis {
        boolean[] dir = new boolean[4];
    }

    // -------------- alterate solution -------------

    public static class Triplet {
        int i;
        int j;
        int dir;

        public Triplet(int i, int j, int dir) {
            this.i = i;
            this.j = j;
            this.dir = dir;
        }
    }

    boolean canBeVisited(int[][][] distance, int i, int j, int n, int m, int dir) {
        return i >= 0 && i < n && j >= 0 && j < m && distance[i][j][dir] == Integer.MAX_VALUE;
    }

    boolean isObstacle(int[][] A, int i, int j, int n, int m) {
        return i >= n || j >= m || j < 0 || i < 0 || A[i][j] == 1;
    }

    public int shortestDistance(int[][] A, int s1, int s2, int d1, int d2) {
        Queue<Triplet> queue = new LinkedList<>();
        int[][][] distance = new int[A.length][A[0].length][4];
        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < A[0].length; ++j) {
                Arrays.fill(distance[i][j], Integer.MAX_VALUE);
            }

        }
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        //adding all four directions for the source point
        for (int i = 0; i < 4; ++i) {
            queue.add(new Triplet(s1, s2, i));
            distance[s1][s2][i] = 0;
        }
        while (!queue.isEmpty()) {
            Triplet front = queue.poll();
            int i = front.i;
            int j = front.j;
            int dir = front.dir;
            int nI = i + dx[dir];
            int nJ = j + dy[dir];
            if (isObstacle(A, nI, nJ, A.length, A[0].length)) {
                //We can call in other directions
                if (i == d1 && j == d2) {
                    return distance[i][j][dir];
                }
                for (int k = 0; k < 4; ++k) {
                    if (k == dir) continue;
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (!isObstacle(A, x, y, A.length, A[0].length) && canBeVisited(distance, x, y, A.length, A[0].length, k)) {
                        queue.add(new Triplet(x, y, k));
                        distance[x][y][k] = distance[i][j][dir] + 1;
                    }
                }
            } else {
                if (canBeVisited(distance, nI, nJ, A.length, A[0].length, dir)) {
                    queue.add(new Triplet(nI, nJ, dir));
                    distance[nI][nJ][dir] = distance[i][j][dir] + 1;
                }
            }
        }
        return -1;
    }

    public int solve2(int[][] A, int[] B, int[] C) {
        return shortestDistance(A, B[0], B[1], C[0], C[1]);
    }
}

/*
Given a matrix of integers A of size N x M describing a maze. The maze consists of
empty locations and walls.
1 represents a wall in a matrix and 0 represents an empty location in a wall.
There is a ball trapped in a maze. The ball can go through empty spaces by rolling
up, down, left or right, but it won't stop rolling until hitting a wall (maze boundary
is also considered as a wall). When the ball stops, it could choose the next direction.
Given two array of integers of size B and C of size 2 denoting the starting and destination
position of the ball.
Find the shortest distance for the ball to stop at the destination. The distance is
defined by the number of empty spaces traveled by the ball from the starting position
(excluded) to the destination (included). If the ball cannot stop at the destination, return -1.



Problem Constraints
2 <= N, M <= 100
0 <= A[i] <= 1
0 <= B[i][0], C[i][0] < N
0 <= B[i][1], C[i][1] < M

Input Format
The first argument given is the integer matrix A.
The second argument given is an array of integer B.
The third argument if an array of integer C.

Output Format : Return a single integer, the minimum distance required to reach destination

Input 1:
A = [ [0, 0], [0, 0] ]
B = [0, 0]
C = [0, 1]
Output 1: 1
Explanation 1: Go directly from start to destination in distance 1.


Input 2:
A = [ [0, 0], [0, 1] ]
B = [0, 0]
C = [0, 1]
Output 2: 1
Explanation 2: Go directly from start to destination in distance 1.
 */