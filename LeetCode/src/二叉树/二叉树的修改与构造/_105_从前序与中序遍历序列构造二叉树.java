package 二叉树.二叉树的修改与构造;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _105_从前序与中序遍历序列构造二叉树
 * @Author: whc
 * @Date: 2021/06/23/11:47
 */
public class _105_从前序与中序遍历序列构造二叉树 {

	/**
	 * 思路: 递归构建
	 *  区间按照左闭右闭原则
	 *	1. 取前序数组的第一个元素作为根节点,然后找到根节点在中序数组对应的位置,先划分中序数组左数组 和 右数组区间
	 *  2. 然后再划分前序数组中的左数组区间和右数组区间
	 *  3. 然后以1,2得到的数组区间递归构建根节点的左子树和右子树,最后返回根节点
	 *
	 * 中序数组左数组区间[in_start, in_root_index-1], 右数组区间[in_root_index+1, in_end]
	 * 前序数组左数组区间[pre_start+1, pre_start + in_root_index - in_start], 右数组区间[pre_start + in_root_index - in_start + 1, pre_end]
	 */
	Map<Integer, Integer> map = new HashMap<>();
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder == null || inorder == null) {
			return null;
		}

		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}

		return helpBuild(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);

	}

	private TreeNode helpBuild(int[] preorder, int pre_start, int pre_end, int[] inorder, int in_start, int in_end) {
		if(pre_end < pre_start || in_end < in_start) {
			return null;
		}

		int in_root_index = map.get(preorder[pre_start]);
		TreeNode root = new TreeNode(preorder[pre_start]);

		root.left = helpBuild(preorder, pre_start+1, pre_start + in_root_index - in_start, inorder, in_start, in_root_index-1);
		root.right = helpBuild(preorder, pre_start + in_root_index - in_start + 1, pre_end, inorder, in_root_index+1, in_end);

		return root;
	}
}
