package 数组.模拟;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _54_螺旋矩阵
 * @Author: whc
 * @Date: 2021/07/03/23:22
 */
public class _54_螺旋矩阵 {

	/**
	 * 思路: 模拟法
	 */
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();

		int x = 0;
		int y = 0;

		int m = matrix.length;
		int n = matrix[0].length;

		int flag = 1;
		boolean[][] visited = new boolean[m][n];

		int size = m * n;
		while(res.size() < size) {
			if(x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
				res.add(matrix[x][y]);
				visited[x][y] = true;
				if(flag == 1) {
					y++;
				} else if(flag == 2) {
					x++;
				} else if(flag == 3) {
					y--;
				} else {
					x--;
				}
			} else {
				// 越界或者已访问过
				if(flag == 1) {
					y--;
					x++;
					flag = 2;
				} else if(flag == 2) {
					x--;
					y--;
					flag = 3;
				} else if(flag == 3) {
					// 左 -> 上
					y++;
					x--;
					flag = 4;
				} else {
					// 上 -> 右
					x++;
					y++;
					flag = 1;
				}
			}
		}

		return res;
	}
}
