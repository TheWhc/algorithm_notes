package CodeTop;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _剑指_Offer_07_重建二叉树
 * @Author: whc
 * @Date: 2021/09/15/17:57
 */
public class _剑指_Offer_07_重建二叉树 {

	/**
	 * 中序数组左数组范围[in_start, root_idx-1], 右数组范围[root_idx+1, in_end]
	 * 前序数组左数组范围[pre_start + 1, pre_start + root_idx-in_start], 右数组范围[pre_start + root_idx-in_start+1, pre_end]
	 */
	Map<Integer, Integer> map = new HashMap<>();
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
			return null;
		}
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return helpBuild(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
	}

	private TreeNode helpBuild(int[] preorder, int pre_start, int pre_end, int[] inorder, int in_start, int in_end) {
		if(pre_end < pre_start) {
			return null;
		}

		int root_idx = map.get(preorder[pre_start]);
		TreeNode root = new TreeNode(preorder[pre_start]);
		// 递归构建左子树
		root.left = helpBuild(preorder, pre_start + 1, pre_start + root_idx-in_start, inorder, in_start, root_idx-1);
		root.right = helpBuild(preorder, pre_start + root_idx-in_start+1, pre_end, inorder, root_idx+1, in_end);
		return root;
	}
}
