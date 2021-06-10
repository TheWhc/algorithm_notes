package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: 剑指offer._剑指_Offer_32_II_从上到下打印二叉树II
 * @Author: whc
 * @Date: 2021/04/02/9:03
 */
public class _剑指_Offer_32_II_从上到下打印二叉树II {

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
			for (int i = 0; i < count; i++) {
				TreeNode node = queue.pop();
				tmp.add(node.val);
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
			}
			res.add(tmp);
		}

		return res;
	}
}
