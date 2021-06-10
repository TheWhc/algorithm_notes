package 哈希.原地哈希;

/**
 * @ClassName: 待分类._41_缺失的第一个正数
 * @Author: whc
 * @Date: 2021/04/27/11:09
 */
public class _41_缺失的第一个正数 {

	public int firstMissingPositive(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			while(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i]-1]) {
				int temp = nums[i];
				nums[i] = nums[nums[i]-1];
				nums[temp-1] = temp;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if(nums[i] != i + 1) {
				return i+1;
			}
		}

		// 都正确返回数组长度
		return nums.length + 1;
	}
}
