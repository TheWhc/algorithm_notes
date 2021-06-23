package 二叉树.求二叉搜索树的属性;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName: _98_验证二叉搜索树
 * @Author: whc
 * @Date: 2021/06/23/13:53
 */
public class _98_验证二叉搜索树 {

	/**
	 *  思路: 递归
	 *  注意点: 不能简单的按照根节点值大于左子树的根节点的值,且小于右子树的根节点的值
	 *  因为有可能出现如下情况：
	 *  	5
	 *     / \
	 *    4  6
	 *      / \
	 *     3  7
	 *
	 *     3不可能大于5,然而却返回true
	 *
	 *  所以应该按照中序遍历的顺序进行判断节点值的大小关系
	 *
	 *  1. 确定递归函数返回值以及参数含义
	 *  boolean isValidBST(TreeNode root)
	 *  返回值为boolean, 因为一旦遇到不满足的条件就立即返回了,不需要遍历整颗二叉树
	 *  root: 当前节点
	 *
	 *  2. 确定递归终止条件
	 *  if(root == null) {
	 *      return true;
	 *  }
	 *
	 *  3. 单层递归逻辑
	 *  按照中序遍历的顺序, 先递归左子树, 然后判断当前节点值是否大于前一个节点值, 最后递归右子树
	 */

	/*TreeNode pre; // 记录前一个节点
	public boolean isValidBST(TreeNode root) {
		// 递归终止条件
		if(root == null) {
			return true;
		}

		// 单层递归逻辑
		// 左
		boolean left = isValidBST(root.left);
		if(!left) {
			return false;
		}
		// 根
		if(pre != null && pre.val >= root.val) {
			return false;
		}
		pre = root;

		// 右
		boolean right = isValidBST(root.right);

		return right;
	}*/

	/**
	 *  思路: 迭代法
	 *  (中序遍历的迭代法)
	 *	1. 因为中序遍历的元素的访问顺序和要处理的顺序不一致,所以要设置一个辅助指针帮助访问节点
	 *  2. 栈不为空 或者 当前节点指针cur 不为空的时候, 就一直遍历
	 *  3. 当前节点指针cur不为空时, 将当前节点入栈, cur指向当前节点的左节点(如果有左节点,再下一次的时候左节点就能入栈了）
	 *  4. 当前节点指针cur为空时, 当栈的元素出栈, cur指向出栈元素的右节点(如果有右节点,再下一次的时候右节点就能入栈了)
	 *  		出栈的同时,判断和前一个节点的值是否符合二叉搜索树的定义
	 */
	TreeNode pre = null; // 记录前一个节点
	public boolean isValidBST(TreeNode root) {
		if(root == null) {
			return true;
		}

		TreeNode cur = root;
		Stack<TreeNode> stack = new Stack<>();
		while(!stack.isEmpty() || cur != null) {
			if(cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else{
				TreeNode node = stack.pop();
				if(pre != null && pre.val >= node.val) {
					return false;
				}
				pre = node;
				cur = node.right;
			}
		}

		return true;
	}

	/**
	 * 思路: 将二叉搜索树转化为数组(列表)
	 * 1. 按照中序遍历的递归法,将二叉搜索树的节点值添加到list中
	 * 2. 遍历列表值,判断是不是满足后面值大于前面值
	 */
	/*private List<Integer> list = new ArrayList<>();
	public boolean isValidBST(TreeNode root) {
		dfs(root);
		for (int i = 1; i < list.size(); i++) {
			if(list.get(i) <= list.get(i-1)) {
				return false;
			}
		}
		return true;
	}

	private void dfs(TreeNode root) {
		if(root == null) {
			return;
		}
		dfs(root.left);
		list.add(root.val);
		dfs(root.right);
	}*/
}
