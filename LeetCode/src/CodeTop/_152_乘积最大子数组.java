package CodeTop;

/**
 * @ClassName: _152_乘积最大子数组
 * @Author: whc
 * @Date: 2021/08/18/10:46
 */
public class _152_乘积最大子数组 {

	public int maxProduct(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}

		int[] dpMin = new int[nums.length];
		int[] dpMax = new int[nums.length];

		dpMin[0] = nums[0];
		dpMax[0] = nums[0];
		int maxRes = 0;

		for (int i = 1; i < nums.length; i++) {
			dpMax[i] = Math.max(nums[i], Math.max(dpMax[i-1] * nums[i], dpMin[i-1] * nums[i]));
			dpMin[i] = Math.min(nums[i], Math.min(dpMax[i-1] * nums[i], dpMin[i-1] * nums[i]));
			maxRes = Math.max(maxRes, dpMax[i]);
		}

		return maxRes;
	}
}
