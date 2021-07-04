package 链表.交换节点;

import 链表.ListNode;

/**
 * @ClassName: _24_两两交换链表中的节点
 * @Author: whc
 * @Date: 2021/07/04/11:46
 */
public class _24_两两交换链表中的节点 {

	/**
	 * 思路: 递归法
	 */
	/*public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}

		// 例子1->2->3->4
		// nextNode: 4->3
		ListNode nextNode = swapPairs(head.next.next);
		// 2
		ListNode newHead = head.next;
		// 2->1
		newHead.next = head;
		// 2->1->4->3
		head.next = nextNode;

		return newHead;
	}*/


	/**
	 * 思路: 迭代法
	 *
	 * 虚拟头结点
	 */
	public ListNode swapPairs(ListNode head) {
		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;
		ListNode cur = dummyNode;

		while(cur.next != null && cur.next.next != null) {
			ListNode temp1 = cur.next;
			ListNode temp2 = cur.next.next.next;
			// 步骤一
			cur.next = cur.next.next;
			// 步骤二
			cur.next.next = temp1;
			// 步骤三
			cur.next.next.next = temp2;

			cur = cur.next.next;
		}

		return dummyNode.next;
	}
}
