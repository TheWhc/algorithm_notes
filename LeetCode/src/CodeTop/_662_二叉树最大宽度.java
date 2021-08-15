package CodeTop;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: _662_二叉树最大宽度
 * @Author: whc
 * @Date: 2021/08/15/9:34
 */
public class _662_二叉树最大宽度 {

	class Node {
		TreeNode node;
		int index;
		Node(TreeNode node, int index) {
			this.node = node;
			this.index = index;
		}
	}

	public int widthOfBinaryTree(TreeNode root) {
		if(root == null) {
			return 0;
		}

		int maxWidth = 1;
		Node head = new Node(root, 1);
		LinkedList<Node> queue = new LinkedList<>();
		queue.offer(head);

		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			int l = queue.peekFirst().index;
			int r = queue.peekLast().index;
			maxWidth = Math.max(maxWidth, r - l + 1);
			while(levelSize > 0) {
				Node cur = queue.poll();
				// 添加左节点编号
				if(cur.node.left != null) {
					queue.offer(new Node(cur.node.left, 2 * cur.index));
				}
				if(cur.node.right != null) {
					queue.offer(new Node(cur.node.right, 2 * cur.index + 1));
				}
				levelSize--;
			}
		}

		return maxWidth;
	}
}
