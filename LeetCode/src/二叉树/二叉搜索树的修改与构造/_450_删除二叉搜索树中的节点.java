package 二叉树.二叉搜索树的修改与构造;

/**
 * @ClassName: _450_删除二叉搜索树中的节点
 * @Author: whc
 * @Date: 2021/06/24/11:16
 */
public class _450_删除二叉搜索树中的节点 {

	/**
	 * 思路: 递归法
	 * 1. 确定递归函数以及参数的含义
	 * TreeNode deleteNode(TreeNode root, int key)
	 * 2. 确定递归终止条件
	 * if(root == null) {
	 *     return null;
	 * }
	 * 3. 单层递归逻辑
	 * 如果当前节点值大于val
	 * 则 root.left = 递归左子树
	 * 如果当前节点值小于val
	 * 则 root.right = 递归右子树
	 * 如果当前节点值等于val,有几种情况需要分析
	 * 	(1) 当前节点的左右孩子都为空
	 * 	(2) 当前节点的左孩子为空,右孩子不为空,则返回右孩子
	 * 	(3) 当前节点的右孩子为空,左孩子不为空,则返回左孩子
	 * 	(4) 当前节点的左右孩子都不为空
	 * 		需要找到右孩子的最左边的节点
	 * 		root = root.right
	 * 		返回新的根节点
	 */
	public TreeNode deleteNode(TreeNode root, int key) {
		if(root == null) {
			return null;
		}

		if(root.val > key) {
			root.left = deleteNode(root.left, key);
			return root;
		} else if(root.val < key) {
			root.right = deleteNode(root.right, key);
			return root;
		} else {
			// 左右孩子都为空,直接删除节点,返回null为根节点
			// 左孩子为空,右孩子不为空,删除节点,右孩子补位,返回右孩子为根节点
			if(root.left == null) {
				return root.right;
			} else if(root.right == null) {
				// 左孩子不为空,右孩子为空,删除节点,左孩子补位,返回左孩子为根节点
				return root.left;
			} else {
				// 左右孩子都不为空
				// 先找到右子树的最左面的节点
				TreeNode cur = root.right;
				while(cur.left != null) {
					cur = cur.left;
				}
				cur.left = root.left;
				// 将旧root的右孩子作为新的root
				root = root.right;
				// 返回新的root
				return root;
			}
		}

	}
}
