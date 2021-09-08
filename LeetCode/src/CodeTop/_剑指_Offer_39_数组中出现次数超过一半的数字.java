package CodeTop;

/**
 * @ClassName: _剑指_Offer_39_数组中出现次数超过一半的数字
 * @Author: whc
 * @Date: 2021/09/08/21:28
 */
public class _剑指_Offer_39_数组中出现次数超过一半的数字 {

	// 摩尔投票法
	public int majorityElement(int[] nums) {
		int vote = nums[0];
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if(count == 0) {
				vote = nums[i];
			}
			if(nums[i] != vote) {
				count--;
			} else {
				count++;
			}
		}

		return vote;
	}
}
