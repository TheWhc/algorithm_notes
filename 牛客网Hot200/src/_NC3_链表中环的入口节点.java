/**
 * @ClassName: _NC3_链表中环的入口节点
 * @Author: whc
 * @Date: 2021/02/23/10:34
 */
public class _NC3_链表中环的入口节点 {
	public ListNode detectCycle(ListNode head) {
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
