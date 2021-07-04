package 双指针法;

/**
 * @ClassName: 待分类._142_环形链表II
 * @Author: whc
 * @Date: 2021/04/15/15:41
 */
public class _142_环形链表II {

	// 快慢指针
	public ListNode detectCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		// 第一次相遇时, slow指针步数=nb
		// fast = 2slow ,  总fast = 总slow + nb, 得 slow = nb
		while(true) {
			if(fast == null || fast.next == null) {
				return null;
			}
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) {
				break;
			}
		}

		// 第二次相遇时, 让fast重新指向起始位置, 然后fast和slow需要同时走a步就能相遇, 即环形的入口点
		fast = head;
		while(fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}

		return slow;
	}
}
