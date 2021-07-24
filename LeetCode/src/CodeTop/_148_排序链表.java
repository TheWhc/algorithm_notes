package CodeTop;

/**
 * @ClassName: _148_排序链表
 * @Author: whc
 * @Date: 2021/07/24/22:26
 */
public class _148_排序链表 {

	// 归并排序
	public ListNode sortList(ListNode head) {
		return mergeSort(head);
	}

	private ListNode mergeSort(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		// 找到中间节点
		ListNode midNode = findMidNode(head);
		ListNode nextNode = midNode.next;
		midNode.next = null;
		// 对l1链表进行递归排序
		ListNode l1 = sortList(head);
		// 对l2链表进行递归排序
		ListNode l2 = sortList(nextNode);
		// 将两条有序链表进行合并
		return merge(l1, l2);
	}

	/*private ListNode merge(ListNode l1, ListNode l2) {
		if(l1 == null) {
			return l2;
		}
		if(l2 == null) {
			return l1;
		}

		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}

		if(l1 != null) {
			p.next = l1;
		}
		if(l2 != null) {
			p.next = l2;
		}

		return dummy.next;
	}*/

	// 递归法, 合并两条有序链表
	private ListNode merge(ListNode l1, ListNode l2) {
		if(l1 == null) {
			return l2;
		}
		if(l2 == null) {
			return l1;
		}

		if(l1.val < l2.val) {
			l1.next = merge(l1.next, l2);
			return l1;
		} else {
			l2.next = merge(l1, l2.next);
			return l2;
		}
	}

	private ListNode findMidNode(ListNode head) {
		ListNode fast = head, slow = head;
		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}
}
