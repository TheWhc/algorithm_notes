package 数组.模拟;

/**
 * @ClassName: _剑指_Offer_29_顺时针打印矩阵
 * @Author: whc
 * @Date: 2021/07/03/23:34
 */
public class _剑指_Offer_29_顺时针打印矩阵 {

	/**
	 * 思路: 模拟法
	 */
	public int[] spiralOrder(int[][] matrix) {
		if(matrix == null || matrix.length == 0) {
			return new int[0];
		}

		int m = matrix.length;
		int n = matrix[0].length;

		int count = 0;
		int[] res = new int[m * n];

		int x = 0;
		int y = 0;
		int flag = 1;

		boolean[][] visited = new boolean[m][n];

		while(count < m * n) {
			// 满足条件时
			if(x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
				res[count++] = matrix[x][y];
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
