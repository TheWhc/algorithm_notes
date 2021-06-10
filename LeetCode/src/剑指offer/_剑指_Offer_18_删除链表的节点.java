package 剑指offer;

/**
 * @ClassName: 剑指offer._剑指_Offer_18_删除链表的节点
 * @Author: whc
 * @Date: 2021/04/02/11:54
 */
public class _剑指_Offer_18_删除链表的节点 {

	/*public ListNode deleteNode(ListNode head, int val) {
		if(head == null)
			return null;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode cur = dummy;
		while(cur.val != val) {
			pre = cur;
			cur = cur.next;
		}
		pre.next = cur.next;
		return dummy.next;
	}*/

	/**
	 *  思路: 设置一个哑节点
	 *  1. 设置一个哑节点dummy,新链表的头结点为dummy.next
	 *  2. 初始化两个节点pre = dummy, cur = head;
	 *  3. cur!=val时,一直移动两个指针,pre=cur, cur=cur.next
	 *  4. cur==val时,pre.next = cur.next;
	 *  5. 返回新链表头节点
	 *
	 *  时间:O(n)
	 *  空间:O(1)
	 */
	public ListNode deleteNode(ListNode head, int val) {
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode pre = dummy;
		ListNode cur = head;
		while(cur.val != val) {
			pre = cur;
			cur = cur.next;
		}
		return dummy.next;
	}

}
