package 待分类;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: 待分类._103_二叉树的锯齿形层序遍历
 * @Author: whc
 * @Date: 2021/03/04/11:22
 */
public class _103_二叉树的锯齿形层序遍历 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if(root != null) {
			queue.add(root);
		}
		int level = 0;
		while(!queue.isEmpty()) {
			LinkedList<Integer> tmp = new LinkedList<>();
			int count = queue.size();
			while(count > 0) {
				TreeNode node = queue.poll();
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
				if(level % 2 == 0) {
					tmp.add(node.val);
				} else {
					tmp.addFirst(node.val);
				}
				count--;
			}
			res.add(tmp);
			level++;
		}

		return res;
	}
}
