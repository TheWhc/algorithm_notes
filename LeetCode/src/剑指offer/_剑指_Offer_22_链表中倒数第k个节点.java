package 剑指offer;



/**
 * @ClassName: 剑指offer._剑指_Offer_22_链表中倒数第k个节点
 * @Author: whc
 * @Date: 2021/04/01/23:33
 */
public class _剑指_Offer_22_链表中倒数第k个节点 {

	// 2021/4/1 二刷
	// 快慢指针
	/*public ListNode getKthFromEnd(ListNode head, int k) {
		ListNode fast = head;
		ListNode slow = head;
		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}

		while(fast != null) {
			fast = fast.next;
			slow = slow.next;
		}

		return slow;
	}*/

	/**
	 *  思路: 快慢指针
	 *  1. 让fast指针先走k步
	 *  2. 然后while循环中fast和slow均一次走一步,直到fast为空
	 *  3. 此时slow指向倒数第k个位置元素
	 *
	 *  时间: O(n)
	 *  空间: O(1)
	 */
	public ListNode getKthFromEnd(ListNode head, int k) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode fast = head;
		ListNode slow = head;
		for(int i = 0; i < k; i++) {
			fast = fast.next;
		}
		while(fast != null) {
			fast = fast.next;
			slow = slow.next;
		}

		return slow;
	}
}
