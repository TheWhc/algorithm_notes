package 双指针法.从前往后;


/**
 * @ClassName: _19_删除链表的倒数第N个结点
 * @Author: whc
 * @Date: 2021/07/04/12:45
 */
public class _19_删除链表的倒数第N个结点 {

	/**
	 * 思路: 虚拟头结点 + 快慢指针一次遍历法
	 * 1. 快指针先走n步
	 * 2. 快慢指针同时,直到fast.next == null
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummyNode = new ListNode(-1);
		dummyNode.next = head;
		ListNode fast = dummyNode;
		ListNode slow = dummyNode;
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}

		while(fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		slow.next = slow.next.next;

		return dummyNode.next;
	}
}
