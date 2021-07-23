package 二叉树.路径问题.自顶向下;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _257_二叉树的所有路径
 * @Author: whc
 * @Date: 2021/07/23/12:53
 */
public class _257_二叉树的所有路径 {

	List<String> res = new ArrayList<>();
	public List<String> binaryTreePaths(TreeNode root) {
		dfs(root, "");
		return res;
	}

	private void dfs(TreeNode root, String path) {
		if(root == null) {
			return;
		}

		path += root.val;
		// 遇到叶子节点,添加结果后返回
		if(root.left == null && root.right == null) {
			res.add(new String(path));
			return;
		}

		dfs(root.left, path + "->");
		dfs(root.right, path + "->");
	}
}
