package CodeTop;

/**
 * @ClassName: _876_链表的中间结点
 * @Author: whc
 * @Date: 2021/09/13/12:52
 */
public class _876_链表的中间结点 {

	public ListNode middleNode(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}

		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}
}
