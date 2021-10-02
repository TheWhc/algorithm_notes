package cvte;

/**
 * @ClassName: cvte.TreeNode
 * @Author: whc
 * @Date: 2021/10/01/8:51
 */
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode() {

	}

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
