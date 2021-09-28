package CodeTop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: _429_N叉树的层序遍历
 * @Author: whc
 * @Date: 2021/09/26/21:04
 */
public class _429_N叉树的层序遍历 {

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

	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) {
			return res;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);

		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> tmp = new ArrayList<>();
			while(levelSize > 0) {
				Node node = queue.poll();
				tmp.add(node.val);
				List<Node> children = node.children;
				for (Node child : children) {
					queue.offer(child);
				}
				levelSize--;
			}
			res.add(tmp);
		}

		return res;
	}
}
