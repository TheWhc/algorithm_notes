package CodeTop;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: _589_N叉树的前序遍历
 * @Author: whc
 * @Date: 2021/09/26/20:43
 */
public class _589_N叉树的前序遍历 {

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
	public List<Integer> preorder(Node root) {
		dfs(root);
		return res;
	}

	private void dfs(Node root) {
		if(root == null) {
			return;
		}

		res.add(root.val);
		List<Node> child = root.children;
		for (Node node : child) {
			dfs(node);
		}

	}*/

	public List<Integer> preorder(Node root) {
		List<Integer> res = new ArrayList<>();
		if(root == null) {
			return res;
		}

		Stack<Node> stack = new Stack<>();
		stack.add(root);

		while(!stack.isEmpty()) {
			Node node = stack.pop();
			res.add(node.val);
			List<Node> children = node.children;
			for (int i = children.size()-1; i >= 0; i--) {
				stack.push(children.get(i));
			}
		}

		return res;
	}
}
