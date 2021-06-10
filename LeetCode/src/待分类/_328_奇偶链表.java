package 待分类;

/**
 * @ClassName: 待分类._328_奇偶链表
 * @Author: whc
 * @Date: 2021/03/29/10:06
 */
public class _328_奇偶链表 {

	public static ListNode oddEvenList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode odd = head.next;
		ListNode oddHead = odd;
		ListNode even = head;
		while(odd != null && odd.next != null) {
			even.next = odd.next;
			even = even.next;
			odd.next = even.next;
			odd = odd.next;
		}
		even.next = oddHead;
		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		oddEvenList(head);
	}

}
