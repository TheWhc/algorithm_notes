package 待分类;

/**
 * @ClassName: 待分类._142_环形链表II
 * @Author: whc
 * @Date: 2021/03/04/9:48
 */
public class _142_环形链表II {

	// 2021/3/4 二刷
	public ListNode detectCycle(ListNode head) {
		if(head == null || head.next == null) {
			return null;
		}
		ListNode fast = head;
		ListNode slow = head;

		while (true) {
			if(fast == null || fast.next == null)
				return null;
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
