package 剑指offer;

/**
 * @ClassName: 剑指offer._剑指_Offer_68_I_二叉搜索树的最近公共祖先
 * @Author: whc
 * @Date: 2021/04/02/8:55
 */
public class _剑指_Offer_68_I_二叉搜索树的最近公共祖先 {

	/**
	 *  思路: 递归法(做法与二叉树一样) (后序遍历回溯法)
	 */
	/*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == root || q == root) {
			return root;
		}

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if(left != null && right != null) {
			return root;
		} else if(left != null && right == null) {
			return left;
		} else if(left == null && right != null) {
			return right;
		} else {
			return null;
		}
	}*/

	/**
	 *  思路: 递归法(利用二叉搜索树的特性,前序遍历法)
	 *	这里递归函数有返回值,即标准的搜索一条边的写法,一旦遇到满足条件的情况,直接返回
	 *
	 */
	/*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// 递归终止条件 一定能找到祖先节点,无需处理空的情况

		// 根

		// 左子树 (左)
		if(p.val < root.val && q.val < root.val) {
			TreeNode left = lowestCommonAncestor(root.left, p, q);
			if(left != null) {
				return left;
			}
		} else if(p.val > root.val && q.val > root.val) {
			// 右子树 (右)
			TreeNode right = lowestCommonAncestor(root.right, p, q);
			if(right != null) {
				return right;
			}
		} else {
			// 若p,q分散在左右子树,则root即为公共祖先节点
			return root;
		}

		return null;
	}*/

	/**
	 *  思路: 迭代法
	 */
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
