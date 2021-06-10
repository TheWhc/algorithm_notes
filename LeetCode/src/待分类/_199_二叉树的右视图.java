package 待分类;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: 待分类._199_二叉树的右视图
 * @Author: whc
 * @Date: 2021/03/17/17:57
 */
public class _199_二叉树的右视图 {

	// 层序遍历 bfs,并保留最后一个
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root == null)
			return res;
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int count = 0;
		while(!queue.isEmpty()) {
			count = queue.size();
			res.add((queue.peekLast().val));
			while(count > 0) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
				count--;
			}
		}

		return res;
	}
}
