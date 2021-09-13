package CodeTop;

/**
 * @ClassName: _剑指_Offer_35_复杂链表的复制
 * @Author: whc
 * @Date: 2021/09/13/15:48
 */
public class _剑指_Offer_35_复杂链表的复制 {

	public Node1 copyRandomList(Node1 head) {
		// 1. 克隆复制链表节点
		Node1 cur = head;
		while(cur != null) {
			Node1 node1 = new Node1(cur.val);
			node1.next = cur.next;
			cur.next = node1;
			cur = node1.next;
		}

		cur = head;

		// 2. 复制random节点
		while(cur != null) {
			if(cur.random != null) {
				cur.next.random = cur.random.next;
			}
			cur = cur.next.next;
		}

		// 3. 拆分链表
		Node1 res = head.next;
		Node1 pre = head;
		cur = head.next;

		while(cur.next != null) {
			pre.next = cur.next;
			cur.next = pre.next.next;
			pre = pre.next;
			cur = cur.next;
		}

		pre.next = null;
		return res;
	}

}
