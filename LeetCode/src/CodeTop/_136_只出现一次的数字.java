package CodeTop;

/**
 * @ClassName: _136_只出现一次的数字
 * @Author: whc
 * @Date: 2021/07/25/18:27
 */
public class _136_只出现一次的数字 {

	public int singleNumber(int[] nums) {
		int res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			res ^= nums[i];
		}
		return res;
	}
}
