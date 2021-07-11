package 动态规划.基础题目;

import java.util.List;

/**
 * @ClassName: _120_三角形最小路径和
 * @Author: whc
 * @Date: 2021/07/10/11:40
 */
public class _120_三角形最小路径和 {

	/**
	 * 思路: 动态规划
	 *
	 * 1. 确定dp数组以及下标含义
	 * dp[i][j]: 表示到达(i,j)点的最小路径和
	 *
	 * 2. 确定递推公式
	 * - 每一行i具有i+1个数字
	 * - 只要不是第一列(j!=0)上的数,都能通过【左上方】转移过来
	 * - 只要不是每行的最后一列(j != i)上的数,都能通过【上方】转移过来
	 *
	 *	if(j != 0) {
	 * 		dp[i][j] = Math.min(dp[i-1][j-1] + val, dp[i][j]);
	 *  }
	 * 	if(j != i) {
	 * 		dp[i][j] = Math.min(dp[i-1][j] + val, dp[i][j]);
	 *  }
	 *
	 * 3. 初始化
	 * dp[0][0] = triangle.get(0).get(0);
	 *
	 * 4. 确定遍历顺序
	 * 从上往下,从左往右
	 *
	 * 时间: O(n^2)
	 * 空间: O(n^2)
	 *
	 */
	/*public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[][] dp = new int[n][n];

		dp[0][0] = triangle.get(0).get(0);

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i + 1; j++) {
				int val = triangle.get(i).get(j);
				dp[i][j] = Integer.MAX_VALUE;
				if(j != 0) {
					dp[i][j] = Math.min(dp[i-1][j-1] + val, dp[i][j]);
				}
				if(j != i) {
					dp[i][j] = Math.min(dp[i-1][j] + val, dp[i][j]);
				}
			}
		}

		int minVal = Integer.MAX_VALUE;
		for (int j = 0; j < n; j++) {
			minVal = Math.min(dp[n-1][j], minVal);
		}

		return minVal;
	}*/

	/**
	 * 优化: 空间优化,滚动数组
	 *
	 * 空间: O(n)
	 */
	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[][] dp = new int[2][n];

		dp[0][0] = triangle.get(0).get(0);

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i + 1; j++) {
				int val = triangle.get(i).get(j);
				dp[i%2][j] = Integer.MAX_VALUE;
				if(j != 0) {
					dp[i%2][j] = Math.min(dp[(i-1) % 2 ][j-1] + val, dp[i % 2][j]);
				}
				if(j != i) {
					dp[i%2][j] = Math.min(dp[(i-1) % 2 ][j] + val, dp[i % 2 ][j]);
				}
			}
		}

		int minVal = Integer.MAX_VALUE;
		for (int j = 0; j < n; j++) {
			minVal = Math.min(dp[(n-1) % 2][j], minVal);
		}

		return minVal;
	}

}
