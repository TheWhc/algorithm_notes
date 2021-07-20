package CodeTop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: _103_二叉树的锯齿形层序遍历
 * @Author: whc
 * @Date: 2021/07/20/14:33
 */
public class _103_二叉树的锯齿形层序遍历 {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();

		queue.offer(root);
		int level = 0;
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			LinkedList<Integer> tmp = new LinkedList<>();
			while(levelSize > 0) {
				TreeNode node = queue.poll();
				if(level % 2 == 0) {
					tmp.add(node.val);
				} else {
					tmp.addFirst(node.val);
				}
				if(node.left != null) {
					queue.offer(node.left);
				}
				if(node.right != null) {
					queue.offer(node.right);
				}
				levelSize--;
			}
			level++;
			res.add(tmp);
		}

		return res;
	}
}
