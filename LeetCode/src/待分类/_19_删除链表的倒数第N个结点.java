package 待分类;

/**
 * @ClassName: 待分类._19_删除链表的倒数第N个结点
 * @Author: whc
 * @Date: 2021/03/25/11:42
 */
public class _19_删除链表的倒数第N个结点 {
	/*public static ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null || head.next == null) {
			return null;
		}

		int nums = 0;
		ListNode p = head;
		while(p != null) {
			nums++;
			p = p.next;
		}

		ListNode p2 = head;
		int removeIndex = nums - n - 1;
		if(removeIndex == -1) {
			return head.next;
		}
		for (int i = 0; i < removeIndex; i++) {
			p2 = p2.next;
		}

		p2.next = p2.next.next;
		return head;
	}*/


	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;
		ListNode fast = dummyHead;
		ListNode slow = dummyHead;
		for (int i = 0; i < n+1; i++) {
			fast = fast.next;
		}
		while(fast != null) {
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;
		return dummyHead.next;
	}
}
