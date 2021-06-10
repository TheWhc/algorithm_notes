package top100;

/**
 * @ClassName: _152_乘积最大子数组
 * @Author: whc
 * @Date: 2021/05/06/9:58
 */
public class _152_乘积最大子数组 {

	/*public int maxProduct(int[] nums) {
		int maxValue = Integer.MIN_VALUE;

		// 思路: 可能出现奇数个负数时,有两者情况,
		// 从正序遍历(不包含最后一个负数子数组)和倒叙遍历(不包含第一个负数的子数组)找出最大值
		// 当出现0时,连乘值重置为1

		int mulSum = 1;
		// 正序遍历
		for (int i = 0; i < nums.length; i++) {
			mulSum *= nums[i];
			maxValue = Math.max(maxValue, mulSum);
			if(nums[i] == 0) {
				mulSum = 1;
			}
		}

		mulSum = 1;

		// 倒叙遍历
		for (int i = nums.length-1; i >= 0; i--) {
			mulSum *= nums[i];
			maxValue = Math.max(maxValue, mulSum);
			if(nums[i] == 0) {
				mulSum = 1;
			}
		}

		return maxValue;
	}*/


	// 动态规划
	public int maxProduct(int[] nums) {
		// dpMax[i]表示以第i个元素结尾的乘积最大值,必须包含第i个元素
		int[] dpMax = new int[nums.length]; // 最大值
		int[] dpMin = new int[nums.length]; // 最小值

		// 递推公式
		// dpMax[i] = Math.max(nums[i], dpMax[i-1] * nums[i], dpMin[i-1] * nums[i])
		// dpMin[i] = Math.min(nums[i], dpMax[i-1] * nums[i], dpMin[i-1] * nums[i])

		// 初始化
		dpMax[0] = nums[0];
		dpMin[0] = nums[0];

		int res = Integer.MIN_VALUE;

		// 遍历顺序
		for (int i = 1; i < nums.length; i++) {
			dpMax[i] = Math.max(nums[i], Math.max(dpMax[i-1] * nums[i], dpMin[i-1] * nums[i]));
			dpMin[i] = Math.min(nums[i], Math.min(dpMax[i-1] * nums[i], dpMin[i-1] * nums[i]));
			res = Math.max(res, dpMax[i]);
		}

		return res;

	}

}
