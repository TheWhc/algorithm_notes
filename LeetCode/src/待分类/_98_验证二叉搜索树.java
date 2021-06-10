package 待分类;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: 待分类._98_验证二叉搜索树
 * @Author: whc
 * @Date: 2021/03/20/21:02
 */
public class _98_验证二叉搜索树 {
	/*List<Integer> list = new ArrayList<>();
	public boolean isValidBST(TreeNode root) {
		dfs(root);
		Integer[] array = list.toArray(new Integer[list.size()]);
		for (int i = 1; i < array.length; i++) {
			if(array[i] <= array[i-1]) {
				return false;
			}
		}
		return true;
	}

	private void dfs(TreeNode root) {
		if(root == null)
			return;
		dfs(root.left);
		list.add(root.val);
		dfs(root.right);
	}*/


	/*TreeNode pre;
	// 中序遍历
	// 判断当前节点是否大于中序遍历的前一个节点，也就是判断是否有序，如果不大于直接返回 false。
	public boolean isValidBST(TreeNode root) {
		if(root == null)
			return true;
		// 访问左子树
		if(!isValidBST(root.left))
			return false;
		// 访问当前节点
		if(pre != null && pre.val >= root.val) {
			return false;
		}
		pre = root;
		if(!isValidBST(root.right))
			return false;
		return true;
	}*/

	// 中序遍历
	long maxVal = Long.MIN_VALUE;
	public boolean isValidBST(TreeNode root) {
		if(root == null)
			return true;
		// 访问左子树
		boolean left = isValidBST(root.left);
		// 中序遍历,验证遍历的元素是否从小到大
		if(maxVal < root.val) {
			maxVal = root.val;
		} else {
			return false;
		}
		boolean right = isValidBST(root.right);
		return left && right;
	}

}
