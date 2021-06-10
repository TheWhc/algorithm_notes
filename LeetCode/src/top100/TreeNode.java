package top100;

/**
 * @ClassName: TreeNode
 * @Author: whc
 * @Date: 2021/05/08/10:25
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
