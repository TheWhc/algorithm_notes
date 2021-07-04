package 链表.环相关问题;

import 双指针法.ListNode;

/**
 * @ClassName: _142_环形链表II
 * @Author: whc
 * @Date: 2021/07/04/18:13
 */
public class _142_环形链表II {

	/**
	 * 思路：快慢指针
	 * 1. 让快慢指针同时指向起始位置
	 * 2. 第一次相遇,快指针每次走两步, 慢指针每次走一步
	 * 3. 第二次相遇,让快指针指向起始位置, 然后快慢指针每次走一步, 直到遇到相交节点(走了a步), 即环入口节点
	 */
	public ListNode detectCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		while(true) {
			// 不是环形链表
			if(fast == null || fast.next == null) {
				return null;
			}

			fast = fast.next.next;
			slow = slow.next;
			// 第一次相遇时,slow = nb
			if(fast == slow) {
				break;
			}
		}

		// 第二次相遇时
		fast = head;
		while(fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}

		return fast;
	}
}
