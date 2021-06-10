package 待分类;

/**
 * @ClassName: 待分类._24_两两交换链表中的节点
 * @Author: whc
 * @Date: 2021/03/28/23:15
 */
public class _24_两两交换链表中的节点 {

	/*public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null)
			return head;

		ListNode next = head.next;
		ListNode pairNext = swapPairs(next.next);
		next.next = head;
		head.next = pairNext;
		return next;
	}*/

	public ListNode swapPairs(ListNode head) {
		ListNode dummyHead = new ListNode(0); // 设置虚拟节点
		dummyHead.next = head;
		ListNode cur = dummyHead;
		while(cur.next != null && cur.next.next != null) {
			ListNode tmp = cur.next;
			ListNode tmp2 = cur.next.next.next;
			cur.next = cur.next.next;
			cur.next.next = tmp;
			tmp.next = tmp2;
			cur = cur.next.next;
		}
		return dummyHead.next;
	}
}
