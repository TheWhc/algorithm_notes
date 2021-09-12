package CodeTop;

/**
 * @ClassName: _377_组合总和Ⅳ
 * @Author: whc
 * @Date: 2021/09/12/14:55
 */
public class _377_组合总和Ⅳ {

	/**
	 * 思路： 动态规划
	 *
	 * 完全背包 排列问题
	 *
	 * 1. 确定dp数组以及下标含义
	 * dp[j]表示凑成容量为j时的排列数
	 *
	 * 2. 确定递推公式
	 * dp[j] += dp[j-nums[i]]
	 *
	 * 3. 初始化
	 * dp[0] = 1
	 *
	 * 4. 确定遍历顺序
	 * 先遍历背包容量,后遍历物品
	 *
	 * 
	 */
	public int combinationSum4(int[] nums, int target) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		int[] dp = new int[target+1];
		dp[0] = 1;

		// 外层遍历背包容量,从小到大
		for (int j = 0; j <= target; j++) {
			// 内层遍历物品
			for (int i = 0; i < nums.length; i++) {
				if(j >= nums[i]) {
					dp[j] += dp[j-nums[i]];
				}
			}
		}

		return dp[target];
	}
}
