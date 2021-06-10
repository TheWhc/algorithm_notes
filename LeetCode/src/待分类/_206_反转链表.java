package 待分类;

import java.util.Stack;

/**
 * @ClassName: 待分类._206_反转链表
 * @Author: whc
 * @Date: 2021/03/01/11:19
 */
public class _206_反转链表 {
	/*public static ListNode reverseList(ListNode head) {
		Stack<ListNode> stack = new Stack<>();
		ListNode p = new ListNode(0);
		ListNode res = p;
		while(head != null) {
			stack.push(new ListNode(head.val));
			head = head.next;
		}

		while(!stack.isEmpty()) {
			p.next = stack.pop();
			p = p.next;
		}

		return res.next;
	}*/

	/*public static ListNode reverseList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}

		ListNode listNode = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return listNode;
	}*/

	/**
	 * 思路: 递归
	 * 时间: O(n)
	 * 空间: O(n)
	 */
	 /*public ListNode reverseList(ListNode head) {
	     if(head == null || head.next == null) {
	         return head;
	     }

	     ListNode nextNode = reverseList(head.next);
	     head.next.next = head;
	     head.next = null;
	     return nextNode;
	 }*/

	/**
	 *  思路: 迭代法
	 *  1. 设置三个指针,pre,cur,temp
	 *  2. pre指向null!!, cur指向头结点,temp保存cur的下一个节点
	 *
	 *  时间: O(n)
	 *  空间: O(1)
	 */
	public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
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
