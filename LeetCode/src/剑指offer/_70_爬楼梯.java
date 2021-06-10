package 剑指offer;

/**
 * @ClassName: 待分类._70_爬楼梯
 * @Author: whc
 * @Date: 2021/05/23/9:27
 */
public class _70_爬楼梯 {

	/**
	 *  思路1: 动态规划求解
	 *  dp[i] = dp[i-1] + dp[i-2]
	 *  由于dp[i]只与前面两项相关,因此可以通过三个变量sum,a,b记录,优化空间
	 *
	 *  时间:O(n)
	 *  空间:O(1)
	 */
	/*public int climbStairs(int n) {
		if(n < 2) {
			return 1;
		}

		int a = 1;
		int b = 1;
		int sum = 0;
		for(int i = 2; i <= n; i++) {
			sum = a + b;
			a = b;
			b = sum;
		}

		return b;
	}*/

	/**
	 * 思路: 完全背包问题中的求排列问题
	 *
	 * n相当于背包容量
	 * 每次爬1,2阶相当于物品
	 *
	 * 1. 确定dp数组以及下标含义 dp[j]表示爬到j层的排列数
	 * 2. 确定递推公式, dp[j] += dp[j-nums[i]]  其中nums[i] = {1,2}
	 * 3. 进行初始化, dp[0] = 1,是递推公式的前提
	 * 4. 确定遍历顺序, 排列问题是先遍历背包容量,后遍历物品,外循环背包容量从0开始从前往后推增
	 * 5. 返回结果值dp[j]
	 *
	 * 时间: O(n*m)  m=2
	 * 空间: O(n)
	 *
	 */
	public int climbStairs(int n) {
		// 1. 确定dp数组以及下标含义
		// dp[j]表示凑成n的排列数
		int[] dp = new int[n+1];

		// 2. 确定递推公式
		// 物品 nums[i] = {1,2}
		// dp[j] += dp[j-nums[i]]

		// 3. 初始化
		// dp[0]=1是递推公式的前提
		dp[0] = 1;

		int[] nums = {1,2};
		// 4. 确定遍历顺序
		// 排列问题: 先背包容量,后物品, 外循环背包容量从0从前往后遍历
		for(int j = 0; j <= n; j++) {
			for(int i = 0; i < nums.length; i++) {
				if(j >= nums[i]) {
					dp[j] += dp[j-nums[i]];
				}
			}
		}

		return dp[n];
	}
}
