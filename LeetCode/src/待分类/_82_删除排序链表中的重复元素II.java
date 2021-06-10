package 待分类;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: 待分类._82_删除排序链表中的重复元素II
 * @Author: whc
 * @Date: 2021/03/28/22:34
 */
public class _82_删除排序链表中的重复元素II {

	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode next = head.next;

		if(head.val == next.val) {
			while (next.val == head.val) {
				next = next.next;
			}
			return deleteDuplicates(next);
		} else {
			next = deleteDuplicates(next);
			head.next = next;
			return head;
		}
	}

}
