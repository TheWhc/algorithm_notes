package 待分类;

/**
 * @ClassName: 待分类._64_最小路径和
 * @Author: whc
 * @Date: 2021/03/23/14:05
 */
public class _64_最小路径和 {


	/*public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		dp[0][0] = grid[0][0];
		for (int i = 1; i < m; i++) {
			dp[i][0] = grid[i][0] + dp[i-1][0];
		}
		for (int i = 1; i < n; i++) {
			dp[0][i] = grid[0][i] + dp[0][i-1];
		}
		for (int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
			}
		}

		return dp[m-1][n-1];
	}*/

	/**
	 * 变形题：求最小路径和的路径
	 *
	 * 需要一个额外的数据结构存储路径,用一维数组存储二维信息
	 *
	 * 举例: grid = [[1,3,1],[1,5,1],[4,2,1]]
	 *
	 * g数组: 0 0 1 0 3 2 3 6 5
	 * 下标:  0 1 2 3 4 5 6 7 8
	 */

	int m;
	int n;
	public int minPathSum(int[][] grid) {
		m = grid.length;
		n = grid[0].length;
		int[][] dp = new int[m][n];
		// 一维数组存储二维信息
		int[] g = new int[m * n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(i == 0 && j == 0) {
					dp[0][0] = grid[0][0];
				} else {
					int top = i - 1 >= 0 ? dp[i-1][j] + grid[i][j] : Integer.MAX_VALUE;
					int left = j - 1 >= 0 ? dp[i][j-1] + grid[i][j] : Integer.MAX_VALUE;
					dp[i][j] = Math.min(top, left);

					g[getIdx(i, j)] = top < left ? getIdx(i-1, j) : getIdx(i, j-1);
				}
			}
		}

		int idx = getIdx(m-1, n-1);
		// 逆序构造路径, 二维 path[i][0]表示横坐标,dp[i][1]表示纵坐标
		int[][] path = new int[m + n][2];
		path[m + n - 1] = new int[]{m - 1, n - 1};

		for (int i = 1; i < m + n; i++) {
			path[m + n - 1 - i] = parseIdx(g[idx]);
			idx = g[idx];
		}

		// 顺序输出路径
		for (int i = 1; i < m + n; i++) {
			int x = path[i][0];
			int y = path[i][1];
			System.out.print("(" + x + "," + y + ")");
		}

		System.out.println(" ");

		return dp[m-1][n-1];
	}

	private int[] parseIdx(int idx) {
		return new int[]{idx / n, idx % n};
	}

	private int getIdx(int x, int y) {
		return x * n + y;
	}

	public static void main(String[] args) {
		_64_最小路径和 _64_最小路径和 = new _64_最小路径和();
		_64_最小路径和.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
	}
}
