package 待分类;

import java.util.Arrays;

/**
 * @ClassName: 待分类._62_不同路径
 * @Author: whc
 * @Date: 2021/03/23/18:19
 */
public class _62_不同路径 {

	// 超时 深度为 m+n-1
	// 二叉树节点个数为 2^(m+n-1)-1
	/// 深搜的算法遍历了整个二叉树
	/*public int uniquePaths(int m, int n) {
		return dfs(1, 1, m, n);
	}

	private int dfs(int i, int j, int m, int n) {
		// 越界
		if(i > m || j > n)
			return 0;
		if(i == m && j == n)
			return 1;
		return dfs(i+1, j, m, n) + dfs(i, j+1, m, n);
	}*/

	// 动态规划 五部曲
	/*
	1. 确定dp数组以及下标含义
	2. 确定递推公式
	3. dp数组的初始化
	4. 遍历顺序
	5. 举例推到dp数组
	 */
	// 时间:O(m*n) 空间O(m*n)
	/*public int uniquePaths(int m, int n) {
		// dp[i][j] 代表从(0,0)到(i,j)路径
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		for (int j = 0; j < n; j++) {
			dp[0][j] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}

		return dp[m-1][n-1];
	}*/


	// 二维降为一维
	/*public int uniquePaths(int m, int n) {
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[j] = dp[j-1] + dp[j];
			}
		}
		return dp[n-1];
	}*/

	// 数论方法
	/*
	走到终点需要 m+n-2步
	有m-1步要向下走
	 */
}
