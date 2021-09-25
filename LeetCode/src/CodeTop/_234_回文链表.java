package CodeTop;

/**
 * @ClassName: _234_回文链表
 * @Author: whc
 * @Date: 2021/07/24/15:33
 */
public class _234_回文链表 {

	/*public boolean isPalindrome(ListNode head) {
		if(head == null) {
			return false;
		}
		// 1. 找到链表中间节点
		ListNode midNode = findMidNode(head);

		ListNode l2 = midNode.next;
		ListNode l1 = head;
		midNode.next = null;

		// 2. 对l2链表进行反转
		l2 = reverseNode(l2);

		while(l2 != null) {
			if(l1.val != l2.val) {
				return false;
			}

			l1 = l1.next;
			l2 = l2.next;
		}

		return true;
	}

	private ListNode reverseNode(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}

		ListNode nextNode = reverseNode(head.next);
		head.next.next = head;
		head.next = null;
		return nextNode;
	}

	private ListNode findMidNode(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}*/


	public boolean isPalindrome(ListNode head) {
		if(head == null) {
			return false;
		}

		// 1. 找到链表的中间节点
		ListNode middleNode = findMiddleNode(head);

		// 2. 翻转链表
		ListNode newListNode = reverseNode(middleNode);

		// 比较两条链表
		while(newListNode != null) {
			if(head.val != newListNode.val) {
				return false;
			}
			head = head.next;
			newListNode = newListNode.next;
		}

		return true;
	}

	// 递归翻转
	/*private ListNode reverseNode(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}

		ListNode nextNode = reverseNode(head.next);
		head.next.next = head;
		head.next = null;
		return nextNode;
	}*/

	// 迭代翻转
	private ListNode reverseNode(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}

		ListNode pre = null;
		ListNode cur = head;
		while(cur != null) {
			ListNode tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}

		return pre;
	}

	// 快慢指针
	private ListNode findMiddleNode(ListNode head) {
		ListNode fast = head, slow = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}
}
