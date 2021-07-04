package 链表;

/**
 * @ClassName: ListNode
 * @Author: whc
 * @Date: 2021/07/04/10:26
 */
public class ListNode {

	public int val;
	public ListNode next;

	public ListNode() {

	}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

}
