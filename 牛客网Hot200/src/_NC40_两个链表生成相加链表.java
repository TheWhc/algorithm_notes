import java.util.Stack;

/**
 * @ClassName: _NC40_两个链表生成相加链表
 * @Author: whc
 * @Date: 2021/02/23/10:37
 */
public class _NC40_两个链表生成相加链表 {
	public ListNode addInList (ListNode head1, ListNode head2) {
		// write code here
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		while(head1 != null) {
			stack1.push(head1.val);
		}

		while(head2 != null) {
			stack2.push(head2.val);
		}

		ListNode ret = new ListNode(-1);
		int carry = 0;
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			int a = 0, b = 0;
			if(!stack1.isEmpty()) {
				a = stack1.pop();
			}
			if(!stack2.isEmpty()) {
				b = stack2.pop();
			}
			int sum = carry + a + b;
			int ans = sum % 10;
			carry = sum / 10;
			// 创建新节点
			ListNode cur = new ListNode(ans);
			cur.next = ret.next;
			ret.next = cur;
		}

		return ret.next;
	}
}
