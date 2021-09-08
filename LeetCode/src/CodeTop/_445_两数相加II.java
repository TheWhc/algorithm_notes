package CodeTop;

import java.util.Stack;

/**
 * @ClassName: _445_两数相加II
 * @Author: whc
 * @Date: 2021/09/05/17:01
 */
public class _445_两数相加II {

	/*public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();

		while(l1 != null) {
			stack1.push(l1.val);
			l1 = l1.next;
		}

		while(l2 != null) {
			stack2.push(l2.val);
			l2 = l2.next;
		}

		ListNode head = new ListNode();
		ListNode p = head;

		int carry = 0;
		while(!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
			int sum = 0;
			if(!stack1.isEmpty()) {
				sum += stack1.pop();
			}
			if(!stack2.isEmpty()) {
				sum += stack2.pop();
			}
			sum += carry;
			p.next = new ListNode(sum % 10);
			carry = sum / 10;
			p = p.next;
		}


		head = reverseListNode(head.next);
		return head;
	}

	private ListNode reverseListNode(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}

		ListNode nextNode = reverseListNode(head.next);
		head.next.next = head;
		head.next = null;

		return nextNode;
	}*/


	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();

		while(l1 != null) {
			stack1.push(l1.val);
			l1 = l1.next;
		}

		while(l2 != null) {
			stack2.push(l2.val);
			l2 = l2.next;
		}

		ListNode head = null;

		int carry = 0;
		while(!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
			int sum = 0;
			if(!stack1.isEmpty()) {
				sum += stack1.pop();
			}
			if(!stack2.isEmpty()) {
				sum += stack2.pop();
			}
			sum += carry;
			ListNode node = new ListNode(sum % 10);
			node.next = head;
			head = node;
			carry = sum / 10;
		}

		return head;
	}
}
