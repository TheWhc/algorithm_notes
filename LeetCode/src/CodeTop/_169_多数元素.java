package CodeTop;

/**
 * @ClassName: _169_多数元素
 * @Author: whc
 * @Date: 2021/07/24/16:29
 */
public class _169_多数元素 {

	public int majorityElement(int[] nums) {
		int vote = nums[0];
		int cnt = 1;

		for (int i = 1; i < nums.length; i++) {
			if(cnt == 0) {
				vote = nums[i];
			}
			if(nums[i] == vote) {
				cnt++;
			} else {
				cnt--;
			}
		}

		return vote;
	}
}
