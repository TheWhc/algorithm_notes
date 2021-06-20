package 二叉树.二叉树的遍历方式;

import java.util.List;

/**
 * @ClassName: Node
 * @Author: whc
 * @Date: 2021/06/20/14:41
 */
class Node {
	public int val;
	public List<Node> children;

	public Node() {}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
}
