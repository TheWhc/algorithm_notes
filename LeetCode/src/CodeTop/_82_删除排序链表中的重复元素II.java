package CodeTop;

/**
 * @ClassName: _82_删除排序链表中的重复元素II
 * @Author: whc
 * @Date: 2021/07/25/17:33
 */
public class _82_删除排序链表中的重复元素II {

	/*public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}

		ListNode nextNode = head.next;
		if(head.val == nextNode.val) {
			while(nextNode != null && head.val == nextNode.val) {
				nextNode = nextNode.next;
			}
			return deleteDuplicates(nextNode);
		} else {
			head.next = deleteDuplicates(nextNode);
			return head;
		}
	}*/

	// 迭代法
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}

		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode pre = dummy;
		ListNode cur = dummy.next;
		while(cur != null) {
			if(cur.next != null && cur.val == cur.next.val) {
				while(cur.next != null && cur.val == cur.next.val) {
					cur.next = cur.next.next;
				}
				pre.next = cur.next;
				cur = pre.next;
			} else {
				pre = cur;
				cur = cur.next;
			}
		}

		return dummy.next;
	}
}
