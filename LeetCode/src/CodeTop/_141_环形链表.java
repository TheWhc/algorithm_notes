package CodeTop;

/**
 * @ClassName: _141_环形链表
 * @Author: whc
 * @Date: 2021/07/20/13:36
 */
public class _141_环形链表 {

	public boolean hasCycle(ListNode head) {
		if(head == null || head.next == null) {
			return false;
		}

		ListNode fast = head, slow = head;

		while(true) {
			if(fast == null || fast.next == null) {
				return false;
			}
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) {
				break;
			}
		}

		return true;
	}
}
