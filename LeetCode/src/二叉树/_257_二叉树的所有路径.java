package 二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _257_二叉树的所有路径
 * @Author: whc
 * @Date: 2021/04/18/10:38
 */
public class _257_二叉树的所有路径 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		new _257_二叉树的所有路径().binaryTreePaths(root);
	}

	List<String> res = new ArrayList<>();
	public List<String> binaryTreePaths(TreeNode root) {
		if(root == null) {
			return res;
		}
		StringBuffer sb = new StringBuffer();
		dfs(root, sb);
		return res;
	}

	// 前序遍历
	/*private void dfs(TreeNode root, StringBuffer sb) {
		if(root == null) {
			return;
		}
		sb.append(root.val + "->");
		if(root.left == null && root.right == null) {
			res.add(sb.toString().substring(0, sb.length()-2));
			return;
		}
		// 隐式撤销选择（实际上因为用了new StringBuffer(sb)重新创建了一个对象，所以从尝试做出选择到回退状态这一过程sb是没有参与的）
		dfs(root.left, new StringBuffer(sb));
		dfs(root.right, new StringBuffer(sb));
	}*/


	// 显示撤销
	private void dfs(TreeNode root, StringBuffer sb) {
		if(root == null) {
			return;
		}
		sb.append(root.val + "->");
		int len = sb.length();
		if(root.left == null && root.right == null) {
			res.add(sb.toString().substring(0, sb.length()-2));
			return;
		}
		dfs(root.left, sb);
		sb.delete(len, sb.length());
		dfs(root.right, sb);
 	}
}
