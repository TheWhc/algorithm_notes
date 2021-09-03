package CodeTop;

/**
 * @ClassName: _560_和为K的子数组
 * @Author: whc
 * @Date: 2021/08/20/17:06
 */
public class _560_和为K的子数组 {

	public static int subarraySum(int[] nums, int k) {
		// 前缀数组
		int[] preSum = new int[nums.length + 1];

		for (int i = 0; i < nums.length; i++) {
			preSum[i + 1] = preSum[i] + nums[i];
		}

		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				if(preSum[j + 1] - preSum[i] == k) {
					count++;
				}
			}
		}

		return count;
	}
}
