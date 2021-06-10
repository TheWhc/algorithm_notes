package top100;

/**
 * @ClassName: _287_寻找重复数
 * @Author: whc
 * @Date: 2021/04/15/12:53
 */
public class _287_寻找重复数 {
	/*public int findDuplicate(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}

		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() >= 2) {
				return entry.getKey();
			}
		}

		return -1;
	}*/

	// 快慢指针
	public int findDuplicate(int[] nums) {
		// 将数组当成链表来看
		// 数组的下标是指向元素的指针,吧数组的元素也看做指针
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

		while(slow != fast) {
			fast = nums[fast];
			slow = nums[slow];
		}

		return slow;
	}
}
