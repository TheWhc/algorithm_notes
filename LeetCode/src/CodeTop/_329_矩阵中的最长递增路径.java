package CodeTop;

/**
 * @ClassName: _329_矩阵中的最长递增路径
 * @Author: whc
 * @Date: 2021/09/13/15:47
 */
public class _329_矩阵中的最长递增路径 {

	// dfs + 递归记忆化
	private int[][] dir = {{1,0}, {0, 1}, {-1, 0}, {0, -1}};
	private int maxLen = 0;
	private int m, n;
	private int[][] matrix;
	private int[][] max;
	public int longestIncreasingPath(int[][] matrix) {
		m = matrix.length;
		n = m == 0 ? 0 : matrix[0].length;

		this.matrix = matrix;
		max = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(max[i][j] == 0) {
					longestIncreasingPath(i, j);
				}
			}
		}

		return maxLen;
	}

	// 返回以x,y出发(包含)能拿到的最大路径数
	private int longestIncreasingPath(int x, int y) {
		if(max[x][y] != 0) {
			return max[x][y];
		}

		max[x][y] = 1;

		for (int k = 0; k < 4; k++) {
			int newX = x + dir[k][0];
			int newY = y + dir[k][1];
			if(isInRange(newX, newY) && matrix[newX][newY] > matrix[x][y]) {
				max[x][y] = Math.max(max[x][y], longestIncreasingPath(newX, newY) + 1);
			}
		}

		maxLen = Math.max(maxLen, max[x][y]);
		return max[x][y];
	}

	private boolean isInRange(int x, int y) {
		return x >= 0 && x < m && y >= 0 && y < n;
	}

}
