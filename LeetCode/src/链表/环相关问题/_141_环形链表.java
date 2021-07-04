package 链表.环相关问题;

import 链表.ListNode;

/**
 * @ClassName: _141_环形链表
 * @Author: whc
 * @Date: 2021/07/04/19:11
 */
public class _141_环形链表 {

	/**
	 * 思路: 快慢指针法
	 * 1. 让快指针每次走2步, 慢指针每次走1步2
	 * 2. 直到两者相遇为止,返回true
	 * 	  若快指针fast == null || fast.next == null, 则return false
	 */
	public boolean hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while(true) {
			if(fast == null || fast.next == null) {
				return false;
			}
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) {
				return true;
			}
		}
	}

}
