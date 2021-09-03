package CodeTop;

/**
 * @ClassName: _287_寻找重复数
 * @Author: whc
 * @Date: 2021/09/01/22:23
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

		return fast;
	}
}
