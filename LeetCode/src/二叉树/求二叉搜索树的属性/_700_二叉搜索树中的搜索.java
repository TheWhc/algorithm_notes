package 二叉树.求二叉搜索树的属性;

import java.util.LinkedList;

/**
 * @ClassName: _700_二叉搜索树中的搜索
 * @Author: whc
 * @Date: 2021/06/23/13:38
 */
public class _700_二叉搜索树中的搜索 {

	/**
	 *  思路: 递归
	 *  1. 确定递归函数返回值和参数的含义
	 *  TreeNode searchBST(TreeNode root, int val)
	 *  root: 当前节点
	 *  val: 目标值
	 *  2. 确定递归终止条件
	 *  if(root == null) {
	 *      return null
	 *  }
	 *  3. 单层递归逻辑
	 *   如果当前节点值 小于 目标值, 则递归搜索二叉搜索树的右子树
	 *   如果当前节点值 大于 目标值, 则递归搜索二叉搜索树的左子树
	 *   如果当前节点值 等于 目标值, 则返回当前节点值
	 */
	/*public TreeNode searchBST(TreeNode root, int val) {
		if(root == null) {
			return null;
		}

		if(root.val < val) {
			return searchBST(root.right, val);
		} else if(root.val > val){
			return searchBST(root.left, val);
		} else {
			return root;
		}
	}*/

	/**
	 * 思路: 迭代法
	 * 层序遍历
	 */
	/*public TreeNode searchBST(TreeNode root, int val) {
		if(root == null) {
			return null;
		}
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			while(levelSize > 0) {
				TreeNode node = queue.poll();
				if(node.val == val) {
					return node;
				}
				if(node.left != null) {
					queue.offer(node.left);
				}
				if(node.right != null) {
					queue.offer(node.right);
				}
				levelSize--;
			}
		}

		return null;
	}*/

	/**
	 * 思路: 迭代法
	 * 根据二叉搜索树的特点
	 * 左子树的值比根节点值小
	 * 右子树的值比根节点值大
	 */
	public TreeNode searchBST(TreeNode root, int val) {
		while(root != null) {
			if(root.val > val) {
				root = root.left;
			}else if(root.val < val) {
				root = root.right;
			} else {
				return root;
			}
		}
		return null;
	}
}
