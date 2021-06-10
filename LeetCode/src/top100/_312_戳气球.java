package top100;

/**
 * @ClassName: _312_戳气球
 * @Author: whc
 * @Date: 2021/05/17/0:24
 */
public class _312_戳气球 {

	/**
	 *  思路: 动态规划
	 *  区间问题,假设最后只剩下3个气球,比如 1 2 3 4气球列表中 选择 1 2 4, 2作为最后一个引爆气球
	 *  那么假设1和4分别为左边界和右边界,中间的2最后一个引爆气球
	 *  那么求区间dp(i,j)表示开区间(i,j)能拿到的最多金币
	 *  dp(i,j) = dp(i,k) + dp(k,j) + nums[i] * nums[j] * nums[k]
	 *  k表示开区间内任意一个结点作为下标索引
	 *  注意,开区间的左端点可以移动, 右端点跟着移动满足 j - i + 1 = len(区间长度)
	 *
	 *  然后以此类推出区间长度为4,5,6时的情况,从前面的区间长度推算出
	 */
	public int maxCoins(int[] nums) {
		int n = nums.length;
		// 创建辅助数组,对数据进行迁移
		int[] temp = new int[n+2];
		temp[0] = 1;
		temp[n+1] = 1;
		for (int i = 0; i < nums.length; i++) {
			temp[i+1] = nums[i];
		}

		// 定义dp数组, dp[i][j]表示开区间(i,j)能拿到的最多金币
		int[][] dp = new int[n+2][n+2];

		// 递推公式
		// 最后剩下3个气球,设左边和右边端点为1,k为最后一个引爆气球, k可以任意选择(i,j)区间的任何一个球作为最后一个
		// 1 3 1
		// i k j
		// dp(i,j) = dp(i,k) + dp(k,j) + nums[i]*nums[k]*nums[j]
		// k为(i,j)区间内的索引任意选,最后选择最多金币的那个索引
		// 以此类推,当区间长度增大时,可以从最前的长度3推出

		// 开区间长度
		for (int len = 3; len <= n+2; len++) {
			// 开区间的左端点
			for (int i = 0; i <= n+2-len; i++) {
				int res = 0;
				// 开区间内k的索引
				// i+len-1 - i + 1 = len
				for (int k = i+1; k < i+len-1; k++) {
					int left = dp[i][k];
					int right = dp[k][i+len-1];
					res = Math.max(res, left + right + temp[i] * temp[i+len-1] * temp[k]);
				}
				dp[i][i+len-1] = res;
			}
		}

		return dp[0][n+1];
	}

}
