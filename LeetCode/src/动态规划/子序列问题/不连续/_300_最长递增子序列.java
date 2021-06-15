package 动态规划.子序列问题.不连续;

import java.util.Arrays;

/**
 * @ClassName: _300_最长递增子序列
 * @Author: whc
 * @Date: 2021/06/14/12:08
 */
public class _300_最长递增子序列 {

	/**
	 *  思路: 动态规划
	 *  1. 确定dp数组以及下标含义
	 *  	dp[i]: 表示包含下标i在内的最长递增子序列
	 *  2. 确定递推公式
	 *  	位置i的最长上升子序列等于j从0到i-1各个位置的最长上升子序列+1的最大值
	 *  	if(nums[i] > nums[j])
	 *  		dp[i] = Math.max(dp[i], dp[j]+1)
	 *  3. 初始化
	 *  	每一个dp[i]至少都是1
	 *  4. 确定遍历顺序
	 *  	i是从前往后遍历
	 *  	j是从0开始到i-1遍历
	 *  5. 举例推导dp数组
	 *  	[0, 1, 0, 3, 2]
	 *  i=1  1  2  1  1  1
	 *  i=2  1  2  1  1  1
	 *  i=3  1  2  1  3  1
	 *  i=4  1  2  1  3  3
	 *
	 *  时间: O(n^2)
	 *  空间: O(n)
	 */
	/*public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		int res = 1;
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if(nums[i] > nums[j])
					dp[i] = Math.max(dp[i], dp[j]+1);
			}
			// 取长的子序列
			res = Math.max(res, dp[i]);
		}
		return res;
	}*/

	/**
	 *  思路: 贪心
	 *
	 *  二分插入法
	 *
	 *  1. 对原序列进行遍历,将每位元素二分插入dp数组中
	 *  	- 如果dp数组中元素都比它小,将它插到最后
	 *  	- 否则,用它覆盖掉比它大的元素中最小的那个
	 *
	 *  2. dp数组未必是真实的最长上升子序列,但长度是对的
	 *
	 *  时间: O(nlogn)
	 *  空间: O(n)
	 */
	public int lengthOfLIS(int[] nums) {
		// dp数组是递增的
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		// dp数组最后一个元素的下标,即dp中最大元素的下标
		int end = 0;
		for (int i = 1; i < nums.length; i++) {
			int num = nums[i];

			// 当前元素大于dp数组最后一个元素,则直接插入到后面
			if(num > dp[end]) {
				dp[++end] = num;
				continue;
			}

			// 二分找到比num元素大的元素中最小的那个
			int left = 0;
			int right = end;
			while(left < right) {
				int mid = left + (right - left) / 2;
				if(dp[mid] < num) {
					left = mid + 1;
				} else {
					// 注意这里的right = mid
					right = mid;
				}
			}
			dp[left] = num;
		}

		return end+1;
	}

}
