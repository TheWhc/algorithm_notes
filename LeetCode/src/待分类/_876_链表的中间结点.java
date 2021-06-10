package 待分类;

/**
 * @ClassName: 待分类._876_链表的中间结点
 * @Author: whc
 * @Date: 2021/03/12/23:02
 */
public class _876_链表的中间结点 {

	public ListNode middleNode(ListNode head) {
		if(head == null)
			return null;
		if(head.next == null) {
			return head;
		}
		// 快慢指针
		ListNode fast = head;
		ListNode slow = head;

		// 1->2->3->4
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}
}
