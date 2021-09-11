package CodeTop;

/**
 * @ClassName: _剑指_Offer_24_反转链表
 * @Author: whc
 * @Date: 2021/09/11/23:23
 */
public class _剑指_Offer_24_反转链表 {

	/*public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}

		ListNode nextNode = reverseList(head.next);
		head.next.next = head;
		head.next = null;

		return nextNode;
	}*/

	public ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode cur = head;
		while(cur != null) {
			ListNode tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}

		return pre;
	}
}
