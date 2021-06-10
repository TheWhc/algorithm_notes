package 待分类;

/**
 * @ClassName: 待分类._160_相交链表
 * @Author: whc
 * @Date: 2021/03/04/10:10
 */
public class _160_相交链表 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode nodeA = headA, nodeB = headB;
		while(nodeA != nodeB) {
			nodeA = (nodeA == null) ? headB : nodeA.next;
			nodeB = (nodeB == null) ? headA : nodeB.next;
		}
		return nodeA;
	}
}
