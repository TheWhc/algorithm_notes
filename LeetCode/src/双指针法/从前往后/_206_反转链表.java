package 双指针法.从前往后;

/**
 * @ClassName: _206_反转链表
 * @Author: whc
 * @Date: 2021/07/04/11:43
 */
public class _206_反转链表 {

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
