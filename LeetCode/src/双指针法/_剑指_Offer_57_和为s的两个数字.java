package 双指针法;

/**
 * @ClassName: 剑指offer._剑指_Offer_57_和为s的两个数字
 * @Author: whc
 * @Date: 2021/04/02/9:28
 */
public class _剑指_Offer_57_和为s的两个数字 {

	/**
	 *  思路: 双指针法
	 *  1. 左指针与右指针的数字和如果大于target,则右指针--
	 *  2. 左指针与右指针的数字和如果小于target,则左指针++
	 *  3. 左指针与右指针的数字和如果等于target,则直接返回
	 */
	public int[] twoSum(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;
		while(left < right) {
			if(nums[left] + nums[right] > target) {
				right--;
			} else if(nums[left] + nums[right] < target) {
				left++;
			} else {
				return new int[]{nums[left], nums[right]};
			}
		}

		return new int[0];
	}
}
