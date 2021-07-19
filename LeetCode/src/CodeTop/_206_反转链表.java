package CodeTop;

/**
 * @ClassName: _206_反转链表
 * @Author: whc
 * @Date: 2021/07/19/9:42
 */
public class _206_反转链表 {

	// 递归法
	/*public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}

		ListNode nextNode = reverseList(head.next);
		head.next.next = head;
		head.next = null;

		return nextNode;
	}*/

	// 迭代法
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

class ListNode {
	int val;
	ListNode next;

	public ListNode() {

	}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

}