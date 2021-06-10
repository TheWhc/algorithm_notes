package 待分类;

import java.util.Stack;

/**
 * @ClassName: 待分类._25_K个一组翻转链表
 * @Author: whc
 * @Date: 2021/03/01/10:46
 */
public class _25_K个一组翻转链表 {
	public ListNode reverseKGroup(ListNode head, int k) {
		Stack<ListNode> stack = new Stack<>();
		ListNode p = head;
		ListNode cur = new ListNode(0);
		ListNode res = cur;
		while(true) {
			int count = 0;
			while(p != null && count < k) {
				stack.push(p);
				p = p.next;
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
			cur.next = p;
			head = p;
		}

		return res.next;
	}
}
