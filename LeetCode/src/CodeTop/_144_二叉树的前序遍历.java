package CodeTop;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: _144_二叉树的前序遍历
 * @Author: whc
 * @Date: 2021/07/22/16:40
 */
public class _144_二叉树的前序遍历 {

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			res.add(node.val);
			if(node.right != null) {
				stack.add(node.right);
			}
			if(node.left != null) {
				stack.add(node.left);
			}
		}

		return res;
	}
}
