package 动态规划.背包问题._01背包.装满问题;

/**
 * @ClassName: _494_目标和
 * @Author: whc
 * @Date: 2021/06/27/11:11
 */
public class _494_目标和 {

	// 凑满背包方法数问题

	/**
	 * 思路: 01背包动态规划
	 *
	 * 如何转化为01背包?
	 * 假设加法总和为x,那么减法对应的总和为sum - x
	 * 所以 x - (sum - x) = target
	 *  x = (target + sum) / 2
	 *  所以只需要求凑满x有多少种方案就可以了
	 *
	 *  注意这里的除2问题,如果不能整除,那么直接返回0,没有方案
	 *  还有一个问题这里是两个数相加,可能出现整数溢出,但本题不用担心溢出问题
	 *
	 *  1. 确定dp数组
	 *  dp[j]:表示凑满j有多少种方案,注意是凑满,之前都是求容量为j时,最多能装多少
	 *
	 *  2. 确定递推公式
	 *  dp[j] += dp[j - nums[i]]
	 *  只需要搞到nums[i],凑成dp[j]就有dp[j-nums[i]]方法
	 *
	 *  3. 初始化
	 *  dp[0] = 1 : 表示凑满背包容量为0,有1种方案,dp[0]也是一切递推结果的起源
	 *
	 *  4. 确定遍历顺序
	 *  先遍历物品,再遍历背包容量,注意背包容量逆序遍历
	 *
	 *  5. 举例推导数组
	 *  例子: [1,1,1,1,1]
	 *    下标   0  1  2  3  4
	 *  物品0    1  1  0  0  0
	 *  物品1    1  2  1  0  0
	 *  物品2    1  3  3  1  0
	 *  物品3    1  4  6  4  1
	 *  物品4    1  5  10 10 5
	 *
	 *  时间: O(n * m)  n为nums数组长度,m为背包容量
	 *  空间: O(m)
	 *
	 */
	public int findTargetSumWays(int[] nums, int target) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}

		int bagSize = (target + sum) / 2;
		if((target + sum) % 2 == 1) {
			return 0;
		}

		int[] dp = new int[bagSize + 1];

		dp[0] = 1;

		// 遍历物品
		for (int i = 0; i < nums.length; i++) {
			// 遍历背包容量
			for (int j = bagSize; j >= nums[i]; j--) {
				dp[j] += dp[j - nums[i]];
			}
		}

		return dp[bagSize];
	}

}
