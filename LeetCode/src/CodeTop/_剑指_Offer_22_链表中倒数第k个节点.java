package CodeTop;

/**
 * @ClassName: _剑指_Offer_22_链表中倒数第k个节点
 * @Author: whc
 * @Date: 2021/07/22/9:31
 */
public class _剑指_Offer_22_链表中倒数第k个节点 {

	// 双指针法
	public ListNode getKthFromEnd(ListNode head, int k) {
		ListNode p = head, q = head;

		for (int i = 0; i < k; i++) {
			if(p != null) {
				p = p.next;
			}
		}

		while(p != null) {
			p = p.next;
			q = q.next;
		}

		return q;
	}

}
