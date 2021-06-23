package 二叉树.求二叉搜索树的属性;

/**
 * @ClassName: TreeNode
 * @Author: whc
 * @Date: 2021/06/20/13:05
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
