package 动态规划.子序列问题.连续;

/**
 * @ClassName: _718_最长重复子数组
 * @Author: whc
 * @Date: 2021/06/15/14:02
 */
public class _718_最长重复子数组 {

	/**
	 *  思路: 动态规划
	 *  1. dp[i][j] : 表示nums1中包含下标i在内的数组元素和nums2中包含下标j在内的数组元素最长重复子数组(连续的)
	 *  2. if(nums1[i-1] == nums2[j-1]) {
	 *      dp[i][j] = dp[i-1][j-1] + 1;
	 *  }
	 *  3. dp[0][j] = 0, dp[i][0] = 0
	 *  4. 外层遍历nums1,内层遍历nums2
	 *
	 *  时间: O(n*m)
	 *  空间: O(n*m)
	 */
	/*public int findLength(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;

		int[][] dp = new int[n+1][m+1];

		int res = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if(nums1[i-1] == nums2[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}

				res = Math.max(res, dp[i][j]);
			}
		}
		return res;
	}*/

	// 动态规划 + 空间优化
	// 时间: O(n*m) 空间: O(m)
	// 注意: nums2应该从后往前遍历, 如果从前往后遍历, 会出现覆盖问题
	public int findLength(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;

		int[] dp = new int[m+1];

		int res = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = m; j > 0; j--) {
				if(nums1[i-1] == nums2[j-1]) {
					dp[j] = dp[j-1] + 1;
				} else {
					// 注意这里不相等要等于0
					dp[j] = 0;
				}
				res = Math.max(res, dp[j]);
			}
		}

		return res;
	}

}
