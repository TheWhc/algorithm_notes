package top100;

/**
 * @ClassName: _238_除自身以外数组的乘积
 * @Author: whc
 * @Date: 2021/05/14/10:39
 */
public class _238_除自身以外数组的乘积 {

	/*public int[] productExceptSelf(int[] nums) {
		int[] left = new int[nums.length];
		// 边界
		left[0] = 1;

		int[] right = new int[nums.length];
		// 初始化
		right[right.length-1] = 1;

		for (int i = 1; i < nums.length; i++) {
			left[i] = left[i-1] * nums[i-1];
		}

		for (int j = nums.length-2; j >= 0; j--) {
			right[j] = right[j+1] * nums[j+1];
		}

		int[] res = new int[nums.length];
		for (int i = 0; i < res.length; i++) {
			res[i] = left[i] * right[i];
		}

		return res;
	}*/

	// 优化: 额外空间为O(1)
	public int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
		res[0] = 1;
		// 先保存左边的结果
		for (int i = 1; i < nums.length; i++) {
			res[i] = nums[i-1] * res[i-1];
		}

		int right = 1;
		for (int j = nums.length-2; j >= 0; j--) {
			right = right * nums[j+1];
			res[j] = res[j] * right;
		}

		return res;
	}
}
