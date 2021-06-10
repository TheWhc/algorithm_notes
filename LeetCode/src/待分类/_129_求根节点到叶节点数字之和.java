package 待分类;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: 待分类._129_求根节点到叶节点数字之和
 * @Author: whc
 * @Date: 2021/03/26/12:01
 */
public class _129_求根节点到叶节点数字之和 {

	/*int sum = 0;

	// 递归 + 回溯
	public int sumNumbers(TreeNode root) {
		if(root == null)
			return 0;

		List<TreeNode> path = new ArrayList<>();
		traversal(path, root);
		return sum;
	}

	private void traversal(List<TreeNode> path, TreeNode root) {
		// 递归终止条件
		if(root == null)
			return;

		// 单层递归逻辑
		path.add(root);
		if(root.left == null && root.right == null) {
			add(path);
		}

		traversal(path, root.left);
		traversal(path, root.right);
		path.remove(path.size()-1);
	}

	private void add(List<TreeNode> path) {
		int temp = 0;
		for (TreeNode treeNode : path) {
			temp = temp * 10 + treeNode.val;
		}
		sum += temp;
	}*/

	int sum = 0;

	// 递归 + 回溯
	public int sumNumbers(TreeNode root) {
		if(root == null)
			return 0;

		List<Integer> path = new ArrayList<>();
		path.add(root.val);
		traversal(path, root);
		return sum;
	}

	private void traversal(List<Integer> path, TreeNode root) {
		// 递归终止条件
		if(root.left == null && root.right == null) {
			sum += add(path);
			return;
		}

		// 单层递归逻辑
		if(root.left != null) {
			path.add(root.left.val);
			traversal(path, root.left);
			path.remove(path.size()-1);
		}

		if(root.right != null) {
			path.add(root.right.val);
			traversal(path, root.right);
			path.remove(path.size() - 1);
		}
	}

	private int add(List<Integer> path) {
		int temp = 0;
		for (Integer num: path) {
			temp = temp * 10 + num;
		}
		return temp;
	}


	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		new _129_求根节点到叶节点数字之和().sumNumbers(node);
	}
}
