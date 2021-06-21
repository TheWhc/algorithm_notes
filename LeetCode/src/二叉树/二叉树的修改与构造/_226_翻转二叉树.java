package 二叉树.二叉树的修改与构造;

import java.util.Stack;

/**
 * @ClassName: _226_翻转二叉树
 * @Author: whc
 * @Date: 2021/06/21/9:55
 */
public class _226_翻转二叉树 {

	/**
	 *  思路: 递归翻转
	 *  1. 确定递归函数返回值以及参数的含义
	 *     返回值为TreeNode(或者不用返回值,按照遍历整棵树的思路)
	 *     参数为root 当前节点
	 *
	 *  2. 递归函数的返回值
	 *     节点为空的时候,返回null
	 *
	 *  3. 单层递归的逻辑
	 *     按照后序遍历的顺序(或者前序遍历的顺序),
	 *     递归翻转后得到左子树的节点和右子树的节点,再交换左右子树的节点
	 */
	/*public TreeNode invertTree(TreeNode root) {
		if(root == null) {
			return root;
		}
		invertTree(root.left);
		invertTree(root.right);
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		return root;
	}*/


	/**
	 *  思路: 迭代法
	 *  按照前序遍历的迭代法
	 *
	 *  1. 首先将根节点入栈
	 *  2. 依次出栈的元素,出栈的同时,将出栈的节点进行翻转,同时将节点的右节点和左节点不为空的添加到栈中
	 */
	public TreeNode invertTree(TreeNode root) {
		if(root == null) {
			return root;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop(); // 根
			TreeNode temp = node.left;
			node.left = node.right;
			node.right = temp;

			if(node.right != null) {
				stack.push(node.right);
			}

			if(node.left != null) {
				stack.push(node.left);
			}
		}

		return root;
	}
}
