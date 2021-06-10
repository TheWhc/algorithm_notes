package 待分类;

/**
 * @ClassName: 待分类._21_合并两个有序链表
 * @Author: whc
 * @Date: 2021/03/04/12:16
 */
public class _21_合并两个有序链表 {
	/*public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		ListNode res = new ListNode(-1);
		ListNode p = res;
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				p.next = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				p.next = new ListNode(l2.val);
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
		return res.next;
	}*/

	// 递归
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		if(l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
}
