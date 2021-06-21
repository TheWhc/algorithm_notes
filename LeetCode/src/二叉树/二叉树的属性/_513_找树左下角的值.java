package 二叉树.二叉树的属性;

import java.util.LinkedList;

/**
 * @ClassName: _513_找树左下角的值
 * @Author: whc
 * @Date: 2021/06/21/16:57
 */
public class _513_找树左下角的值 {

	/**
	 *  思路: 递归法
	 *  1. 确定递归函数以及参数的含义
	 *		void findLeftValue(TreeNode root, int leftLen)
	 *	 因为要遍历整颗二叉树,所以不需要返回值
	 *	 一直向左遍历到最后一个,未必是最后一行
	 *
	 *	 参数root: 当前节点
	 *	 参数leftLen: 当前节点深度
	 *
	 *  2. 确定递归终止条件
	 *	 如果节点为空时,直接返回
	 *
	 *  3. 单层递归逻辑
	 *   按照前序遍历的逻辑, 根左右, 因为需要父节点判断节点是不是叶子节点,  而前序遍历刚好满足
	 *   且会先遍历左子树, 通过在单层逻辑的控制, 可以保证最先得到的是最左边的节点
	 *   然后再通过节点的深度进行判断是不是最后一行,更新对应的最大深度和最大深度对应的最左下角的值
	 */
	int maxLen;
	int maxLeftValue;
	public int findBottomLeftValue(TreeNode root) {
		maxLen = 0;
		maxLeftValue = root.val;
		findLeftValue(root, 0);
		return maxLeftValue;
	}

	private void findLeftValue(TreeNode root, int leftLen) {
		if(root == null) {
			return;
		}

		// 根
		// 单层递归逻辑
		// 当前是叶子节点,进入下一步的判断
		if(root.left == null && root.right == null) {
			// 如果当前节点深度大于最大深度,则更新深度和左下角的值
			// 如果当前节点深度等于最大深度,则不更新,因为要的是左下角的值
			if(leftLen > maxLen) {
				maxLeftValue = root.val;
				maxLen = leftLen;
			}
		}

		// 单层递归逻辑
		// 左  深度+1, 包含回溯的逻辑
		findLeftValue(root.left, leftLen + 1);
		// 右  深度+1, 包含回溯的逻辑
		findLeftValue(root.right, leftLen + 1);
	}

	/**
	 *  思路: 迭代法
	 *  层序遍历
	 */
	/*public int findBottomLeftValue(TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int leftVal = 0;
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			leftVal = queue.peekFirst().val;
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
		}

		return leftVal;
	}*/
}
