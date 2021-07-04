package 链表.删除节点;

import 链表.ListNode;

/**
 * @ClassName: _19_删除链表的倒数第N个结点
 * @Author: whc
 * @Date: 2021/07/04/12:45
 */
public class _19_删除链表的倒数第N个结点 {

	/**
	 * 思路: 虚拟头结点 + 两次遍历删除法
	 * 1. 第一次遍历,统计节点数量
	 *   算出要删除元素的下标
	 * 2. 第二次遍历,找到删除元素的前节点
	 *   删除要删除的元素
	 */
	/*public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;
		int size = 0;
		ListNode cur = dummyHead;
		while(cur.next != null) {
			size++;
			cur = cur.next;
		}
		int removeIdx = size - n;

		cur = dummyHead;
		for(int i = 0; i < removeIdx; i++) {
			cur = cur.next;
		}
		cur.next = cur.next.next;

		return dummyHead.next;
	}*/

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
