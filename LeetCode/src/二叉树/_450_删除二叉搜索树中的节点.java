package 二叉树;

/**
 * @ClassName: _450_删除二叉搜索树中的节点
 * @Author: whc
 * @Date: 2021/04/22/10:41
 */
public class _450_删除二叉搜索树中的节点 {

	public TreeNode deleteNode(TreeNode root, int key) {
		if(root == null) return null;

		TreeNode cur = root;
		TreeNode pre = null;
		while(cur != null) {
			if(cur.val == key) break;
			pre = cur;
			if(cur.val > key) {
				cur = cur.left;
			} else {
				cur = cur.right;
			}
		}

		if(pre == null) { // 如果搜索树只有头结点
			return deleteOneNode(cur);
		}
		// 要知道删除的左孩子还是右孩子
		if(pre.left != null && pre.left.val == key) {
			pre.left = deleteOneNode(cur);
		}
		if(pre.right != null && pre.right.val == key) {
			pre.right = deleteOneNode(cur);
		}

		return root;
	}

	private TreeNode deleteOneNode(TreeNode cur) {
		if(cur == null) return cur;
		if(cur.right == null) return cur.left;
		if(cur.left == null) return cur.right;
		// 目标结点的右子树的最左面结点的左孩子位置
		TreeNode res = cur.right;
		while(res.left != null) {
			res = res.left;
		}
		res.left = cur.left;
		return cur.right;
	}

	// 递归法
	/*public TreeNode deleteNode(TreeNode root, int key) {
		if(root == null) return root;

		if(root.val == key) {
			if(root.left == null && root.right == null) {
				return null;
			} else if(root.left == null && root.right != null) {
				return root.right;
			} else if(root.left != null && root.right == null) {
				return root.left;
			} else {
				// 找到右子树最左面的结点
				TreeNode cur = root.right;
				while(cur.left != null) {
					cur = cur.left;
				}
				// 把要删除结点的左子树放到右子树最左面结点的左面
				cur.left = root.left;
				root = root.right;
				return root;
			}
		}

		if(root.val > key) {
			root.left = deleteNode(root.left, key);
		}
		if(root.val < key) {
			root.right = deleteNode(root.right, key);
		}

		return root;
	}*/

}
