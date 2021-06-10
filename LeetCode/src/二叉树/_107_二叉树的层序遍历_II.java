package 二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: _107_二叉树的层序遍历_II
 * @Author: whc
 * @Date: 2021/04/16/10:02
 */
public class _107_二叉树的层序遍历_II {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) {
			return res;
		}

		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int count = 0;
		while(!queue.isEmpty()) {
			count = queue.size();
			List<Integer> tmp = new ArrayList<>();
			while(count > 0) {
				TreeNode node = queue.pop();
				tmp.add(node.val);
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
				count--;
			}
			res.add(tmp);
		}
		Collections.reverse(res);
		return res;
	}

}
