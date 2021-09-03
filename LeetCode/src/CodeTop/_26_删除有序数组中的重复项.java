package CodeTop;

/**
 * @ClassName: _26_删除有序数组中的重复项
 * @Author: whc
 * @Date: 2021/09/03/23:19
 */
public class _26_删除有序数组中的重复项 {

	// 删除选项 -> 双指针法
	public int removeDuplicates(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}

		// 快慢指针下标
		int slow = 0;
		int fast = 1;

		while(fast != nums.length) {
			if(nums[slow] == nums[fast]) {
				fast++;
			} else {
				nums[slow+1] = nums[fast];
				fast++;
				slow++;
			}
		}

		return slow + 1;
	}

}
