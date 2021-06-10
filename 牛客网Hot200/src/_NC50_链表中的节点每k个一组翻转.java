import java.util.Stack;

/**
 * @ClassName: _NC50_链表中的节点每k个一组翻转
 * @Author: whc
 * @Date: 2021/02/23/8:42
 */
public class _NC50_链表中的节点每k个一组翻转 {
	public ListNode reverseKGroup (ListNode head, int k) {
		// write code here
		//定义一个栈
		ListNode ret = new ListNode(0);
		ListNode p = ret;
		Stack<ListNode> stack = new Stack<>();
		ListNode tmp = head;
		while(true) {
			int count = 0;
			while(tmp != null && count < k) {
				stack.push(tmp);
				tmp = tmp.next;
				count++;
			}

			if(count != k) {
				p.next = head;
				break;
			}

			while(!stack.isEmpty()) {
				p.next = stack.pop();
				p = p.next;
			}

			p.next = tmp;
			head = tmp;

		}
		return ret.next;
	}
}
