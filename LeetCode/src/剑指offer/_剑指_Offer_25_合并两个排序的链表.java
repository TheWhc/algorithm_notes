package 剑指offer;

/**
 * @ClassName: 剑指offer._剑指_Offer_25_合并两个排序的链表
 * @Author: whc
 * @Date: 2021/04/02/0:52
 */
public class _剑指_Offer_25_合并两个排序的链表 {

	/**
	 *  思路: 迭代法
	 *  时间: O(m+n)
	 *  空间: O(m+n)
	 */
	/*public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null && l2 == null) {
			return null;
		}
		if(l1 == null) {
			return l2;
		}
		if(l2 == null) {
			return l1;
		}
		ListNode newList = null;
		if(l1.val < l2.val) {
			newList = new ListNode(l1.val);
			l1 = l1.next;
		} else {
			newList = new ListNode(l2.val);
			l2 = l2.next;
		}
		ListNode cur = newList;
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				cur.next = new ListNode(l1.val);
				l1 = l1.next;
				cur = cur.next;
			} else {
				cur.next = new ListNode(l2.val);
				l2 = l2.next;
				cur = cur.next;
			}
		}
		if(l1 != null) {
			cur.next = l1;
		}
		if(l2 != null) {
			cur.next = l2;
		}
		return newList;
	}*/


	/**
	 *  思路: 迭代
	 *  1. 设置dummy哑节点,放置新链表之前,cur为当前节点,从dummy开始
	 *  2. 当两个链表为非空时进入循环,令新链表的下一个节点cur.next为val更小的节点,相应的链表节点后移一位
	 *  3. 每次循环cur也要后移一位
	 *  4. 循环结束后还有链表非空,cur指向非空链表
	 *  5. 返回dummy.next
	 *
	 *  时间:O(n+m)
	 *  空间:O(1)
	 */
	/*public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null && l2 == null) {
			return null;
		}
		if(l1 == null) {
			return l2;
		}
		if(l2 == null) {
			return l1;
		}

		ListNode dummy = new ListNode();
		ListNode cur = dummy;
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
		cur.next = l1 == null ? l2 : l1;
		return dummy.next;
	}*/

	/**
	 *  思路: 递归法
	 *  1. 递归终止条件: 有一个链表为空,则返回另一个链表
	 *  2. 比较两个链表头节点值,进行链表合并
	 *  时间: O(m+n)
	 *  空间: O(m+n)
	 */
	/*public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}
		if(l1.val <= l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
*/

	public static void main(String args[]) {
		double a = 11.26;
		String result = String.format("%.1f", a);
		System.out.println(result);
		System.out.println(result.substring(0, result.indexOf('.') + 2));

	}
}
