package top100;

import java.util.Stack;

/**
 * @ClassName: _114_二叉树展开为链表
 * @Author: whc
 * @Date: 2021/05/08/10:25
 */
public class _114_二叉树展开为链表 {

	/**
	 *  思路:
	 *  	1. 将左子树插入到右子树的地方
	 *  	2. 将原来右子树接到左子树的最右边结点
	 *  	3. 考虑新的右子树的结点,直到右子树结点为null
	 */
	/*public void flatten(TreeNode root) {
		while(root != null) {
			if(root.left == null) {
				root = root.right;
			} else {
				// 找到左子树的最右节点
				TreeNode node = root.left;
				while(node.right != null) {
					node = node.right;
				}
				// 将右子树接到左子树的最右边节点
				node.right = root.right;
				// 将左子树接到右子树
				root.right = root.left;
				root.left = null;

				// 考虑下一个节点
				root = root.right;
			}
		}
	}*/


	/**
	 *  思路2: 在原来的节点上改变指针的方向,用后序遍历递归法
	 *  如果是前序遍历的话 比如 1 2 3 4 5 6  遍历到2时, 吧1指向2 变为 1->2 3 4 5 6
	 *  但是这样就会丢失原本1的右孩子
	 *  所以要用后序遍历  6 5 4 3 2 1  遍历到5的时, 吧5指向6  变为 6 <- 5 4 3 2 1 这样不会丢失孩子问题了
	 */
	/*private TreeNode pre = null;
	public void flatten(TreeNode root) {
		if(root == null) {
			return;
		}
		// 右
		flatten(root.right);
		// 左
		flatten(root.left);
		// 根
		root.right = pre;
		root.left = null;
		pre = root;
	}*/

	/**
	 *  思路3:
	 *  先序遍历迭代法 (因为迭代法中栈中保存了右孩子节点,所以不会丢失孩子节点问题)
	 */
	public void flatten(TreeNode root) {
		if(root == null) {
			return;
		}
		TreeNode pre = null;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if(node != null && pre != null) {
				pre.right = node;
				pre.left = null;
			}
			pre = node;
			if(node.right != null) {
				stack.push(node.right);
			}
			if(node.left != null) {
				stack.push(node.left);
			}
		}
	}
}
