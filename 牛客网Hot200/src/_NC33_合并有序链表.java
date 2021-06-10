/**
 * @ClassName: _NC33_合并有序链表
 * @Author: whc
 * @Date: 2021/02/19/10:22
 */
public class _NC33_合并有序链表 {
	public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
		// write code here
		if(l1 == null) {
			return l2;
		}
		if(l2 == null) {
			return l1;
		}
		ListNode newList;
		ListNode res;
		// 先处理头部
		newList = l1.val < l2.val ? l1 : l2;
		l1 = (newList == l1) ? l1.next : l1;
		l2 = (newList == l2) ? l2.next : l2;
		res = newList;
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				newList.next = l1;
				l1 = l1.next;
			} else {
				newList.next = l2;
				l2 = l2.next;
			}
			newList = newList.next;
		}
		newList.next = (l1 == null) ? l2 : l1;

		return res;
	}

	/*public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
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
*/
}
