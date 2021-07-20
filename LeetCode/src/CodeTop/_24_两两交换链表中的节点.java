package CodeTop;

/**
 * @ClassName: _24_两两交换链表中的节点
 * @Author: whc
 * @Date: 2021/07/20/10:14
 */
public class _24_两两交换链表中的节点 {

	// 递归法
	/*public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}

		ListNode nextNode = swapPairs(head.next.next);
		ListNode newHead = head.next;
		newHead.next = head;
		head.next = nextNode;
		return newHead;
	}*/

	// 迭代法
	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}

		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;
		ListNode cur = dummyHead;

		while(cur.next != null && cur.next.next != null) {
			ListNode temp1 = cur.next;
			ListNode temp2 = cur.next.next.next;

			cur.next = temp1.next;
			cur.next.next = temp1;
			cur.next.next.next = temp2;
			cur = cur.next.next;
		}

		return dummyHead.next;
	}
}
