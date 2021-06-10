package 待分类;

/**
 * @ClassName: 待分类._198_打家劫舍
 * @Author: whc
 * @Date: 2021/04/10/11:59
 */
public class _198_打家劫舍 {

	public int rob(int[] nums) {
		if(nums.length == 0)
			return 0;
		if(nums.length == 1)
			return nums[0];
		// 1. 定义dp数组以及下标含义
		// dp[i]表示下标i以内的房屋,最多可以偷窃的金额
		int[] dp = new int[nums.length];

		// 2. 确定递推公式
		// 			   偷第i间房间           不偷第i间房间
		// dp[i] = max(dp[i-2] + nums[i], dp[i-1])

		// 3. 初始化
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);

		// 4. 确定遍历顺序
		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
		}

		return dp[nums.length-1];
 	}
}
