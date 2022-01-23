package _02_intermediate._2022_01_19._2dMatrix.ext_soln;

public class GenSpiralMatrixExt {
	// credits : https://leetcode.com/problems/spiral-matrix-ii/discuss/1705624/java-dfs-recursive
	public int[][] generateMatrix(int n) {
		var m = new int[n][n];
		dfs(m, 0, 0, false, 1);
		return m;
	}
	private void dfs(int[][] m, int row, int col, boolean goup,int count) {
		if (row < 0 || col < 0 || col >= m[0].length || row >= m.length || m[row][col] != 0) return;
		m[row][col] = count;
		count++;
		if (goup) dfs(m, row-1, col, true, count);
		dfs(m, row, col+1, false, count);
		dfs(m, row + 1, col, false, count);
		dfs(m, row, col-1, false, count);
		dfs(m, row-1, col, true, count);
	}

	// much more effecient solution
	// credits : https://leetcode.com/problems/spiral-matrix-ii/discuss/1705531/59.-Spiral-Matrix-II-100-Fast-Easy-Java-Using-While-loop
	public int[][] generateMatrix2(int n) {
		int sum = n *n;
		int[][] arr = new int[n][n];
		int c =1;
		int lap = 0;
		int i =0,j=0;
		while(c<=sum){

			i =lap;
			j =lap;

			while(j<n){
				if(c>sum) return arr;
				arr[i][j++] = c++;
			}
			j--;
			i++;
			while(i<n)
				arr[i++][j] = c++;

			i--;
			j--;
			while(j>=lap)
				arr[i][j--] =c++;

			j++;
			i--;

			while(i>lap)
				arr[i--][j] = c++;

			i++;
			lap++;
			n--;
		}
		return arr;

	}
}
