package 前缀和;

/**
 * @ClassName: _724_寻找数组的中心下标
 * @Author: whc
 * @Date: 2021/08/20/17:15
 */
public class _724_寻找数组的中心下标 {

	/**
	 * 例子：
	 * 				1 7  3  6  5  6
	 * 	leftSum  0  1 8 11 17 22 28
	 */
	public int pivotIndex(int[] nums) {

		int preSum = 0;
		for(int num : nums) {
			preSum += num;
		}

		int leftSum = 0;
		for (int i = 0; i < nums.length; i++) {
			if(leftSum == preSum - nums[i] - leftSum) {
				return i;
			}
			leftSum += nums[i];
		}

		return -1;
	}

}
