package 双指针法;

/**
 * @ClassName: _142_环形链表_II
 * @Author: whc
 * @Date: 2021/04/25/12:07
 */
public class _142_环形链表_II {

	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(-4);
		head.next.next.next.next = head.next;
		detectCycle(head);
	}

	public static ListNode detectCycle(ListNode head) {
		if(head == null || head.next == null) return null;
		ListNode fast = head;
		ListNode slow = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) {
				fast = head;
				while(fast != slow) {
					fast = fast.next;
					slow = slow.next;
				}
				return fast;
			}
		}
		return null;
	}

}
