package CodeTop;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _106_从中序与后序遍历序列构造二叉树
 * @Author: whc
 * @Date: 2021/09/09/21:38
 */
public class _106_从中序与后序遍历序列构造二叉树 {

	Map<Integer, Integer> map = new HashMap<>();
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder == null || postorder == null) {
			return null;
		}
		
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}

		return helpBuild(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
	}

	/**
	 * 左闭右闭
	 * 中序数组左区间 [in_start, rootIdx-1], 右区间[rootIdx+1, in_end]
	 * 后序数组左区间 [post_start, post_start + rootIdx - in_start - 1], 右区间[post_start + rootIdx - in_start, post_end - 1]
	 */
	private TreeNode helpBuild(int[] inorder, int in_start, int in_end, int[] postorder, int post_start, int post_end) {
		if(in_end < in_start || post_end < post_start) {
			return null;
		}

		// 构造根节点
		TreeNode root = new TreeNode(postorder[post_end]);

		// 在中序数组中找到根节点的下标
		int rootIdx = map.get(postorder[post_end]);

		// 递归构建左子树和右子树
		root.left = helpBuild(inorder, in_start, rootIdx-1, postorder, post_start, post_start + rootIdx - in_start - 1);
		root.right = helpBuild(inorder, rootIdx+1, in_end, postorder, post_start + rootIdx - in_start, post_end -1);

		return root;
	}
}
