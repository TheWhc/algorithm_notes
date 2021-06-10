package 待分类;

import java.util.LinkedList;

/**
 * @ClassName: 待分类._958_二叉树的完全性检验
 * @Author: whc
 * @Date: 2021/03/23/22:06
 */
public class _958_二叉树的完全性检验 {

	// 层序遍历
	public boolean isCompleteTree(TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		TreeNode pre = root;
		while(!queue.isEmpty()) {
			TreeNode node = queue.pop();
			if(node != null && pre == null) {
				return false;
			}
			if(node != null) {
				queue.add(node.left);
				queue.add(node.right);
			}
			pre = node;
		}
		return true;
	}

}
