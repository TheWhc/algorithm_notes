package 二叉树;

/**
 * @ClassName: 待分类._235_二叉搜索树的最近公共祖先
 * @Author: whc
 * @Date: 2021/04/22/9:49
 */
public class _235_二叉搜索树的最近公共祖先 {

	/*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || root == p || root == q) {
			return root;
		}

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if(left != null && right == null) {
			return left;
		} else if(left == null && right != null) {
			return right;
		} else if(left != null && right != null) {
			return root;
		} else {
			return null;
		}
	}*/

	// 前序遍历 根左右
	/*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// 递归中止条件
		if(root == null) {
			return root;
		}

		// 在左子树
		if(root.val > p.val && root.val > q.val) {
			// 搜索一条边 若符合立即返回
			TreeNode left = lowestCommonAncestor(root.left, p, q);
			if(left != null) {
				return left;
			}
		}

		// 在右子树
		if(root.val < p.val && root.val < q.val) {
			TreeNode right = lowestCommonAncestor(root.right, p, q);
			if(right != null) {
				return right;
			}
		}

		// 说明p q在左右子树 返回当前结点
		return root;
	}*/


	// 迭代法
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while(root != null) {
			if(root.val > p.val && root.val > q.val) {
				root = root.left;
			} else if(root.val < p.val && root.val < q.val) {
				root = root.right;
			} else {
				return root;
			}
		}

		return null;
	}
}
