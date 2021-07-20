package CodeTop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: _102_二叉树的层序遍历
 * @Author: whc
 * @Date: 2021/07/20/14:29
 */
public class _102_二叉树的层序遍历 {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();

		queue.offer(root);
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			List<Integer> tmp = new ArrayList<>();
			while(levelSize > 0) {
				TreeNode node = queue.poll();
				tmp.add(node.val);
				if(node.left != null) {
					queue.offer(node.left);
				}
				if(node.right != null) {
					queue.offer(node.right);
				}
				levelSize--;
			}

			res.add(tmp);
		}

		return res;
	}
}
