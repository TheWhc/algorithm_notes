package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: 剑指offer._剑指_Offer_28_对称的二叉树
 * @Author: whc
 * @Date: 2021/04/02/13:01
 */
public class _剑指_Offer_28_对称的二叉树 {

	/**
	 *  思路: 递归
	 *  1. dfs如果两个节点都不存在,返回true
	 *  2. 如果有一个节点不存在而另一个节点存在 或者 两个节点值不相同,返回false
	 *  3. 递归进入左子树的左节点和右子树的右节点,以及左子树的右节点和右子树的左节点比较
	 *
	 *  时间: O(n)
	 *  空间: O(n)
	 */
	/*public boolean isSymmetric(TreeNode root) {
		if(root == null)
			return true;
		return dfs(root.left, root.right);
	}

	private boolean dfs(TreeNode left, TreeNode right) {
		if(left == null && right == null) {
			return true;
		}
		if(left == null || right == null || left.val != right.val) {
			return false;
		}
		return dfs(left.left, right.right) && dfs(left.right, right.left);
	}*/

	/**
	 * 思路: 迭代法
	 * 1. 维护两个队列q1,q2
	 * 2. 把root的左节点加入q1,右节点加入q2
	 *
	 * 时间: O(n)
	 * 空间: O(n)
	 */
	public boolean isSymmetric(TreeNode root) {
		if(root == null) {
			return true;
		}
		Queue<TreeNode> queue1 = new LinkedList<>();
		Queue<TreeNode> queue2 = new LinkedList<>();
		queue1.offer(root.left);
		queue2.offer(root.right);
		while(!queue1.isEmpty() && !queue2.isEmpty()) {
			TreeNode node1 = queue1.poll();
			TreeNode node2 = queue2.poll();
			if(node1 == null && node2 == null)
				continue;
			if(node1 == null || node2 == null || node1.val != node2.val) {
				return false;
			}
			queue1.offer(node1.left);
			queue1.offer(node1.right);
			queue2.offer(node2.right);
			queue2.offer(node2.left);
		}
		return true;
	}


}
