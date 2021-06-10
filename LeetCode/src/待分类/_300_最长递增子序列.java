package 待分类;

import java.util.Arrays;

/**
 * @ClassName: 待分类._300_最长递增子序列
 * @Author: whc
 * @Date: 2021/03/15/11:25
 */
public class _300_最长递增子序列 {
	/*public int lengthOfLIS(int[] nums) {
		if(nums.length == 0) return 0;
		// dp[i]表示nums前i个数字的最长子序列长度
		int[] dp = new int[nums.length];
		int res = 0;
		Arrays.fill(dp, 1);
		// 时间复杂度O(n^2)
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if(nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			res = Math.max(res, dp[i]);
		}

		return res;
	}*/


	/*public int lengthOfLIS(int[] nums) {
		int len = nums.length;
		if(len <= 1) {
			return len;
		}

		// tail数组定义: 长度为i+1的上升子序列的末尾最小是几
		// tail数组未必是真实的最长上升子序列,但长度是对的
		int[] tail = new int[len];
		tail[0] = nums[0];
		int end = 0;

		for (int i = 1; i < len; i++) {
			if(nums[i] > tail[end]) {
				end++;
				tail[end] = nums[i];
			} else {
				// 使用二分查找,在有序数组tail中
				// 找到第一个大于等于nums[i]的元素,尝试让那个元素最小
				int left = 0;
				int right = end;
				while(left < right) {
					int mid = left + ((right - left) >> 1);
					if(tail[mid] < nums[i]) {
						left = mid + 1;
					} else {
						right = mid;
					}
				}
				tail[left] = nums[i];
			}
		}
		end++;
		return end;
	}*/

	public static void main(String[] args) {
		lengthOfLIS(new int[]{0,1,0,3,2,3});
	}

	public static int lengthOfLIS(int[] nums) {
		// 1. 确定dp数组以及下标含义
		// dp[i]表示i之前包括i的最长上升子序列
		int[] dp = new int[nums.length];

		// 2. 确定递推公式
		// nums[i] > nums[j]  dp[i] = Max(dp[i], dp[j]+1)

		// 3. 初始化
		Arrays.fill(dp, 1);

		int res = 0;
		// 4. 确定遍历顺序
		// 从前往后
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if(nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			res = Math.max(res, dp[i]);
		}

		return res;
	}
}
