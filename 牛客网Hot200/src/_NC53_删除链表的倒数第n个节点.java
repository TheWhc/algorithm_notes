/**
 * @ClassName: _NC53_删除链表的倒数第n个节点
 * @Author: whc
 * @Date: 2021/02/22/10:49
 */
public class _NC53_删除链表的倒数第n个节点 {
	/*public ListNode removeNthFromEnd (ListNode head, int n) {
		// write code here
		ListNode p = head;
		ListNode res = head;
		int nodeNums = 0;
		while(p != null) {
			nodeNums++;
			p = p.next;
		}
		int targetIndex = nodeNums - n;
		if(targetIndex == 0) {
			return head.next;
		}
		for (int i = 0; i < targetIndex-1; i++) {
			head = head.next;
		}
		head.next = head.next.next;
		return res;
	}*/

	public ListNode removeNthFromEnd (ListNode head, int n) {
		// write code here
		if(head == null) {
			return null;
		}
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode fast = head, slow = head;
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}

		while(fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}

		slow.next = slow.next.next;

		return head;
	}
}
