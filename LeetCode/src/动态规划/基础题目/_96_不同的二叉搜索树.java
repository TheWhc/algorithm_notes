package 动态规划.基础题目;

/**
 * @ClassName: _96_不同的二叉搜索树
 * @Author: whc
 * @Date: 2021/06/25/16:10
 */
public class _96_不同的二叉搜索树 {

	/**
	 * 1. dp数组
	 * dp[i]: 表示1到i为节点组成的二叉搜索树的个数为dp[i]
	 * 也可以理解为i的不同节点组成的二叉搜索树的个数为dp[i]
	 *
	 * 2. 递推公式
	 * dp[i]   +=   dp[j-1] * dp[i - j]
	 * 以j为头结点 左子树节点数量  右子树节点数量
	 *
	 * 比如i=3时
	 * 当1为头节点时
	 * dp[i] += dp[0] * dp[i-1] (虽然右节点为2和3两个值,右节点数量为2, 但是拼接规则和以2为根节点一样, 所以乘以右子树dp[2])
	 * 当2为头节点时
	 * dp[i] += dp[1] * dp[i-2]
	 * 当3为头节点时
	 * dp[i] += dp[2] * dp[i-3]
	 *
	 * 3. 初始化
	 * dp[0] = 1
	 *
	 * 4. 遍历顺序
	 * 从前往后遍历
	 *
	 * 时间: O(n^2)
	 * 空间: O(n)
	 */
	public int numTrees(int n) {
		int[] dp = new int[n+1];

		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] += dp[j-1] * dp[i-j];
			}
		}

		return dp[n];
	}
}
