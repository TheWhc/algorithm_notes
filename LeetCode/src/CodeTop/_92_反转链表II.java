package CodeTop;

/**
 * @ClassName: _92_反转链表II
 * @Author: whc
 * @Date: 2021/07/22/8:59
 */
public class _92_反转链表II {

	public ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode pre = dummy;
		// 第一个要反转的点的前面
		for (int i = 0; i < left-1; i++) {
			pre = pre.next;
		}

		// 第一个要反转的点
		ListNode cur = pre.next;

		// 头插法
		for (int i = 0; i < right - left; i++) {
			ListNode node = cur.next;
			cur.next = node.next;
			node.next = pre.next;
			pre.next = node;
		}

		return dummy.next;
	}
}
