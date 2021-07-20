package CodeTop;

/**
 * @ClassName: _142_环形链表II
 * @Author: whc
 * @Date: 2021/07/20/14:55
 */
public class _142_环形链表II {

	public ListNode detectCycle(ListNode head) {
		if(head == null || head.next == null) {
			return null;
		}

		ListNode fast = head, slow = head;

		while(true) {
			if(fast == null || fast.next == null) {
				return null;
			}
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) {
				break;
			}
		}

		fast = head;
		while(fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}

		return fast;
	}
}
