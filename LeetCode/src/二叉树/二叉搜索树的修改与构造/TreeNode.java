package 二叉树.二叉搜索树的修改与构造;

/**
 * @ClassName: TreeNode
 * @Author: whc
 * @Date: 2021/06/21/9:56
 */
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
