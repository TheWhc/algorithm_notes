package top100;

import java.util.HashMap;

/**
 * @ClassName: _560_和为K的子数组
 * @Author: whc
 * @Date: 2021/05/20/9:31
 */
public class _560_和为K的子数组 {

	// 暴力求解
	// 时间复杂度O(n^2)
	// 空间O(1)
	/*public int subarraySum(int[] nums, int k) {
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				if(sum == k) {
					res++;
				}
			}
		}
		return res;
	}*/

	// 前缀和
	// 时间复杂度O(n^2)
	// 空间复杂度O(n)
	/*public int subarraySum(int[] nums, int k) {
		int res = 0;
		int len = nums.length;
		// prefixSum[i]表示从第0项到第i项区间和
		int[] prefixSum = new int[len + 1];
		// 构造prefixSum
		for (int i = 0; i < len; i++) {
			// 前缀和从prefixSum[1]开始填充
			// 比如	nums =   [1,1,1]
			// prefixSum = [0,1,2,3]
			prefixSum[i+1] = prefixSum[i] + nums[i];
		}

		// 枚举区间的左端点
		for (int left = 0; left < len; left++) {
			// 枚举区间的右端点
			for (int right = left; right < len; right++) {
				// 区间和 [left...right]
				if(prefixSum[right+1] - prefixSum[left] == k) {
					res++;
				}
			}
		}
		return res;
	}*/

	public static void main(String[] args) {
		subarraySum(new int[]{1,2,6,4,-1,5}, 3);
	}

	public static int subarraySum(int[] nums, int k) {
		if (nums.length == 0) {
			return 0;
		}

		// key为前缀和, value为前缀和值出现次数
		HashMap<Integer, Integer> map = new HashMap<>();
		// 预处理,否则可能出现漏掉情况!!!
		map.put(0, 1);
		int count = 0;
		int preSum = 0;
		for (int num : nums) {
			preSum += num;
			if(map.containsKey(preSum - k)) {
				count += map.get(preSum - k);
			}
			map.put(preSum, map.getOrDefault(preSum, 0) + 1);
		}

		return count;
	}

}
