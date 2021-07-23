package CodeTop;

/**
 * @ClassName: _143_重排链表
 * @Author: whc
 * @Date: 2021/07/23/17:49
 */
public class _143_重排链表 {

	/**
	 * 例子: 1->2->3->4->5
	 * 中间节点为3
	 * 对于后半部分节点先进行反转得到 5->4
	 * 然后将前半部分和后半部分链表节点进行合并,即
	 * 1->2->3
	 * 5->4
	 * 合并得到
	 * 1->5->2->4->3
	 */
	public void reorderList(ListNode head) {
		if(head == null) {
			return;
		}

		ListNode midNode = findMid(head);

		// 对后半部分节点进行反转
		ListNode l2 = midNode.next;
		midNode.next = null;
//		l2 = reverseNode(l2); // 递归反转
		l2 = reverseNode(l2); // 迭代反转

		ListNode l1 = head;

		// 将链表进行合并
		 mergeList(l1, l2);

	}

	private void mergeList(ListNode l1, ListNode l2) {
		ListNode p = l1;
		ListNode q = l2;
		while(p != null && q != null) {
			ListNode pNext = p.next;
			ListNode qNext = q.next;
			p.next = q;
			q.next = pNext;
			p = pNext;
			q = qNext;
		}
	}

	// 递归反转
/*	private ListNode reverseNode(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}

		ListNode nextNode = reverseNode(head.next);
		head.next.next = head;
		head.next = null;

		return nextNode;
	}*/

	// 迭代反转
	private ListNode reverseNode(ListNode head) {
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

	// 获取链表中间节点
	private ListNode findMid(ListNode head) {
		ListNode fast = head, slow = head;

		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}

}
