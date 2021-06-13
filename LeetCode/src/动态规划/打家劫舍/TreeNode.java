package 动态规划.打家劫舍;

/**
 * @ClassName: TreeNode
 * @Author: whc
 * @Date: 2021/06/13/12:20
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
