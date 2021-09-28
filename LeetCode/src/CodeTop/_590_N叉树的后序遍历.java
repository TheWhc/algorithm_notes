package CodeTop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: _590_N叉树的后序遍历
 * @Author: whc
 * @Date: 2021/09/26/21:13
 */
public class _590_N叉树的后序遍历 {

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

	/*List<Integer> res = new ArrayList<>();
	public List<Integer> postorder(Node root) {
		if(root == null) {
			return res;
		}
		dfs(root);
		res.add(root.val);
		return res;
	}

	private void dfs(Node root) {
		if(root == null) {
			return;
		}

		List<Node> child = root.children;
		for (Node node : child) {
			dfs(node);
			res.add(node.val);
		}
	}*/

	// 迭代法
	public List<Integer> postorder(Node root) {
		List<Integer> res = new ArrayList<>();
		if(root == null) {
			return res;
		}

		Stack<Node> stack = new Stack<>();
		stack.push(root);

		while(!stack.isEmpty()) {
			Node node = stack.pop();
			res.add(node.val);
			List<Node> children = node.children;
			for (Node child : children) {
				stack.push(child);
			}
		}

		Collections.reverse(res);
		return res;
	}

}
