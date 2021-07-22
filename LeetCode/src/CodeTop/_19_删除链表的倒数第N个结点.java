package CodeTop;

/**
 * @ClassName: _19_删除链表的倒数第N个结点
 * @Author: whc
 * @Date: 2021/07/22/15:08
 */
public class _19_删除链表的倒数第N个结点 {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode p = dummy, q = dummy;

		for (int i = 0; i < n; i++) {
			if(q != null) {
				q = q.next;
			}
		}

		while(q.next != null) {
			p = p.next;
			q = q.next;
		}

		p.next = p.next.next;

		return dummy.next;
	}
}
