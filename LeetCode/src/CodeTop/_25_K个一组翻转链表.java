package CodeTop;

import java.util.Stack;

/**
 * @ClassName: _25_K个一组翻转链表
 * @Author: whc
 * @Date: 2021/07/20/10:32
 */
public class _25_K个一组翻转链表 {

	// 递归法
	/*public ListNode reverseKGroup(ListNode head, int k) {
		ListNode cur = head;
		int count = 0;
		while(cur != null && count != k) {
			cur = cur.next;
			count++;
		}

		if(count == k) {
			cur = reverseKGroup(cur, k);
			while(count != 0) {
				ListNode tmp = head.next;
				head.next = cur;
				cur = head;
				head = tmp;
				count--;
			}
		}

		return head;
	}*/

	/**
	 * 尾插法
	 */
	/*public ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy, tail = dummy;

		while(true) {
			int count = 0;
			while(tail != null && count != k) {
				tail = tail.next;
				count++;
			}

			if(tail == null) {
				break;
			}

			ListNode head1 = pre.next;
			while(pre.next != tail) {
				ListNode cur = pre.next;
				pre.next = cur.next;
				cur.next = tail.next;
				tail.next = cur;
			}

			pre = head1;
			tail = head1;
		}

		return dummy.next;
	}*/


	// 栈
	public ListNode reverseKGroup(ListNode head, int k) {
		Stack<ListNode> stack = new Stack<>();
		ListNode dummy = new ListNode(0);
		// 翻转后的新链表
		ListNode cur = dummy;

		while(true) {
			int count = 0;
			ListNode tmp = head;

			while(tmp != null && count < k) {
				stack.push(tmp);
				tmp = tmp.next;
				count++;
			}

			if(count != k) {
				cur.next = head;
				break;
			}

			while(!stack.isEmpty()) {
				cur.next = stack.pop();
				cur = cur.next;
			}

			cur.next = tmp;
			head = tmp;
		}

		return dummy.next;
	}

}
