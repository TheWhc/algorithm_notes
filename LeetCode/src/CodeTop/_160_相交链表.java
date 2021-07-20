package CodeTop;

/**
 * @ClassName: _160_相交链表
 * @Author: whc
 * @Date: 2021/07/20/13:29
 */
public class _160_相交链表 {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null) {
			return headB;
		}
		if(headB == null) {
			return headA;
		}

		ListNode p = headA;
		ListNode q = headB;

		while(p != q) {
			p = p == null ? headB : p.next;
			q = q == null ? headA : q.next;
		}

		return p;
	}
}
