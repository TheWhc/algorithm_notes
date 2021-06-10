package 双指针法;

/**
 * @ClassName: _287_寻找重复数
 * @Author: whc
 * @Date: 2021/04/15/15:34
 */
public class _287_寻找重复数 {

	// 快慢指针
	public int findDuplicate(int[] nums) {
		int fast = nums[0];
		int slow = nums[0];

		while(true) {
			fast = nums[nums[fast]];
			slow = nums[slow];
			if(fast == slow) {
				break;
			}
		}

		fast = nums[0];
		while(fast != slow) {
			fast = nums[fast];
			slow = nums[slow];
		}

		return slow;
	}
}
