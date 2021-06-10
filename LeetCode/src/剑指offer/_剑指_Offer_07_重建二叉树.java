package 剑指offer;

import java.util.HashMap;

/**
 * @ClassName: _剑指_Offer_07_重建二叉树
 * @Author: whc
 * @Date: 2021/05/22/10:38
 */
public class _剑指_Offer_07_重建二叉树 {

	/**
	 *  思路: 递归
	 *  1. 取前序遍历的第一个元素作为根节点
	 *  2. 先切割中序数组,根据根节点查找中序数组中的位置,切割成中序左数组[i_start,i_root_index)和中序右数组[i_root_index+1,i_end)   【左闭右开】
	 *  3. 再切割前序数组,根据中序数组中左数组的长度进行切割,切割成前序左数组[p_start+1, p_start+1+(i_root_index-i_start))和前序右数组[p_start+1+(i_root_index-i_start),p_end)
	 */

	// 存储前序遍历中的根节点在中序遍历的下标位置
	HashMap<Integer, Integer> map = new HashMap<>();
	public TreeNode buildTree(int[] preorder, int[] inorder) {

		// 初始化赋值
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}

		// 左闭右开区间
		return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
	}

	public TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
		// 递归终止条件,前序数组遍历完,直接返回null
		if(p_start == p_end) {
			return null;
		}

		int root_val = preorder[p_start];
		// 中序数组中根节点的下标位置, 根据此下标划分中序数组中的 中序左数组 和 中序右数组
		int i_root_index = map.get(root_val);
		// 构建根节点
		TreeNode root = new TreeNode(root_val);
		// 递归构造左子树
		root.left = buildTreeHelper(preorder, p_start+1, p_start + 1 + (i_root_index-i_start), inorder, i_start, i_root_index);
		// 递归构造右子树
		root.right = buildTreeHelper(preorder, p_start+1+(i_root_index-i_start), p_end, inorder, i_root_index+1, i_end);

		return root;
	}

}
