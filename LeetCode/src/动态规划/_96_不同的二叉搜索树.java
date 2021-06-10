package 动态规划;

/**
 * @ClassName: _96_不同的二叉搜索树
 * @Author: whc
 * @Date: 2021/04/20/0:54
 */
public class _96_不同的二叉搜索树 {

	// 动态规划
	public int numTrees(int n) {
		// 1. 确定dp数组以及下标含义
		// dp[i] 表示1到i为节点组成的二叉搜索树的个数为dp[i]
		int[] dp = new int[n+1];

		// 2. 确定递推公式
		// j为1,2,...i
		// dp[i] = dp[j-1] * dp[i-j]

		// 3. 初始化
		dp[0] = 1;

		// 4. 确定遍历顺序
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] += dp[j-1] * dp[i-j];
			}
		}

		return dp[n];
	}
}
