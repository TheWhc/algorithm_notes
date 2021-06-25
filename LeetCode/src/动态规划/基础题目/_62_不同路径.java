package 动态规划.基础题目;

import java.util.Arrays;

/**
 * @ClassName: _62_不同路径
 * @Author: whc
 * @Date: 2021/06/25/10:57
 */
public class _62_不同路径 {

	/**
	 * 思路: 深搜
	 * 转化为求二叉搜索的叶子节点
	 * 深度为m+n-1,节点数为2^(m+n-1)-1
	 * 时间复杂度O(2^(m+n-1)-1)
	 *
	 *   |起点 |     |
	 *   |    | 终点 |
	 *
	 *   转化为二叉树
	 *        起点(1,1)
	 *       /   \
	 * (2,1)节点   节点(1,2)
	 *       \    /
	 * (2,2)终点 终点(2,2)
 	 */
	/*public int uniquePaths(int m, int n) {
		return dfs(1, 1, m, n);
	}

	private int dfs(int i, int j, int m, int n) {
		if(i > m || j > n) {
			return 0; // 越界
		}

		if(i == m && j == n) {
			return 1; // 找到一种方法,相当于找到了叶子节点
		}

		return dfs(i+1, j, m, n) + dfs(i, j+1, m, n);
	}*/

	/**
	 * 思路: 动态规划
	 * 1. 确定dp数组以及下标含义
	 * dp[i][j]表示从(0,0)出发到达坐标(i,j),有dp[i][j]条不同的路径
	 *
	 * 2. 确定递推公式
	 * dp[i][j] = dp[i-1][j] + dp[i][j-1]
	 *
	 * 3. 初始化
	 * dp[0][j] = 1 ,只能有一条路径
	 * dp[i][0] = 1 ,只能有一条路径
	 *
	 * 4. 遍历顺序
	 * 从上到下,从左往后
	 *
	 * 时间: O(n*m)
	 * 空间: O(n*m)
	 */
	/*public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		Arrays.fill(dp[0], 1);
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}

		return dp[m-1][n-1];
	}*/

	// 动态规划 + 空间优化
	// 时间:O(n*m)
	// 空间:O(n)
	public int uniquePaths(int m, int n) {
		int[] dp = new int[n];
		Arrays.fill(dp, 1);

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[j] = dp[j] + dp[j-1];
			}
		}

		return dp[n-1];
	}
}
