package 动态规划.子序列问题.不连续;

/**
 * @ClassName: _1035_不相交的线
 * @Author: whc
 * @Date: 2021/06/15/13:29
 */
public class _1035_不相交的线 {

	/**
	 *  思路: 动态规划
	 *  1. 确定dp数组以及下标含义
	 *  	dp[i][j]表示s1中包含下标i在内的元素和s2中包含下标j在内的元素的最多相同元素
	 *  2. 确定递推公式
	 *  	if(nums[i] == nums[j]) {
	 *  	 	dp[i][j] = dp[i-1][j-1] + 1
	 *  	} else {
	 *  	 	dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])
	 *  	}
	 *  3. 初始化
	 *  	i=0时,dp[0][j] = 0
	 *  	j=0时,dp[i][0] = 0
	 *  4. 遍历顺序
	 *  	外层先遍历nums1,内层遍历nums2
	 *
	 *  时间: O(n*m)
	 *  空间: O(n*m)
	 *
	 */
	/*public int maxUncrossedLines(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;
		int[][] dp = new int[n+1][m+1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if(nums1[i-1] == nums2[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}

		return dp[n][m];
	}*/

	// 动态规划 + 空间优化
	// 时间: O(n*m)
	// 空间: O(m)
	public int maxUncrossedLines(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;
		int[] dp = new int[m+1];
		int leftUp = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				int temp = dp[j];
				if(nums1[i-1] == nums2[j-1]) {
					dp[j] = leftUp + 1;
				} else {
					dp[j] = Math.max(dp[j], dp[j-1]);
				}
				leftUp = temp;
			}
			leftUp = 0;
		}

		return dp[m];
	}

}
