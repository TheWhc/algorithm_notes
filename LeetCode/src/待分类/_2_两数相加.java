package 待分类;

/**
 * @ClassName: 待分类._2_两数相加
 * @Author: whc
 * @UpdateUser: whc
 * @Version: 0.0.1
 * @Date: 2021/01/02/23:36
 */
public class _2_两数相加 {
	/*public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode pre = new ListNode(0);
		ListNode cur = pre;
		int carry = 0;
		while(l1 != null || l2 != null) {
			int x1 = l1 == null ? 0 : l1.val;
			int x2 = l2 == null ? 0 : l2.val;
			int sum = x1 + x2 + carry;
			carry = sum / 10;
			sum = sum % 10;
			cur.next = new ListNode(sum);
			cur = cur.next;
			l1 = (l1 == null) ? null : l1.next;
			l2 = (l2 == null) ? null : l2.next;
		}
		if(carry == 1) {
			cur.next = new ListNode(carry);
		}
		return pre.next;
	}*/

	// 2021/3/17 二刷
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode res = new ListNode(0);
		ListNode cur = res;
		int carry = 0;
		while(l1 != null || l2 != null || carry != 0) {
			int x1 = (l1 == null) ? 0 : l1.val;
			int x2 = (l2 == null) ? 0 : l2.val;
			int sum = x1 + x2 + carry;
			carry = sum / 10;
			cur.next = new ListNode(sum % 10);
			cur = cur.next;
			l1 = (l1 == null) ? null : l1.next;
			l2 = (l2 == null) ? null : l2.next;
		}
		return res.next;
	}


	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		new _2_两数相加().addTwoNumbers(l1,l2);
	}
}
