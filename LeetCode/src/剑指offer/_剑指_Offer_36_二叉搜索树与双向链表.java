package 剑指offer;

/**
 * @ClassName: _剑指_Offer_36_二叉搜索树与双向链表
 * @Author: whc
 * @Date: 2021/05/30/9:49
 */
class Node {
	public int val;
	public Node left;
	public Node right;

	public Node() {}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val,Node _left,Node _right) {
		val = _val;
		left = _left;
		right = _right;
	}
}

/**
 * 思路: 中序遍历
 * 1. 设置前一个节点指针pre以及头指针head
 * 2. 递归当前节点cur,按照中序遍历递归,先递归左节点,子节点为空,则返回null
 * 3. 若pre为空,则设置头结点head = cur
 * 4. 若pre不为空,则设置当前节点cur.left = pre, pre.right = cur
 * 5. 每轮递归结束时,移动pre指针,即pre = cur
 * 6. 递归dfs结束后,再设置头尾节点的指针指向
 *
 * 时间: O(n) 中序遍历每个节点
 * 空间: O(n) 最坏情况下,退化成单链表,递归深度为n
 */
public class _剑指_Offer_36_二叉搜索树与双向链表 {

	Node pre;
	Node head;
	public Node treeToDoublyList(Node root) {
		if(root == null) {
			return null;
		}
		dfs(root);
		pre.right = head;
		head.left = pre;
		return head;
	}

	private void dfs(Node cur) {
		if(cur == null) {
			return;
		}
		dfs(cur.left);
		if(pre == null) {
			head = cur;
		} else {
			cur.left = pre;
			pre.right = cur;
		}
		pre = cur;
		dfs(cur.right);
	}
}
