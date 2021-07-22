package CodeTop;

/**
 * @ClassName: _2_两数相加
 * @Author: whc
 * @Date: 2021/07/22/13:31
 */
public class _2_两数相加 {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;

		int carry = 0;
		while(l1 != null || l2 != null || carry != 0) {
			int x1 = (l1 == null) ? 0 : l1.next.val;
			int x2 = (l2 == null) ? 0 : l2.next.val;
			int sum = x1 + x2 + carry;
			carry = sum / 10;
			cur.next = new ListNode(sum % 10);
			cur = cur.next;
			l1 = (l1 == null) ? null : l1.next;
			l2 = (l2 == null) ? null : l2.next;
		}

		return dummy.next;
	}
}
