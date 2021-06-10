package 待分类;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: 待分类._559_N叉树的最大深度
 * @Author: whc
 * @Date: 2021/03/17/18:49
 */
public class _559_N叉树的最大深度 {

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

	// 递归法
	public int maxDepth(Node root) {
		return getDepth(root);
	}

	private int getDepth(Node root) {
		if(root == null)
			return 0;
		int depth = 0;
		for (int i = 0; i < root.children.size(); i++) {
			depth = Math.max(getDepth(root.children.get(i)), depth);
		}
		return depth+1;
	}

	// 迭代法
	/*public int maxDepth(Node root) {
		if(root == null)
			return 0;
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(root);
		int count = 0;
		int depth = 0;
		while(!queue.isEmpty()) {
			depth++;
			count = queue.size();
			while(count > 0) {
				Node node = queue.pop();
				List<Node> childrenList = node.children;
				for (Node child : childrenList) {
					if(child.children != null) {
						queue.add(child);
					}
				}
				count--;
			}
		}
		return depth;
	}*/

}
