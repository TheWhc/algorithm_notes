package CodeTop;

/**
 * @ClassName: _41_缺失的第一个正数
 * @Author: whc
 * @Date: 2021/07/24/23:16
 */
public class _41_缺失的第一个正数 {

	public int firstMissingPositive(int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			while(nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i]-1]) {
				int temp = nums[i]; // 3
				nums[i] = nums[nums[i]-1]; // nums[0] = -1
				nums[temp-1] = temp; // nums[3-1] = 3
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if(nums[i] != i + 1) {
				return i + 1;
			}
		}

		return nums.length + 1;
	}
}
