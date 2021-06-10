package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: 待分类._199_二叉树的右视图
 * @Author: whc
 * @Date: 2021/04/16/10:07
 */
public class _199_二叉树的右视图 {

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root == null) {
			return res;
		}

		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int count = 0;
		while(!queue.isEmpty()) {
			count = queue.size();
			while(count > 0) {
				TreeNode node = queue.poll();
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
				count--;
				if(count == 0) {
					res.add(node.val);
				}
			}
		}

		return res;
	}
}
