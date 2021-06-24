package 二叉树.二叉树公共祖先问题;

/**
 * @ClassName: _235_二叉搜索树的最近公共祖先
 * @Author: whc
 * @Date: 2021/06/24/9:37
 */
public class _235_二叉搜索树的最近公共祖先 {

	/**
	 * 思路: 按照二叉树的最近公共祖先思路, 递归法
	 */
	/*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null ||root == p || root == q) {
			return root;
		}

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if(left != null && right == null) {
			return left;
		} else if(left == null && right != null) {
			return right;
		} else if(left == null && right == null) {
			return null;
		} else {
			return root;
		}
	}*/

	/**
	 * 思路: 二叉搜索树的性质
	 * 迭代法
	 * 如果当前节点同时大于p和q,那么说明父节点在左子树
	 * 如果当前节点同时小于p和q,那么说明父节点在右子树
	 * 否则当前节点为最近公关祖先节点
	 */
	/*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null) {
			return root;
		}

		while(root != null) {
			if(root.val > p.val && root.val > q.val) {
				root = root.left;
			} else if(root.val < p.val && root.val < q.val) {
				root = root.right;
			} else {
				// (root.val == p.val || root.val == q.val)
				// root.val > p.val && root.val < q.val
				return root;
			}
		}

		return null;
	}*/

	/**
	 * 思路: 递归法
	 * 单层递归逻辑:
	 * 如果当前节点同时大于p和q,那么说明父节点在左子树
	 * 如果当前节点同时小于p和q,那么说明父节点在右子树
	 * 否则当前节点为最近公关祖先节点
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || root == p || root == q) {
			return root;
		}

		if(root.val > p.val && root.val > q.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else if(root.val < p.val && root.val < q.val) {
			return lowestCommonAncestor(root.right, p, q);
		}

		return root;
	}
}
