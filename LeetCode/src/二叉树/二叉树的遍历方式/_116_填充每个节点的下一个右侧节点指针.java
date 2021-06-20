package 二叉树.二叉树的遍历方式;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: _116_填充每个节点的下一个右侧节点指针
 * @Author: whc
 * @Date: 2021/06/20/15:06
 */

class Node1 {
	public int val;
	public Node1 left;
	public Node1 right;
	public Node1 next;

	public Node1() {}

	public Node1(int _val) {
		val = _val;
	}

	public Node1(int _val, Node1 _left, Node1 _right, Node1 _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
}
public class _116_填充每个节点的下一个右侧节点指针 {

	/**
	 *  思路: 层序遍历(队列,广度优先搜索)
	 *
	 *  1. 按照层序遍历的思路
	 *  2. 设置一个pre指针,指向前一个节点
	 *  3. 当出栈当前节点的时候,pre指针指向当前节点,然后让当前节点成为pre
	 */
	public Node1 connect(Node1 root) {
		if(root == null) {
			return null;
		}

		LinkedList<Node1> queue = new LinkedList<>();
		queue.offer(root);

		while(!queue.isEmpty()) {
			int count = queue.size();
			Node1 pre = new Node1();
			while(count > 0) {
				Node1 node1 = queue.pop();
				if(pre != null)
					pre.next = node1;
				pre = node1;
				if(node1.left != null) {
					queue.add(node1.left);
				}
				if(node1.right != null) {
					queue.add(node1.right);
				}
				count--;
			}
		}
		return root;
	}
}
