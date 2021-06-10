package 二叉树;

import java.util.LinkedList;

/**
 * @ClassName: _513_找树左下角的值
 * @Author: whc
 * @Date: 2021/04/18/15:18
 */
public class _513_找树左下角的值 {

	// 层序遍历
	/*public int findBottomLeftValue(TreeNode root) {
		int res = root.val;
		LinkedList<TreeNode> queue = new LinkedList();
		queue.add(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			res = queue.peek().val;
			while(size > 0) {
				TreeNode node = queue.pop();
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
				size--;
			}
		}
		return res;
	}*/

	int maxLen = Integer.MIN_VALUE; // 记录最大深度
	int maxLeftValue; // 记录最大深度最左节点的数值
	public int findBottomLeftValue(TreeNode root) {
		traversal(root, 0);
		return maxLeftValue;
	}

	private void traversal(TreeNode root, int leftLen) {
		if(root == null) {
			return;
		}
		// 递归终止条件
		if(root.left == null && root.right == null) {
			if(leftLen > maxLen) {
				maxLen = leftLen;
				maxLeftValue = root.val;
			}
			return;
		}

		// 确定单层递归逻辑
		traversal(root.left, leftLen+1);
		traversal(root.right, leftLen+1);
	}

}
