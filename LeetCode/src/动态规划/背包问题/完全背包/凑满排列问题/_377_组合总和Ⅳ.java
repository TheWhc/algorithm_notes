package 动态规划.背包问题.完全背包.凑满排列问题;

/**
 * @ClassName: _377_组合总和Ⅳ
 * @Author: whc
 * @Date: 2021/06/28/11:11
 */
public class _377_组合总和Ⅳ {

	// 完全背包 + 凑满问题 + 排列数, 求组成target元素组合的个数

	/**
	 * 思路: 完全背包
	 *
	 * 1. 确定dp数组以及下标含义
	 * dp[j]: 凑成目标数为j的排列数为dp[j]
	 *
	 * 2. 确定递推公式
	 * dp[j] += dp[j-nums[i]]
	 * 求凑满元素的个数问题,都是这样的公式
	 *
	 * 3. 初始化
	 * dp[0] = 1,是一切递推的前提
	 *
	 * 4. 确定遍历顺序
	 *  求排列数,先遍历背包容量,再遍历物品
	 *  因为是完全背包,所以背包容量应该正序遍历
	 *  因为是排列问题,所以外层是背包容量
	 *
	 *  5. 举例推导递推公式
	 *  nums = [1,2,3], target = 4
	 *   背包容量 0 1 2 3 4
	 *  物品0    1 1 1 2 4
	 *  物品1    1 1 2 3 6
	 *  物品2    1 1 2 4 7
	 */
	public int combinationSum4(int[] nums, int target) {
		int[] dp = new int[target+1];

		dp[0] = 1;

		// 凑满排列问题,外层先遍历背包容量
		for (int j = 1; j <= target; j++) {
			// 内存再遍历物品
			for (int i = 0; i < nums.length; i++) {
				if(j >= nums[i]) {
					dp[j] += dp[j-nums[i]];
				}
			}
		}

		return dp[target];
	}
}
