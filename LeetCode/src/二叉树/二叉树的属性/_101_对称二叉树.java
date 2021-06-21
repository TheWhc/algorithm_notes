package 二叉树.二叉树的属性;

import java.util.LinkedList;

/**
 * @ClassName: _101_对称二叉树
 * @Author: whc
 * @Date: 2021/06/21/10:16
 */
public class _101_对称二叉树 {

	/**
	 *  思路: 递归法
	 *
	 *  1. 确定递归函数返回值以及参数的含义
	 *   boolean compare(TreeNode left, TreeNode right)
	 *   返回值为boolean类型,判断是不是对称的
	 *   参数一个为左节点,一个为右节点
	 *
	 *  2. 确定终止条件
	 *   (1) 如果两个节点都为空节点则返回true
	 *   (2) 如果其中一个节点为空则返回false
	 *   (3) 如果两个节点的值不相等则返回false
	 *
	 *   3. 单层递归逻辑
	 *   递归判断当前节点的左节点和当前节点的右节点(判断外侧)
	 *   递归判断当前节点的右节点和当前节点的左节点(判断内侧)
	 */
/*	public boolean isSymmetric(TreeNode root) {
		if(root == null) {
			return true;
		}
		return compare(root.left, root.right);
	}

	private boolean compare(TreeNode left, TreeNode right) {
		if(left == null && right == null) {
			// 都为空节点,返回true
			return true;
		} else if(left == null || right == null) {
			// 其中一个为空,则返回false
			return false;
		} else if(left.val != right.val) {
			// 两者数值不相等,返回false
			return false;
		}

		return compare(left.left, right.right) && compare(left.right, right.left);
	}*/

	/**
	 *  思路: 迭代法(队列)
	 *  1. 通过队列判断根节点的左子树和右子树的外侧和内侧是否相等
	 *  2. 出队的时候要同时出两个节点
	 *  3. 出队的时候同时入队当前节点的左节点的左节点和右节点的右节点
	 *             以及当前节点的左节点的右节点和右节点的左节点
	 *
	 */
	public boolean isSymmetric(TreeNode root) {
		if(root == null) {
			return true;
		}

		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root.left);
		queue.offer(root.right);

		while(!queue.isEmpty()) {
			TreeNode left = queue.poll();
			TreeNode right = queue.poll();
			if(left == null && right == null) {
				continue;
			} else if(left == null || right == null) {
				return false;
			} else if(left.val != right.val) {
				return false;
			}
			queue.offer(left.left);
			queue.offer(right.right);
			queue.offer(left.right);
			queue.offer(right.left);
		}

		return true;
	}
}
