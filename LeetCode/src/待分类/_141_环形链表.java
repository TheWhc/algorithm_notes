package 待分类;

/**
 * @ClassName: 待分类._141_环形链表
 * @Author: whc
 * @Date: 2021/03/06/10:19
 */
public class _141_环形链表 {
	public static boolean hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while(true) {
			if(fast == null || fast.next == null) {
				return false;
			}
			fast = fast.next.next;
			slow = slow.next;

			if(fast == slow) {
				return true;
			}
		}
	}
}
