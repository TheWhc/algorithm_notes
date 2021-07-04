package 链表.链表相交;

import 链表.ListNode;

/**
 * @ClassName: _面试题_02_07_链表相交
 * @Author: whc
 * @Date: 2021/07/04/13:35
 */
public class _面试题_02_07_链表相交 {

	/**
	 * 思路：双指针法
	 *
	 * 设交集链表长c,链表1除交集的长度为a，链表2除交集的长度为b，有
	 * a + c + b = b + c + a
	 *
	 * 1. p,q分别指向链表A和链表B的起始节点
	 * 2. 同时遍历链表,直到遇到相交的节点为止
	 * 		若p遍历到空节点时,则让p指向另外一条链表的起始节点
	 * 		若q遍历到空节点时,则让q指向另外一条链表的起始节点
	 *
	 * 若无相交,则a + b = b + a
	 * 时间: O(n+m)
	 * 空间: O(1)
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode curA = headA;
		ListNode curB = headB;

		while(curA != curB) {
			curA = curA == null ? headB : curA.next;
			curB = curB == null ? headA : curB.next;
		}

		return curA;
	}
}
