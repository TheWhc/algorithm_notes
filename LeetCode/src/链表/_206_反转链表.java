package 链表;

/**
 * @ClassName: _206_反转链表
 * @Author: whc
 * @Date: 2021/07/04/11:35
 */
public class _206_反转链表 {

	// 递归法
	/*public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode nextNode = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return nextNode;
	}*/

	// 双指针法
	public ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode cur = head;
		while(cur != null) {
			ListNode temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}
		return pre;
	}
}
