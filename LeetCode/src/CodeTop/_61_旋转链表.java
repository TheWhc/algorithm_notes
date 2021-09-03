package CodeTop;

/**
 * @ClassName: _61_旋转链表
 * @Author: whc
 * @Date: 2021/08/19/8:58
 */
public class _61_旋转链表 {

	public ListNode rotateRight(ListNode head, int k) {
		if(head == null || k == 0) {
			return head;
		}

		// 1. 链表长度
		int len = 0;
		ListNode cur = head;
		while(cur != null) {
			len++;
			cur = cur.next;
		}

		// 2. 找到倒数第k+1个节点
		k = k % len;
		if(k == 0) {
			return head;
		}

		ListNode fast = head;
		ListNode slow = head;

		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}

		// 此时slow指向倒数第k+1个节点
		while(fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}


		// 3. 链表重整
		ListNode newHead = slow.next;
		// 断开
		slow.next = null;
		// 让最后一个节点指向原始链表的头
		fast.next = head;

		return newHead;
	}
}
