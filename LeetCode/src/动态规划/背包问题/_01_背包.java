package 动态规划.背包问题;

/**
 * @ClassName: 动态规划.背包问题
 * @Author: whc
 * @Date: 2021/03/27/12:11
 */
public class _01_背包 {

	/**
	 * 背包最大重量为4
	 *
	 *        重量	 价值
	 * 物品0	   1	  15
	 * 物品1	   3	  20
	 * 物品2	   4	  30
	 *
	 *
	 */

	/**
	 * 思路: 二维dp数组01背包
	 *
	 * 1. 确定dp数组以及下标含义
	 * dp[i][j]: 表示从下标为0~i的物品任意取,放进容量为j的背包,价值总和最大是多少
	 *
	 * 2. 确定递推公式
	 *	if(j < weight[i]) {
	 *	   dp[i][j] = dp[i-1][j];
	 *	} else {
	 * 		dp[i][j] = Math.max(dp[i-1][j-weight[i]] + value[i], dp[i-1][j])
	 *                       放入物品i                        不放入物品i
     * }
	 *
	 * 3. 初始化
	 * 背包容量为0时, 即j = 0 时, dp[i][0] = 0
	 *
	 * i = 0时
	 * for(int j = weight[0]; j <= bagweight; j++) {
	 *     dp[0][j] = value[0];
	 * }
	 *
	 * 4. 确定遍历顺序
	 * 先遍历物品,再遍历背包容量; 反之也可以
	 * 从上到下,从左往右
	 *
	 * 5. 举例推导dp数组
	 *        重量
	 *         0   1  2  3  4
	 * 物品0	   0  15 15 15 15
	 * 物品1	   0  15 15	20 35
	 * 物品2	   0  15 15 20 35
	 *
	 *
	 * 时间: O(n*m)
	 * 空间: O(n*m)
	 * n为物品,m为重量
	 */
	/*void wei_bag_problem() {
		int[] weight = {1,3,4};
		int[] value = {15,20,30};
		int bagWeight = 4;

		// 1. 确定dp数组以及下标含义
		// 二维数组
		// dp[i][j] 代表下标[0-i]物品里任意取,放进容量为j的背包,价值总和最大是多少
		int[][] dp = new int[weight.length][bagWeight + 1];

		// 2. 初始化
		// 背包重量为0的 dp[i][0]价值为0
		for (int i = 0; i < weight.length; i++) {
			dp[i][0] = 0;
		}

		// 存放编号为0的物品的时候, 各个容量的背包所能存放的最大价值
		// 倒叙遍历
		*//*for (int j = bagWeight; j >= weight[0]; j--) {
			dp[0][j] = dp[0][j - weight[0]] + value[0];
		}*//*

		// 正序遍历
		for (int j = weight[0]; j <= bagWeight; j++) {
			dp[0][j] = value[0];
		}

		// 3. 遍历顺序
		for (int i = 1; i < weight.length; i++) { // 遍历物品
			for (int j = 1; j <= bagWeight; j++) { // 遍历背包容量
				if(j < weight[i]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]);
				}
			}
		}

	}*/

	// 优化

	static void wei_bag_problem() {
		int[] weight = {1,3,4};
		int[] value = {15,20,30};
		int bagWeight = 4;

		// 1. 确定dp数组以及下标含义
		// 二维数组
		// dp[j] 放进容量为j的背包,价值总和最大是多少
		int[] dp = new int[bagWeight + 1];

		// 2. 初始化
		// 背包重量为0的 dp[i][0]价值为0
		dp[0] = 0;

		// 存放编号为0的物品的时候, 各个容量的背包所能存放的最大价值
		// 正序遍历
		for (int j = weight[0]; j <= bagWeight; j++) {
			dp[j] = value[0];
		}

		// 3. 遍历顺序
		for (int i = 1; i < weight.length; i++) { // 遍历物品
			for (int j = 1; j <= bagWeight; j++) { // 遍历背包容量
				if(j < weight[i]) {
					dp[j] = dp[j];
				} else {
					dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
					// 		   不选当前物品i      选取当前物品i
				}
			}
		}

	}


	/*public static void wei_bag_problem() {
		int[] weight = {1,3,4};
		int[] value = {15, 20, 30};
		int bagweight = 4;

		// 1. 确定dp数组及下标含义
		// dp[i][j] 表示从 下标[0~i]任意取物品,放进容量为j的背包,价值总和最大是多少
		int[][] dp = new int[weight.length][bagweight+1];

		// 2. 确定递推公式
		// dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]) 不放入物品, 放入物品

		// 3. 初始化
		// 若价值都为正整数,则全部初始化为0, 如果出现负整数, 那么价值要初始化为最小值(负无穷),防止比较大小的时候出错
		// j = 0时,背包容量为0
		for (int i = 0; i < weight.length; i++) {
			dp[i][0] = 0;
		}
		// i = 0时,放编号为0的物品的时候,各个容量的背包所能存放的最大价值
		// 需倒叙遍历, 正序遍历会重复计算
		for (int j = bagweight; j >= weight[0]; j--) {
			dp[0][j] = dp[0][j - weight[0]] + value[0];
		}

		// 4. 确定遍历顺序
		// 先遍历物品,再遍历背包重量(反之也可以)
		for (int i = 1; i < weight.length; i++) {
			// 从前往后循环,不用倒叙的原因是因为dp[i][j]是通过dp[i-1][j]计算而来,本层的dp[i][j]不会被覆盖
			*//*for (int j = 0; j <= bagweight; j++) {
				if(weight[i] > j) {
					dp[i][j] = dp[i-1][j];
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]);
				}
			}*//*
			for (int j = bagweight; j >= weight[i]; j--) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]);
			}
		}

		for (int i = 0; i < weight.length; i++) {
			for (int j = 0; j <= bagweight; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println(dp[weight.length-1][bagweight]);
	}*/

	public static void main(String[] args) {
		wei_bag_problem();
	}
}
