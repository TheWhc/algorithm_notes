package 链表.环相关问题;

/**
 * @ClassName: _287_寻找重复数
 * @Author: whc
 * @Date: 2021/07/04/19:22
 */
public class _287_寻找重复数 {

	/**
	 * 思路：快慢指针法
	 *
	 * 按照环形链表II的思路一样,找到元素的入口点
	 *
	 * 如何转化为链表?
	 * 将数组元素的值当作下一个节点的下标
	 *
	 * 1. 第一次相遇, fast每次走2步, slow每次走1步
	 * 2. 第二次相遇, slow,fast每次走1步
	 *
	 * 举例: 1 3 4 2 2
	 * 下标：0 1 2 3 4
	 *
	 * 1->3->2->4->2
	 */
	public int findDuplicate(int[] nums) {
		int fast = nums[0];
		int slow = nums[0];

		// 第一次相遇
		while(true) {
			fast = nums[nums[fast]];
			slow = nums[slow];
			if(fast == slow) {
				break;
			}
		}

		// 第二次相遇
		fast = nums[0];
		while(fast != slow) {
			fast = nums[fast];
			slow = nums[slow];
		}

		return fast;
	}
}
