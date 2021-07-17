package 排序.归并排序;

/**
 * @ClassName: _21_合并两个有序链表
 * @Author: whc
 * @Date: 2021/07/17/17:36
 */
public class _21_合并两个有序链表 {

	/**
	 * 思路: 构建一个虚拟节点
	 * 1. 遍历l1,l2,比较两条链表节点值,将当前节点值小的节点插入到新链表中
	 * 2. 遍历结束后,如果其中一条链表不为空,则将新链表的下一个节点指向不为空的剩余链表
	 * 3. 最后返回虚拟头节点的下一个节点
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode res = new ListNode(-1);
		ListNode cur = res;
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}

		if(l1 != null) {
			cur.next = l1;
		}
		if(l2 != null) {
			cur.next = l2;
		}

		return res.next;
	}

	/**
	 * 思路: 递归法
	 * 1. 递归终止条件,链表为空时,直接返回
	 * 2. 单层递归逻辑,比较两条链表的头节点值,小的值构建为新的链表合并后返回
	 */
	/*public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null) {
			return l2;
		}
		if(l2 == null) {
			return l1;
		}

		if(l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}*/
}

class ListNode {
	int val;
	ListNode next;
	ListNode() {

	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

}