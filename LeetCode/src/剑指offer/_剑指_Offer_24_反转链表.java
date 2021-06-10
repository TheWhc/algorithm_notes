package 剑指offer;

/**
 * @ClassName: 剑指offer._剑指_Offer_24_反转链表
 * @Author: whc
 * @Date: 2021/04/02/0:24
 */
public class _剑指_Offer_24_反转链表 {

	// 2021/4/2 二刷
	// 递归
	public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode next = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return next;
	}
}
