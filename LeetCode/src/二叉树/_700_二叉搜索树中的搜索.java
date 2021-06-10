package 二叉树;

import java.util.LinkedList;

/**
 * @ClassName: _700_二叉搜索树中的搜索
 * @Author: whc
 * @Date: 2021/04/21/9:38
 */
public class _700_二叉搜索树中的搜索 {

	// 递归法
	/*public TreeNode searchBST(TreeNode root, int val) {
		if(root == null) {
			return null;
		}

		// 终止条件
		if(root.val == val) {
			return root;
		}

		// 后序遍历 左右根
		TreeNode leftNode = searchBST(root.left, val);
		TreeNode rightNode = searchBST(root.right, val);

		if(leftNode != null) {
			return leftNode;
		} else {
			return rightNode;
		}
	}*/

	/*public TreeNode searchBST(TreeNode root, int val) {
		if(root == null) {
			return null;
		}

		// 终止条件
		if(root.val == val) {
			return root;
		}

		if(root.val > val) {
			return searchBST(root.left, val);
		}

		if(root.val < val) {
			return searchBST(root.right, val);
		}

		return null;
	}*/

	// 迭代法
	public TreeNode searchBST(TreeNode root, int val) {
		if(root == null) {
			return null;
		}

		while(root != null) {
			if(root.val > val) {
				root = root.left;
			} else if(root.val < val) {
				root = root.right;
			} else {
				return root;
			}
		}

		return null;
	}
}
