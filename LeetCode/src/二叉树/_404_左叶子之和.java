package 二叉树;

import java.util.LinkedList;

/**
 * @ClassName: _404_左叶子之和
 * @Author: whc
 * @Date: 2021/04/18/12:28
 */
public class _404_左叶子之和 {

	/*// 层序遍历
	public int sumOfLeftLeaves(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int res = 0;
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int count = queue.size();
			while(count > 0) {
				TreeNode node = queue.pop();
				if(node.left != null) {
					queue.add(node.left);
					if(node.left.left == null && node.left.right == null) {
						res += node.left.val;
					}
				}
				if(node.right != null) {
					queue.add(node.right);
				}
				count--;
			}
		}
		return res;
	}*/


	/*int res = 0;

	public int sumOfLeftLeaves(TreeNode root) {
		if(root == null) {
			return 0;
		}
		dfs(root);
		return res;
	}

	private void dfs(TreeNode root) {
		if(root == null) {
			return;
		}
		dfs(root.left);
		dfs(root.right);
		if(root.left != null) {
			if(root.left.left == null && root.left.right == null)
				res += root.left.val;
		}
	}*/

	public int sumOfLeftLeaves(TreeNode root) {
		if(root == null) return 0;
		int leftSum = sumOfLeftLeaves(root.left);
		int rightSum = sumOfLeftLeaves(root.right);

		int midValue = 0;
		if(root.left != null && root.left.left == null && root.left.right == null){
			midValue = root.left.val;
		}
		return midValue + leftSum + rightSum;
	}

}
