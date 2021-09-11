package CodeTop;

/**
 * @ClassName: _86_分隔链表
 * @Author: whc
 * @Date: 2021/09/11/1:11
 */
public class _86_分隔链表 {

	public ListNode partition(ListNode head, int x) {
		ListNode dummyS = new ListNode(0);
		ListNode small = dummyS;
		ListNode dummyL = new ListNode(0);
		ListNode large = dummyL;

		while(head != null) {
			if(head.val < x) {
				small.next = head;
				small = small.next;
			} else {
				large.next = head;
				large = large.next;
			}
			head = head.next;
		}

		large.next = null;
		small.next = dummyL.next;

		return dummyS.next;
	}

}
