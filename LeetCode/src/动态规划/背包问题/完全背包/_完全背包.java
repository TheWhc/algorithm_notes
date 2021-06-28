package 动态规划.背包问题.完全背包;

/**
 * @ClassName: _完全背包
 * @Author: whc
 * @Date: 2021/06/28/10:23
 */
public class _完全背包 {

	// 完全背包物品可以添加多次,所以在遍历背包容量时,应该用正序遍历

	/**
	 * 思路: 完全背包问题
	 * 1. 确定dp数组以及下标含义
	 * dp[j]: 背包容量为j时的最大价值为dp[j],物品可以重复放入
	 *
	 * 2. 确定递推公式
	 * dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i])
	 *             不放入当前物品   放入当前物品
	 *
	 * 3. 初始化
	 * 都初始化为0
	 *
	 * 4. 确定遍历顺序
	 * 先遍历物品,再遍历背包容量(正序遍历)
	 *
	 * 或者先遍历背包容量(正序遍历),再遍历物品 也可以, 这里不会出现背包只会放入一个物品的情况,因为是正序遍历
	 *
	 * 5. 举例推导dp数组
	 * int[] weight = {1,3,4};
	 * int[] value = {15, 20, 30};
	 * int bagweight = 4;
	 *
	 *      背包容量:   0  1  2  3  4
	 * 用物品0,遍历背包: 0 15 30 45 60
	 * 用物品1,遍历背包: 0 15 30 45 60
	 * 用物品2,遍历背包: 0 15 30 45 60
	 *
	 * 先遍历背包容量,再遍历物品
	 * 背包容量为1时: 0 15 0 0 0
	 * 背包容量为2时: 0 15 30 0 0
	 * 背包容量为3时: 0 15 30 45 0
	 * 背包容量为4时: 0 15 30 45 60
	 */
	public static void wei_pag_problem() {

		int[] weight = {1,3,4};
		int[] value = {15,20,30};
		int bagWeight = 4;

		// 1. 确定dp数组
		int[] dp = new int[bagWeight+1];

		// 2. 确定递推公式
		// 3. 初始化

		// 4. 确定遍历顺序
		// 先遍历物品，再遍历背包
		/*for(int i = 0; i < weight.length; i++) { // 遍历物品
			for(int j = weight[i]; j <= bagWeight; j++) { // 遍历背包容量
				dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
			}
		}*/

		// 先遍历背包，再遍历物品
		for(int j = 1; j <= bagWeight; j++) { // 遍历背包容量
			for(int i = 0; i < weight.length; i++) { // 遍历物品
				if (j - weight[i] >= 0)
					dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
			}

			for (int i = 0; i < dp.length; i++) {
				System.out.print(dp[i] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		wei_pag_problem();
	}
}
