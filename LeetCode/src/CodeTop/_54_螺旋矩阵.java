package CodeTop;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _54_螺旋矩阵
 * @Author: whc
 * @Date: 2021/07/20/15:15
 */
public class _54_螺旋矩阵 {

	public List<Integer> spiralOrder(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		int x = 0;
		int y = 0;
		int flag = 1;
		boolean[][] visited = new boolean[m][n];
		List<Integer> res = new ArrayList<>();

		while(res.size() < m * n) {
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
				if(flag == 1) {
					y--;
					x++;
					flag = 2;
				} else if(flag == 2) {
					x--;
					y--;
					flag = 3;
				} else if(flag == 3) {
					y++;
					x--;
					flag = 4;
				} else {
					x++;
					y++;
					flag = 1;
				}
			}
		}

		return res;
	}

}
