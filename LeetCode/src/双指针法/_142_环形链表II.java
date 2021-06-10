package 双指针法;

/**
 * @ClassName: 待分类._142_环形链表II
 * @Author: whc
 * @Date: 2021/04/15/15:41
 */
public class _142_环形链表II {

	// 快慢指针
	public ListNode detectCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
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

		return slow;
	}
}
