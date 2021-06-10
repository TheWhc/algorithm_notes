package 二叉树;

/**
 * @ClassName: _701_二叉搜索树中的插入操作
 * @Author: whc
 * @Date: 2021/04/22/10:20
 */
public class _701_二叉搜索树中的插入操作 {

	// 迭代法
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if(root == null) return new TreeNode(val);
		TreeNode cur = root;
		TreeNode parent = null;
		while(cur != null) {
			parent = cur;
			if(cur.val > val) {
				cur = cur.left;
			} else{
				cur = cur.right;
			}
		}

		if(parent.val > val) {
			parent.left = new TreeNode(val);
		} else {
			parent.right = new TreeNode(val);
		}

		return root;
	}

	// 递归法
	/*public TreeNode insertIntoBST(TreeNode root, int val) {
		if(root == null) {
			return new TreeNode(val);
		}

		if(root.val > val) {
			root.left = insertIntoBST(root.left, val);
		}
		if(root.val < val) {
			root.right = insertIntoBST(root.right, val);
		}

		return root;
	}*/


}
