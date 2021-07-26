package CodeTop;

/**
 * @ClassName: _剑指_Offer_36_二叉搜索树与双向链表
 * @Author: whc
 * @Date: 2021/07/26/0:58
 */
public class _剑指_Offer_36_二叉搜索树与双向链表 {

	// 中序遍历
	// 设置pre,head两个节点指针
	// cur指向遍历到的元素
	Node pre = null;
	Node head = null;
	public Node treeToDoublyList(Node root) {
		if(root == null) {
			return null;
		}
		dfs(root);
		// 记得这里要首尾相连
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
			pre = cur;
		} else {
			cur.left= pre;
			pre.right = cur;
			pre = cur;
		}

		dfs(cur.right);
	}
}

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