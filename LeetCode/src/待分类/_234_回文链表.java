package 待分类;

/**
 * @ClassName: 待分类._234_回文链表
 * @Author: whc
 * @Date: 2021/03/20/22:52
 */
public class _234_回文链表 {
	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) return true;
		ListNode fast = head;
		ListNode slow = head;
		ListNode prepare = null;
		ListNode cur = head;
		while(fast != null && fast.next != null) {
			cur = slow;
			fast = fast.next.next;
			slow = slow.next;
			cur.next = prepare;
			prepare = cur;
		}

		if(fast != null) {
			slow = slow.next;
		}

		while(slow != null && cur != null) {
			if(slow.val != cur.val) {
				return false;
			}
			slow = slow.next;
			cur = cur.next;
		}

		return true;
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(2);
		node.next.next.next = new ListNode(1);
		isPalindrome(node);
	}
}
