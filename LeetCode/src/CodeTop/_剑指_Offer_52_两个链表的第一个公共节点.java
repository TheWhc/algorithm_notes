package CodeTop;

/**
 * @ClassName: _剑指_Offer_52_两个链表的第一个公共节点
 * @Author: whc
 * @Date: 2021/09/03/23:39
 */
public class _剑指_Offer_52_两个链表的第一个公共节点 {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null) {
			return null;
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
