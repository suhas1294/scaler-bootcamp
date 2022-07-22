package _03_advance._2022_07_15.backtracking_3.live_session;

import java.util.List;

public class RatInMaze {

    void ratInMaze(int[][] mat, int n, int m, int i, int j, List<Pair> path){
        if (i < 0 || i >= n || j < 0 || j >= m) return;
        if (mat[i][j] == 1 || mat[i][j] ==2) return;
        if (i == n-1 && j == m-1){
            System.out.println(path);
            return;
        }
        if (mat[i][j] == 0){
            mat[i][j] = 1;                      // make changes
            path.add(new Pair(i,j));            // update ans
            ratInMaze(mat, n, m, i-1, j, path); // func calls in four diff directions - top left bottom right
            ratInMaze(mat, n, m, i+1, j, path);
            ratInMaze(mat, n, m, i, j-1, path);
            ratInMaze(mat, n, m, i, j+1, path);
            path.remove(path.size()-1);     // rever chages
        }
    }

    private class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
}
