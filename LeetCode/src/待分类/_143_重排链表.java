package 待分类;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: 待分类._143_重排链表
 * @Author: whc
 * @Date: 2021/03/23/10:26
 */
public class _143_重排链表 {


	/*public void reorderList(ListNode head) {
		if(head == null || head.next == null) {
			return;
		}
		ListNode fast = head;
		ListNode slow = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode newHead = slow.next;
		slow.next = null;
		// 第二个链表反转
		newHead = reverseList(newHead);

		while(newHead != null) {
			ListNode temp = newHead.next;
			newHead.next = head.next;
			head.next = newHead;
			head = newHead.next;
			newHead = temp;
		}
	}

	private ListNode reverseList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode prev = null;
		ListNode cur = head;
		while(cur != null) {
			ListNode tmp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = tmp;
		}
		return prev;
	}*/

	public void reorderList(ListNode head) {
		if(head == null)
			return;
		List<ListNode> list = new ArrayList<>();
		while(head != null) {
			list.add(head);
			head = head.next;
		}

		int i = 0, j = list.size()-1;
		while(i < j) {
			list.get(i).next = list.get(j);
			i++;
			if(i == j) {
				break;
			}
			list.get(j).next = list.get(i);
			j--;
		}
	}
}
