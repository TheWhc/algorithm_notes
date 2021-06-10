package 二叉树;

/**
 * @ClassName: _669_修剪二叉搜索树
 * @Author: whc
 * @Date: 2021/04/22/12:02
 */
public class _669_修剪二叉搜索树 {

	/*public TreeNode trimBST(TreeNode root, int low, int high) {
		if(root == null) return null;

		// 单层递归逻辑
		if(root.val < low) {
			return trimBST(root.right, low, high);
		}

		if(root.val > high) {
			return trimBST(root.left, low, high);
		}

		// 最后返回root结点
		root.left = trimBST(root.left, low, high);
		root.right = trimBST(root.right, low, high);
		return root;
	}*/

	// 迭代法
	public TreeNode trimBST(TreeNode root, int low, int high) {
		if(root == null) return null;

		// 处理头结点,让root移动到[low,high]范围内,注意是左闭右开
		while(root.val < low || root.val > high) {
			if(root.val < low) {
				root = root.right;
			} else {
				root = root.left;
			}
			if(root == null) break;
		}

		// 剪枝左子树
		TreeNode cur = root;
		while(cur != null) {
			while(cur.left != null && cur.left.val < low) {
				cur.left = cur.left.right;
			}
			cur = cur.left;
		}

		// 剪枝右子树
		// 处理右孩子大于high的情况
		cur = root;
		while(cur != null) {
			while(cur.right != null && cur.right.val > high) {
				cur.right = cur.right.left;
			}
			cur = cur.right;
		}

		return root;
	}


}
