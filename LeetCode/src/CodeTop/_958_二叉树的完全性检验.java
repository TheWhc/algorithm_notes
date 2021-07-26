package CodeTop;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: _958_二叉树的完全性检验
 * @Author: whc
 * @Date: 2021/07/26/16:54
 */
public class _958_二叉树的完全性检验 {

	// 层序遍历
	public boolean isCompleteTree(TreeNode root) {
		if(root == null) {
			return false;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		TreeNode pre = root;
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			while(levelSize > 0) {
				TreeNode cur = queue.poll();
				if(cur != null && pre == null) {
					return false;
				}
				pre = cur;
				if(cur != null) {
					queue.offer(cur.left);
					queue.offer(cur.right);
				}
				levelSize--;
			}
		}

		return true;
	}
}
