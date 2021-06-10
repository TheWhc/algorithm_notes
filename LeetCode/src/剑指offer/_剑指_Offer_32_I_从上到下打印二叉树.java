package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: _剑指_Offer_32_I_从上到下打印二叉树
 * @Author: whc
 * @Date: 2021/05/29/10:16
 */
public class _剑指_Offer_32_I_从上到下打印二叉树 {

	// 层序遍历
	// 时间:O(n)
	// 空间:O(n)
	public int[] levelOrder(TreeNode root) {
		if(root == null) {
			return new int[0];
		}
		ArrayList<Integer> list = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			list.add(node.val);
			if(node.left != null) {
				queue.offer(node.left);
			}
			if(node.right != null) {
				queue.offer(node.right);
			}
		}
		int[] res = new int[list.size()];
		for(int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}
}
