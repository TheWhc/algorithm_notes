package CodeTop;

import java.util.*;

/**
 * @ClassName: _107_二叉树的层序遍历II
 * @Author: whc
 * @Date: 2021/09/15/13:36
 */
public class _107_二叉树的层序遍历II {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) {
			return res;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while(!queue.isEmpty()) {
			int cnt = queue.size();
			List<Integer> temp = new ArrayList<>();
			while(cnt > 0) {
				TreeNode node = queue.poll();
				temp.add(node.val);
				if(node.left != null) {
					queue.offer(node.left);
				}
				if(node.right != null) {
					queue.offer(node.right);
				}
				cnt--;
			}
			res.add(temp);
		}

		Collections.reverse(res);
		return res;
	}
}
