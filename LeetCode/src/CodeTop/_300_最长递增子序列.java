package CodeTop;

import java.util.Arrays;

/**
 * @ClassName: _300_最长递增子序列
 * @Author: whc
 * @Date: 2021/07/22/10:39
 */
public class _300_最长递增子序列 {

	// 时间: O(n^2)
	// 空间: O(1)
	/*public int lengthOfLIS(int[] nums) {
		// dp[i]表示包含i在内的最长递增子序列
		int[] dp = new int[nums.length];
		int maxLen = 1;
		Arrays.fill(dp,1); // 初始化
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if(nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			maxLen = Math.max(maxLen, dp[i]);
		}

		return maxLen;
	}*/

	/**
	 * 思路: dp
	 *
	 * 1. dp[i]表示长度为i+1的所有上升子序列的末尾的最小值
	 * 2. 递推公式,在dp数组中查找第一个大于等于的数的位置,若找不到直接添加到末尾
	 *
	 * 举例: 0 1 0 3 2 3
	 * i = 0 时, 序列为 0
	 * i = 1 时, 序列为 0 1
	 * i = 2 时, 序列为 0 1
	 * i = 3 时, 序列为 0 1 3
	 * i = 4 时, 序列为 0 1 2
	 * i = 5 时, 序列为 0 1 2 3
	 *//*
	public int lengthOfLIS(int[] nums) {
		// dp[i]: 表示长度为i+1的所有上升子序列的末尾的最小值
		int[] dp = new int[nums.length];

		int len = 0;
		for (int i = 0; i < nums.length; i++) {
			int j = 0;
			// 寻找 dp 中第一个大于等于新来的数的位置
			for (j = 0; j < len; j++) {
				if(nums[i] <= dp[j]) {
					break;
				}
			}

			// 更新当前值
			dp[j] = nums[i];

			// 是否更新新长度
			if(j == len) {
				len++;
			}
		}

		return len;
	}*/

	/**
	 * 思路: dp + 二分
	 * 时间： O(nlogn)
	 *
	 * 1. dp[i]表示长度为i+1的所有上升子序列的末尾的最小值
	 * 2. 递推公式,在dp数组中查找第一个大于等于nums[i]的数的位置,若找不到直接添加到末尾
	 * 3. 再进行第2步的时候,由于dp数组一定是有序的,所以可以通过二分查找插入数的位置
	 *
	 * 举例: 0 1 0 3 2 3
	 * i = 0 时, 序列为 0
	 * i = 1 时, 序列为 0 1
	 * i = 2 时, 序列为 0 1
	 * i = 3 时, 序列为 0 1 3
	 * i = 4 时, 序列为 0 1 2
	 * i = 5 时, 序列为 0 1 2 3
	 */
	/*public int lengthOfLIS(int[] nums) {
		// dp[i]: 表示长度为i+1的所有上升子序列的末尾的最小值
		int[] dp = new int[nums.length];

		int len = 1;
		dp[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int left = 0;
			int right = len - 1;
			while(left < right) {
				int mid = left + (right - left) / 2;
				if(dp[mid] < nums[i]) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}

			if(dp[left] >= nums[i]) {
				dp[left] = nums[i];
			} else {
				dp[len] = nums[i];
				len++;
			}

		}

		return len;
	}

	public static void main(String[] args) {
		_300_最长递增子序列 _300_最长递增子序列 = new _300_最长递增子序列();
		System.out.println(_300_最长递增子序列.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
	}*/

	// 动态规划
	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];

		Arrays.fill(dp, 1);

		int maxRes = 1;

		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if(nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			maxRes = Math.max(maxRes, dp[i]);
		}

		return maxRes;
	}
}
