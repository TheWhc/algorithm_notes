package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: _剑指_Offer_32_III_从上到下打印二叉树_III
 * @Author: whc
 * @Date: 2021/05/29/10:37
 */
public class _剑指_Offer_32_III_从上到下打印二叉树_III {

	public List<List<Integer>> levelOrder(TreeNode root) {
		if(root == null) {
			return new ArrayList<>();
		}
		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int level = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> tmp = new ArrayList<>();
			while(size > 0) {
				TreeNode node = queue.poll();
				if(level % 2 == 0) {
					tmp.add(node.val);
				} else {
					tmp.add(0, node.val);
				}
				if(node.left != null) {
					queue.offer(node.left);
				}
				if(node.right != null) {
					queue.offer(node.right);
				}
				size--;

			}
			level++;
			res.add(tmp);
		}

		return res;
	}
}
