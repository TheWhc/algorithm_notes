package 动态规划.背包问题;

/**
 * @ClassName: 动态规划.背包问题
 * @Author: whc
 * @Date: 2021/03/27/12:11
 */
public class _完全_背包 {

	public static void wei_bag_problem() {
		int[] weight = {1,3,4};
		int[] value = {15, 20, 30};
		int bagweight = 4;

		// 1. 确定dp数组及下标含义
		// dp[j] 表示容量为j的背包,价值总和最大是多少
		int[] dp = new int[bagweight+1];

		// 2. 确定递推公式
		// dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i])

		// 3. 初始化
		// 若价值都为正整数,则全部初始化为0, 如果出现负整数, 那么价值要初始化为最小值(负无穷),防止比较大小的时候出错
		// j = 0时,背包容量为0

		// 4. 确定遍历顺序
		// 先遍历物品,再遍历背包重量(反之也可以)
		for (int i = 0; i < weight.length; i++) {
			// 正序遍历
			for (int j = weight[i]; j <= bagweight; j++) {
				dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
			}

			for (int k = 0; k < dp.length; k++) {
				System.out.print(dp[k] + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		wei_bag_problem();
	}
}
