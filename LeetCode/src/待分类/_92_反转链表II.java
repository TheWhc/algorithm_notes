package 待分类;

/**
 * @ClassName: 待分类._92_反转链表II
 * @Author: whc
 * @Date: 2021/03/06/9:04
 */
public class _92_反转链表II {
	public ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;

		// g代表翻转节点的前面
		ListNode g = dummyHead;
		// p代表要翻转的节点
		ListNode p = dummyHead.next;

		int step = 0;
		while(step < left - 1) {
			g = g.next;
			p = p.next;
			step++;
		}

		// 头插法
		for (int i = 0; i < right-left; i++) {
			ListNode removedNode = p.next;
			p.next = p.next.next;
			removedNode.next = g.next;
			g.next = removedNode;
		}

		return dummyHead.next;
	}
}
