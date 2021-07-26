package CodeTop;

/**
 * @ClassName: _283_移动零
 * @Author: whc
 * @Date: 2021/07/26/15:38
 */
public class _283_移动零 {

	public void moveZeroes(int[] nums) {
		int idx = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] != 0) {
				nums[idx++] = nums[i];
			}
		}

		for (int i = idx; i < nums.length; i++) {
			nums[i] = 0;
		}
	}
}
