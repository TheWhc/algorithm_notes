package 双指针法;

/**
 * @ClassName: 待分类._206_反转链表
 * @Author: whc
 * @Date: 2021/04/25/11:24
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
		ListNode dummyNode = null;
		ListNode cur = head;
		ListNode pre = null;
		while(cur != null) {
			ListNode tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		return pre;
	}

}
