package 二叉树.二叉树的修改与构造;

/**
 * @ClassName: _617_合并二叉树
 * @Author: whc
 * @Date: 2021/06/23/13:23
 */
public class _617_合并二叉树 {

	/**
	 * 思路: 递归
	 * 修改树的结构
	 *  1. 确定递归函数的参数和返回值：
	 *   	TreeNode mergeTrees(TreeNode root1, TreeNode root2)
	 *  2. 确定终止条件
	 * 		if(root1 == null) return root2;
	 *  	if(root2 == null) return root1;
	 *
	 *  3. 确定单层递归逻辑
	 *  	合并到root1的节点中
	 */
	/*public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		if(root1 == null) {
			return root2;
		}
		if(root2 == null) {
			return root1;
		}
		root1.val += root2.val;
		root1.left = mergeTrees(root1.left, root2.left);
		root1.right = mergeTrees(root1.right, root2.right);

		return root1;
	}*/

	/**
	 *  思路: 递归
	 *  不修改树的结构
	 */
	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		if(root1 == null) {
			return root2;
		}
		if(root2 == null) {
			return root1;
		}
		TreeNode root = new TreeNode(root1.val + root2.val);
		root.left = mergeTrees(root1.left, root2.left);
		root.right = mergeTrees(root1.right, root2.right);

		return root;
	}

}
