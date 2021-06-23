package 二叉树;

import java.util.LinkedList;

/**
 * @ClassName: 待分类._559_N叉树的最大深度
 * @Author: whc
 * @Date: 2021/04/17/10:01
 */
public class _559_N叉树的最大深度 {
/*
	public int maxDepth(Node root) {
		return getDepth(root);
	}

	private int getDepth(Node root) {
		if(root == null)
			return 0;
		int depth = 0;
		for(Node node : root.children) {
			depth = Math.max(getDepth(node), depth);
		}

		return depth + 1;
	}*/

	// 迭代法
	/*public int maxDepth(Node root) {
		if(root == null)
			return 0;
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(root);
		int res = 0;
		while(!queue.isEmpty()) {
			int count = queue.size();
			while(count > 0) {
				Node node = queue.pop();
				for (Node child : node.children) {
					queue.add(child);
				}
				count--;
			}
			res++;
		}
		return res;
	}*/
}
