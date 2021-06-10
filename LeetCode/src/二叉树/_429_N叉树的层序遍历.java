package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: _429_N叉树的层序遍历
 * @Author: whc
 * @Date: 2021/04/16/10:41
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
public class _429_N叉树的层序遍历 {

	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) {
			return res;
		}

		LinkedList<Node> queue = new LinkedList<>();
		queue.add(root);
		int count = 0;
		while(!queue.isEmpty()) {
			List<Integer> tmp = new ArrayList<>();
			count = queue.size();
			while(count > 0) {
				Node node = queue.pop();
				for (Node child : node.children) {
					queue.add(child);
				}
				tmp.add(node.val);
				count--;
			}
			res.add(tmp);
		}

		return res;
	}
}
