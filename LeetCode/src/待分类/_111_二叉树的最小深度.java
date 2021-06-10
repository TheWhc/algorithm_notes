package 待分类;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: 待分类._111_二叉树的最小深度
 * @Author: whc
 * @Date: 2021/03/17/19:55
 */
public class _111_二叉树的最小深度 {

	// 递归
	/*public int minDepth(TreeNode root) {
		return getDepth(root);
	}

	// 遍历顺序上依然是后序遍历（因为要比较递归返回之后的结果)
	private int getDepth(TreeNode root) {
		if(root == null)
			return 0;

		// 左
		int leftDepth = getDepth(root.left);
		// 右
		int rightDepth = getDepth(root.right);
		if(root.left == null && root.right != null) {
			return rightDepth+1;
		}
		if(root.right == null && root.left != null) {
			return leftDepth + 1;
		}

		return Math.min(leftDepth, rightDepth) + 1;
	}*/


	// 迭代法, 层序遍历
	public int minDepth(TreeNode root) {
		if(root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int count = 0;
		int depth = 0;
		int flag = 0;
		while(!queue.isEmpty()){
			count = queue.size();
			depth++;
			while(count > 0) {
				TreeNode node = queue.poll();
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
				if(node.left == null && node.right == null) {
					flag = 1;
					break;
				}
				count--;
			}
			if(flag == 1) {
				break;
			}
		}
		return depth;
	}

}
