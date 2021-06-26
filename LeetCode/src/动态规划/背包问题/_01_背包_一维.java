package 动态规划.背包问题;

/**
 * @ClassName: _01_背包_一维
 * @Author: whc
 * @Date: 2021/03/27/12:39
 */
public class _01_背包_一维 {

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
	 * 思路: 一维数组01背包
	 *
	 * 1. 确定dp数组以及下标含义
	 * dp[j]: 表示容量为j的背包的最大价值
	 *
	 * 2. 确定递推公式
	 * dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i])
	 *               不放入当前物品     放入当前物品
	 *
	 * 3. 初始化
	 * 	 dp[0] = 0
	 *
	 * 4. 确定遍历顺序
	 * 先遍历物品,再遍历背包容量
	 * 遍历背包容量的时候,应该是倒叙遍历
	 *
	 * 如果是正序遍历的话
	 * dp[1] = dp[1-weight[0]] + value[0] = 15
	 * dp[2] = dp[2-weight[0]] + value[0] = 15 + 15 =  30
	 * 重复放了2次
	 *
	 * 如果是倒叙遍历的话
	 * dp[2] = dp[2-weight[0]] + value[0] = 15
	 * dp[1] = dp[1-weight[0]] + value[0] = 15
	 *
	 * 5. 举例推导递推公式
	 *      背包容量:   0  1  2  3  4
	 * 用物品0,遍历背包: 0 15 15 15 15
	 * 用物品1,遍历背包: 0 15 15 20 35
	 * 用物品2,遍历背包: 0 15 15 20 35
	 */
	public static void wei_bag_problem() {
		int[] weight = {1,3,4};
		int[] value = {15, 20, 30};
		int bagweight = 4;

		// 1. 确定dp数组及下标含义
		// dp[j] 表示容量为j的背包,价值总和最大是多少
		int[] dp = new int[bagweight+1];

		// 2. 确定递推公式
		// dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]) 不放入物品, 放入物品
		// 所以一维数组时,递推公式如下
		// dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i])

		// 3. 初始化
			// 要和dp数组的定义吻合
		// 若价值都为正整数,则全部初始化为0, 如果出现负整数, 那么价值要初始化为最小值(负无穷),防止比较大小的时候出错
		// j = 0时,背包容量为0

		// 4. 确定遍历顺序
		// 先遍历物品,再遍历背包重量(反之不行)
		for (int i = 0; i < weight.length; i++) {
			// 倒叙遍历
			// 从后往前循环，每次取得状态不会和之前取得状态重合，这样每种物品就只取一次了。
			// 背包容量从大到小,与二维dp写法不同(二维正序倒叙都可),倒叙遍历目的是使得物品i只被放入一次
			for (int j = bagweight; j >= weight[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
			}
		}

		// (错误写法)先背包容量,后物品情况
		// 那么背包里只会放入了一个物品
		// 背包容量要倒叙遍历,防止出现重复放入物品
		/*for (int j = bagweight; j >= 0; j--) {
			for (int i = 0; i < weight.length; i++) {
				if(j >= weight[i]) {
					dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
				}
			}
		}*/
	}

}
