package 待分类;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: 待分类._102_二叉树的层序遍历
 * @Author: whc
 * @Date: 2021/03/04/10:30
 */
public class _102_二叉树的层序遍历 {

	// 2021/3/4 二刷
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if(root != null) {
			queue.add(root);
		}
		while(!queue.isEmpty()) {
			List<Integer> tmp = new ArrayList<>();
			int count = queue.size();
			while(count > 0) {
				TreeNode node = queue.poll();
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
				tmp.add(node.val);
				count--;
			}
			res.add(tmp);
		}

		return res;
	}
}
