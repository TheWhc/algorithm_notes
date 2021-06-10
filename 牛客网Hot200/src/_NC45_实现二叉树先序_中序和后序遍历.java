import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _NC45_实现二叉树先序_中序和后序遍历
 * @Author: whc
 * @Date: 2021/01/26/11:33
 */
public class _NC45_实现二叉树先序_中序和后序遍历 {

	List<Integer> pre = new ArrayList<>();
	List<Integer> in = new ArrayList<>();
	List<Integer> after = new ArrayList<>();

	public int[][] threeOrders (TreeNode root) {
		// write code here

		preOrder(root);
		inOrder(root);
		afterOrder(root);

		int[][] res = new int[3][pre.size()];
		for (int i = 0; i < pre.size(); i++) {
			res[0][i] = pre.get(i);
			res[1][i] = in.get(i);
			res[2][i] = after.get(i);
		}

		return res;
	}

	// 先序遍历: 根左右
	private void preOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		pre.add(root.val);
		preOrder(root.left);
		preOrder(root.right);
	}

	// 中序遍历: 左根右
	private void inOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		inOrder(root.left);
		in.add(root.val);
		inOrder(root.right);
	}

	// 后序遍历: 左右根
	private void afterOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		afterOrder(root.left);
		afterOrder(root.right);
		after.add(root.val);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		new _NC45_实现二叉树先序_中序和后序遍历().threeOrders(root);
	}
}
