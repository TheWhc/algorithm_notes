package 链表.删除节点;

import 链表.ListNode;

/**
 * @ClassName: _203_移除链表元素
 * @Author: whc
 * @Date: 2021/07/04/10:22
 */
public class _203_移除链表元素 {

	/**
	 * 思路: 设置头节点,避免单独判断只有头结点的情况
	 *
	 */
	public ListNode removeElements(ListNode head, int val) {
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode cur = head;
		ListNode pre = dummy;
		while(cur != null) {
			if(cur.val == val) {
				pre.next = cur.next;
			} else {
				pre = cur;
			}
			cur = cur.next;
		}

		return dummy.next;
	}

}
