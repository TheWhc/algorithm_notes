package 剑指offer;

/**
 * @ClassName: 剑指offer._剑指_Offer_39_数组中出现次数超过一半的数字
 * @Author: whc
 * @Date: 2021/04/02/9:19
 */
public class _剑指_Offer_39_数组中出现次数超过一半的数字 {

	/**
	 *  思路: 摩尔投票法
	 *
	 *  时间: O(n)
	 *  空间: O(1)
	 */
	public int majorityElement(int[] nums) {
		int vote = 0;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if(count == 0) {
				vote = nums[i];
			}
			count += vote == nums[i] ? 1 : -1;
		}
		return vote;
	}
}
