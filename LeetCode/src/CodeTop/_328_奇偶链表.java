package CodeTop;

/**
 * @ClassName: _328_奇偶链表
 * @Author: whc
 * @Date: 2021/08/01/13:32
 */
public class _328_奇偶链表 {

	public ListNode oddEvenList(ListNode head) {
		ListNode oddP = head; // 奇数编号指针
		ListNode evenP = head.next; // 偶数编号指针
		ListNode evevSta = head.next;
		while(oddP.next != null && evenP.next != null) {
			oddP.next = oddP.next.next;
			evenP.next = evenP.next.next;
			oddP = oddP.next;
			evenP = evenP.next;
		}


		oddP.next = evevSta;

		return head;
	}
}
