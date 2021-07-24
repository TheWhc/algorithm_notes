package CodeTop;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: _129_求根节点到叶节点数字之和
 * @Author: whc
 * @Date: 2021/07/24/22:03
 */
public class _129_求根节点到叶节点数字之和 {

	/*int res = 0;
	public int sumNumbers(TreeNode root) {
		if(root == null) {
			return res;
		}
		dfs(root, "");
		return res;
	}

	private void dfs(TreeNode root, String s) {
		if(root == null) {
			return;
		}

		s += root.val;

		if(root.left == null && root.right == null) {
			res += Integer.parseInt(s);
			return;
		}

		dfs(root.left, s);
		dfs(root.right, s);
	}*/


	/*int res = 0;
	public int sumNumbers(TreeNode root) {
		if(root == null) {
			return res;
		}
		dfs(root, 0);
		return res;
	}

	private void dfs(TreeNode root, int path) {
		if(root == null) {
			return;
		}

		path = path * 10 + root.val;

		if(root.left == null && root.right == null) {
			res += path;
			return;
		}

		dfs(root.left, path);
		dfs(root.right, path);
	}*/

	// 迭代法
	public int sumNumbers(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int res = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			while(levelSize > 0) {
				TreeNode node = queue.poll();
				if(node.left != null) {
					node.left.val += node.val * 10;
					queue.offer(node.left);
				}
				if(node.right != null) {
					node.right.val += node.val * 10;
					queue.offer(node.right);
				}
				if(node.left == null && node.right == null) {
					res += node.val;
				}
				levelSize--;
			}
		}

		return res;
	}

}
