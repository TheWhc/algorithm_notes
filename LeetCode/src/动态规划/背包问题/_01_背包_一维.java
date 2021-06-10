package 动态规划.背包问题;

/**
 * @ClassName: _01_背包_一维
 * @Author: whc
 * @Date: 2021/03/27/12:39
 */
public class _01_背包_一维 {

	/*static void wei_bag_problem() {
		int[] weight = {1, 3, 4};
		int[] value = {15, 20, 30};
		int bagWeight = 4;

		// 初始化
		int[] dp = new int[bagWeight + 1];

		// 遍历顺序
		for (int i = 0; i < weight.length; i++) { // 遍历物品
			for (int j = bagWeight; j >= weight[i]; j--) { // 遍历背包容量
				dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
			}
		}

		System.out.println(dp[bagWeight]);
	}*/

	public static void wei_bag_problem() {
		int[] weight = {1,3,4};
		int[] value = {15, 20, 30};
		int bagweight = 4;

		// 1. 确定dp数组及下标含义
		// dp[j] 表示容量为j的背包,价值总和最大是多少
		int[] dp = new int[bagweight+1];

		// 2. 确定递推公式
		// dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i]) 不放入物品, 放入物品
		// dp[i][j] = Math.max(dp[i][j], dp[i][j-weight[i]] + value[i])
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
			// 如果为正序遍历的话,会导致物品被重复放入多次
			// 物品0的重量weight[0]=1, value[0]=15
			// 正序遍历的话, dp[1] = dp[1-weight[0]] + 15 = 15
			// dp[2] = dp[2-weight[0]] + 15 = 15 + 15 = 30
			// 倒序遍历的话, dp[2] = dp[2-weight[0]] + 15 = 15 (dp数组已经初始化为0)
			// dp[1] = dp[1-weight[0]] + 15 = 15
			for (int j = bagweight; j >= weight[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
			}

			for (int k = 0; k < dp.length; k++) {
				System.out.print(dp[k] + " ");
			}
			System.out.println();
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

		// (错误写法)若背包容量正序遍历,会出现重复放入物品问题,且先遍历背包容量,还会出现每个dp[j]最后只会存放一个物品
		/*for (int j = 0; j <= bagweight; j++) {
			for (int i = 0; i < weight.length; i++) {
				if(j >= weight[i]) {
					dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
				}
			}
		}*/

	}

	public static void main(String[] args) {
		wei_bag_problem();
	}
}
