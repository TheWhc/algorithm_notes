package CodeTop;

import java.util.List;

/**
 * @ClassName: _59_螺旋矩阵II
 * @Author: whc
 * @Date: 2021/07/29/16:27
 */
public class _59_螺旋矩阵II {

	public int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];

		int flag = 1;

		int row = 0;
		int col = 0;

		int num = 1;
		boolean[][] visited = new boolean[n][n];
		while(num <= n * n) {
			if(row >= 0 && row < n && col >= 0 && col < n && !visited[row][col]) {
				res[row][col] = num++;
				visited[row][col] = true;
				if(flag == 1) {
					col++;
				} else if(flag == 2) {
					row++;
				} else if(flag == 3) {
					col--;
				} else {
					row--;
				}
			} else {
				if(flag == 1) {
					col--;
					row++;
					flag = 2;
				} else if(flag == 2) {
					row--;
					col--;
					flag = 3;
				} else if(flag == 3) {
					row--;
					col++;
					flag = 4;
				} else {
					row++;
					col++;
					flag = 1;
				}
			}
		}

		return res;
	}
}
