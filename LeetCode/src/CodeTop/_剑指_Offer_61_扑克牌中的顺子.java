package CodeTop;

import java.util.Arrays;

/**
 * @ClassName: _剑指_Offer_61_扑克牌中的顺子
 * @Author: whc
 * @Date: 2021/09/10/18:09
 */
public class _剑指_Offer_61_扑克牌中的顺子 {

	public boolean isStraight(int[] nums) {
		Arrays.sort(nums);
		int jokers = 0;

		for (int i = 0; i < 4; i++) {
			if(nums[i] == 0) {
				jokers++;
			} else if(nums[i+1] == nums[i]) {
				return false;
			}
		}

		return nums[4] - nums[jokers] < 5;
	}
}
