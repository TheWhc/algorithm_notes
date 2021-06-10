package 剑指offer;

/**
 * @ClassName: _剑指_Offer_03_数组中重复的数字
 * @Author: whc
 * @Date: 2021/05/22/9:25
 */
public class _剑指_Offer_03_数组中重复的数字 {

	/**
	 * 思路: 原地哈希,将nums[i]不断与nums[nums[i]]交换,直到nums[i] = i为止
	 *      如果在交换过程中出现nums[nums[i]]位置已经有元素了,那么就返回结果nums[i]
	 * 时间复杂度: O(n)
	 * 空间复杂度: O(1)
	 */
	public int findRepeatNumber(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			while(nums[i] != i) {
				if(nums[nums[i]] == nums[i]) {
					return nums[i];
				}
				int temp = nums[i];
				nums[i] = nums[nums[i]];
				nums[temp] = temp;
			}
		}
		return -1;
	}
}
