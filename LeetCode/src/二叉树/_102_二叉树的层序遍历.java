package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: 待分类._102_二叉树的层序遍历
 * @Author: whc
 * @Date: 2021/04/16/9:57
 */
public class _102_二叉树的层序遍历 {

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

		return res;
	}
}
