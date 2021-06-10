/**
 * @ClassName: _NC102_在二叉树中找到两个节点的最近公共祖先
 * @Author: whc
 * @Date: 2021/02/24/9:46
 */
public class _NC102_在二叉树中找到两个节点的最近公共祖先 {
	public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
		// write code here
		if(root == null) {
			return -1;
		}
		if(root.val == o1 || root.val == o2) {
			return root.val;
		}
		int left = lowestCommonAncestor(root.left, o1, o2);
		int right = lowestCommonAncestor(root.right, o1, o2);

		if(left == -1) {
			return right;
		}
		if(right == -1) {
			return left;
		}

		return root.val;
	}
}
