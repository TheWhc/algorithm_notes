package 剑指offer;

/**
 * @ClassName: _剑指_Offer_35_复杂链表的复制
 * @Author: whc
 * @Date: 2021/05/29/14:03
 */

class Node1 {
	int val;
	Node1 next;
	Node1 random;

	public Node1(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}

public class _剑指_Offer_35_复杂链表的复制 {

	/**
	 *  思路: 通过遍历当前链表,逐个复制当前遍历得到的节点
	 *  1. 遍历当前链表,并依据得到的节点值,新建节点clone并添加到链表中
	 *  2. 再次遍历链表,当指针cur指向的random不空为时,则为下一个节点(cur.next)的random指针赋予对应random指向对象的克隆
	 *  	cur.next.random = cur.random.next
	 *  	(cur = cur.next.next)
	 * 3. 拆分链表,用res存储新链表的头节点,再创建指针pre/cur,通过修改pre与cur的next指向拆分链表,注意最后pre.next要指向空
	 *
	 */
	public Node1 copyRandomList(Node1 head) {
		if(head == null) {
			return null;
		}
		Node1 cur = head;
		// 拷贝完全相同的节点添加到链表中
		while(cur != null) {
			Node1 clone = new Node1(cur.val);
			clone.next = cur.next;
			cur.next = clone;
			cur = clone.next;
		}

		cur = head;
		// 设置新节点的random值
		while(cur != null) {
			if(cur.random != null) {
				cur.next.random = cur.random.next;
			}
			cur = cur.next.next;
		}

		// 拆分链表
		Node1 pre = head;
		cur = head.next;
		Node1 res = head.next;
		while(cur.next != null) {
			pre.next = pre.next.next;
			cur.next = cur.next.next;
			cur = cur.next;
			pre = pre.next;
		}
		pre.next = null;
		return res;
	}
}
