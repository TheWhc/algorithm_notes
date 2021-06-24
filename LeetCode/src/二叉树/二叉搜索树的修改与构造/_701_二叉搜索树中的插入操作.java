package 二叉树.二叉搜索树的修改与构造;

import java.lang.annotation.Target;

/**
 * @ClassName: _701_二叉搜索树中的插入操作
 * @Author: whc
 * @Date: 2021/06/24/9:57
 */
public class _701_二叉搜索树中的插入操作 {

	/**
	 * 思路: 递归法
	 * 1. 确定递归函数参数以及返回值
	 * void dfs(TreeNode root, int val)
	 * 2. 递归终止条件
	 * 找到遍历的节点为null的时候，就是要插入节点的位置了，并把插入的节点返回
	 * 3. 单层递归逻辑
	 * 按照二叉搜索树的性质进行递归查找
	 */
	/*TreeNode pre = null;
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if(root == null) {
			return new TreeNode(val);
		}

		dfs(root, val);
		return root;
	}

	private void dfs(TreeNode root, int val) {
		// 递归终止条件
		if(root == null) {
			TreeNode node = new TreeNode(val);
			if(val > pre.val) {
				pre.right = node;
			} else {
				pre.left = node;
			}
			return;
		}

		// 父节点
		pre = root;
		// 当前节点值大于val,则向左递归
		if(root.val > val) {
			dfs(root.left, val);
		}
		// 当前节点值小于val,则向右递归
		if(root.val < val) {
			dfs(root.right, val);
		}
	}*/

	/**
	 * 思路: 递归
	 * 1. 确定递归函数参数以及返回值
	 * TreeNode insertIntoBST(TreeNode root, int val)
	 * 带有返回值的情况
	 * 2. 确定递归终止条件
	 * 节点为空时,直接返回新构建节点
	 * 3. 单层递归逻辑
	 * 当前节点值大于val时,则递归左子树,root.left指向左子树根节点
	 * 当前节点值小于val时,则递归右子树, root.right指向右子树根节点
	 */
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

	/**
	 * 思路: 迭代法
	 * 1. 借助pre指向父节点
	 * 2. 迭代遍历节点,直到节点为空
	 * 3. 若当前节点大于val,则root = root.left
	 *    若当前节点小于val,则root = root.right
	 * 4. 然后pre构建新的节点
	 */
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if(root == null) {
			return new TreeNode(val);
		}
		TreeNode newRoot = root;
		TreeNode pre = root;
		while(root != null) {
			pre = root;
			if(root.val > val) {
				root = root.left;
			} else if(root. val < val) {
				root = root.right;
			}
		}

		if(pre.val > val) {
			pre.left = new TreeNode(val);
		} else {
			pre.right = new TreeNode(val);
		}

		return newRoot;
	}

}
