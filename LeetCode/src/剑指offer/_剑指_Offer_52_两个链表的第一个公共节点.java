package 剑指offer;

/**
 * @ClassName: 剑指offer._剑指_Offer_52_两个链表的第一个公共节点
 * @Author: whc
 * @Date: 2021/04/02/11:05
 */
public class _剑指_Offer_52_两个链表的第一个公共节点 {
	/*public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode p1 = headA;
		ListNode p2 = headB;
		while(p1 != p2) {
			p1 = p1 == null ? headB : p1.next;
			p2 = p2 == null ? headA : p2.next;
		}

		return p1;
	}*/

	/**
	 *  思路: 双指针法
	 *  1. p、q同时走,p或q一旦遇到空时,就将指针指向对方的起始点
	 *  2. 相当于p走了a+b步, q走了b+a步
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
