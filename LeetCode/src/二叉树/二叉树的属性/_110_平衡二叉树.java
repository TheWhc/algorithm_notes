package 二叉树.二叉树的属性;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @ClassName: _110_平衡二叉树
 * @Author: whc
 * @Date: 2021/06/21/11:42
 */
public class _110_平衡二叉树 {

	/**
	 *  思路: 递归法
	 *
	 *  1. 判断左右子树的高度差绝对值 是否 <= 1
	 *  2. 注意一点,还需要判断左右子树是否平衡,防止虽然左右子树高度差符合,但是两者却不平衡
	 */
	/*public boolean isBalanced(TreeNode root) {
		if(root == null) {
			return true;
		}

		int leftDepth = getDepth(root.left);
		int rightDepth = getDepth(root.right);

		return Math.abs(leftDepth - rightDepth) <= 1 && isBalanced(root.left) && isBalanced(root.right);
	}

	private int getDepth(TreeNode cur) {
		if(cur == null) {
			return 0;
		}
		return Math.max(getDepth(cur.left), getDepth(cur.right)) + 1;
	}*/

	/**
	 * 思路: 迭代法
	 *
	 * 1. 前序遍历每个节点
	 * 2. 对每个节点按照层序遍历的方式计算高度
	 * 3. 对前序遍历得到的每个节点判断是否平衡,得到节点的左右高度差是否小于等于1
	 *
	 */
	public boolean isBalanced(TreeNode root) {
		// 前序遍历每个节点是否满足
		if(root == null) {
			return true;
		}

		Stack<TreeNode> stack = new Stack<>();
		while(!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			int curDiff = Math.abs(getDepth(cur.left) - getDepth(cur.right));
			if(curDiff > 1) {
				return false;
			}
			if(cur.right !=  null) {
				stack.push(cur.right);
			}
			if(cur.left != null) {
				stack.push(cur.left);
			}
		}

		return true;
	}

	// 层序遍历,得到树的高度
	private int getDepth(TreeNode cur) {
		if(cur == null) {
			return 0;
		}
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(cur);
		int res = 1;
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			while(levelSize > 0) {
				TreeNode node = queue.poll();
				if(node.left != null) {
					queue.offer(node.left);
				}
				if(node.right != null) {
					queue.offer(node.right);
				}
				levelSize--;
			}
			res++;
		}

		return res;
	}
}
