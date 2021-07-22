package CodeTop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: _199_二叉树的右视图
 * @Author: whc
 * @Date: 2021/07/22/10:21
 */
public class _199_二叉树的右视图 {

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		res.add(root.val);

		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			while(levelSize > 0) {
				TreeNode node = queue.poll();
				if(levelSize == 0) {
					res.add(node.val);
				}
				if(node.left != null) {
					queue.offer(node.left);
				}
				if(node.right != null) {
					queue.offer(node.right);
				}
				levelSize--;
			}
		}

		return res;
	}
}
