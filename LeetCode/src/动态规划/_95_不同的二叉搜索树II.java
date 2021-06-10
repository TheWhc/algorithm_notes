package 动态规划;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _95_不同的二叉搜索树II
 * @Author: whc
 * @Date: 2021/04/20/10:42
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(){}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class _95_不同的二叉搜索树II {

	// 构建一颗二叉搜索树
	/*public TreeNode createBinaryTree(int n) {
		return helper(1, n);
	}

	private TreeNode helper(int start, int end) {
		if(start > end) {
			return null;
		}

		int val = (start + end) >> 1; // 选择中点构造二叉搜索树
		TreeNode root = new TreeNode(val);
		root.left = helper(start, val-1);
		root.right = helper(val+1, end);

		return root;
	}*/

	// 构建多颗二叉搜索树
	// 如何选择不同的根节点,以构建不同的树和子树
	public List<TreeNode> generateTrees(int n) {
		if(n < 1) {
			return new ArrayList<>();
		}
		return helper(1, n);
	}

	private List<TreeNode> helper(int start, int end) {
		List<TreeNode> list = new ArrayList<>();

		if(start > end) {
			// 要添加null
			list.add(null);
			return list;
		}

		for (int i = start; i <= end; i++) {
			List<TreeNode> left = helper(start, i-1);
			List<TreeNode> right = helper(i+1, end);

			// 固定左孩子 遍历右孩子
			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					list.add(root);
				}
			}
		}

		return list;
	}
}
