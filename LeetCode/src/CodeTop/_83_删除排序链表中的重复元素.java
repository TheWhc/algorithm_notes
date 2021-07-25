package CodeTop;

/**
 * @ClassName: _83_删除排序链表中的重复元素
 * @Author: whc
 * @Date: 2021/07/25/17:27
 */
public class _83_删除排序链表中的重复元素 {

	/*public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}

		ListNode nextNode = deleteDuplicates(head.next);
		if(head.val == nextNode.val) {
			return nextNode;
		} else {
			head.next = nextNode;
			return head;
		}
	}*/

	public ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode cur = dummy.next;

		while(cur != null && cur.next != null) {
			if(cur.next.val == cur.val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}

		return dummy.next;
	}
}
