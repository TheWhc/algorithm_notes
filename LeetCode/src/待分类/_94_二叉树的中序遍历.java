package 待分类;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: 待分类._94_二叉树的中序遍历
 * @Author: whc
 * @Date: 2021/03/04/12:11
 */
public class _94_二叉树的中序遍历 {
	/*List<Integer> res = new ArrayList<>();
	public List<Integer> inorderTraversal(TreeNode root) {
		dfs(root);
		return res;
	}

	// 左根右
	public void dfs(TreeNode node) {
		if(node == null)
			return;
		dfs(node.left);
		res.add(node.val);
		dfs(node.right);
	}*/

	// 迭代法
	// 跟前序遍历不同, 因为处理顺序和访问顺序不一样, 所以需要借助指针来帮助访问节点,栈用来处理节点上的元素
	public List<Integer> inorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		TreeNode cur = root;
		while(cur != null || !stack.isEmpty()) {
			if(cur != null) {
				stack.push(cur);
				cur = cur.left; // 左
			} else {
				cur = stack.pop();
				list.add(cur.val); // 根
				cur = cur.right; // 右
			}
		}
		return list;
	}
}
