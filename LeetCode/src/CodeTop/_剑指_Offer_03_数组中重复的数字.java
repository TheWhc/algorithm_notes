package CodeTop;

/**
 * @ClassName: _剑指_Offer_03_数组中重复的数字
 * @Author: whc
 * @Date: 2021/09/11/23:03
 */
public class _剑指_Offer_03_数组中重复的数字 {

	// 原地哈希
	public int findRepeatNumber(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			while(nums[i] != i) {
				if(nums[i] == nums[nums[i]]) {
					return nums[i];
				}
				int temp = nums[i];
				nums[i] = nums[nums[i]];
				nums[nums[i]] = temp;
			}
		}

		return -1;
	}

}
