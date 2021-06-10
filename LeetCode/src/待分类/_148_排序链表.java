package 待分类;

/**
 * @ClassName: 待分类._148_排序链表
 * @Author: whc
 * @Date: 2021/03/21/13:58
 */
public class _148_排序链表 {

	/*public ListNode sortList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		ListNode list = sortList(head.next);
		if(head.val <= list.val) {
			head.next = list;
			return head;
		} else {
			ListNode cur = list;
			ListNode preCur = cur;
			while(cur != null && head.val > cur.val) {
				preCur = cur;
				cur = cur.next;
			}
			preCur.next = head;
			head.next = cur;
			return list;
		}
	}*/

	// 归并排序
	// 链表做归并排序可以修改引用来更改节点的位置,不需要开辟O(n)空间,但是递归需要消耗O(logn)空间复杂度
	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		// 1. 快慢指针找链表中点
		ListNode fast = head.next;
		ListNode slow = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		// 链表第二部分头节点
		ListNode rightHead = slow.next;
		slow.next = null;

		// 2. 对链表进行递归排序
		ListNode left = sortList(head);
		ListNode right = sortList(rightHead);

		// 3. 对链表进行归并
		return merge(left, right);
	}

	private ListNode merge(ListNode left, ListNode right) {
		ListNode dummy = new ListNode(-1);
		ListNode p = dummy;
		while(left != null && right != null) {
			if(left.val < right.val) {
				p.next = left;
				left = left.next;
			} else {
				p.next = right;
				right = right.next;
			}
			p = p.next;
		}
		if(left != null) {
			p.next = left;
		}
		if(right != null) {
			p.next = right;
		}

		return dummy.next;
	}


	// 迭代法
}
