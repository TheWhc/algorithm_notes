package CodeTop;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _105_从前序与中序遍历序列构造二叉树
 * @Author: whc
 * @Date: 2021/07/24/9:21
 */
public class _105_从前序与中序遍历序列构造二叉树 {

	Map<Integer, Integer> map = new HashMap<>();
	public TreeNode buildTree(int[] preorder, int[] inorder) {

		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}

		return helpBuild(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
	}

	private TreeNode helpBuild(int[] preorder, int pre_start, int pre_end, int[] inorder, int in_start, int in_end) {
		if(pre_start > pre_end) {
			return null;
		}
		int rootVal = preorder[pre_start];
		int rootIdx = map.get(rootVal);

		// 构建根节点
		TreeNode root = new TreeNode(rootVal);

		// 递归构建左子树
		TreeNode left = helpBuild(preorder, pre_start+1, pre_start + rootIdx - in_start, inorder, in_start, rootIdx -1);
		// 递归构建右子树
		TreeNode right = helpBuild(preorder, pre_start + rootIdx - in_start + 1, pre_end, inorder, rootIdx + 1, in_end);

		root.left = left;
		root.right = right;
		return root;
	}
}
