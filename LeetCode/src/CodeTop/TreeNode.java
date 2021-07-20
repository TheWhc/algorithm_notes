package CodeTop;

/**
 * @ClassName: TreeNode
 * @Author: whc
 * @Date: 2021/07/20/14:33
 */
public class TreeNode {

	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {

	}
	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
