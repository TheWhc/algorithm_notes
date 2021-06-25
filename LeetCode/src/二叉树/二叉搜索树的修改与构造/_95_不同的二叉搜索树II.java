package 二叉树.二叉搜索树的修改与构造;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _95_不同的二叉搜索树II
 * @Author: whc
 * @Date: 2021/06/25/17:42
 */
public class _95_不同的二叉搜索树II {

	/**
	 * 思路: 递归法
	 * 1. 确定递归函数和返回值
	 * List<TreeNode> helper(int start, int end)
	 * start表示左边界值,end表示右边界值
	 *
	 * 2. 确定递归终止条件
	 * if(start > end) {
	 *     // 防止后面在构建以i为根节点的二叉搜索树时无法构建
	 * 	    list.add(null);
	 * 		return list;
	 * }
	 *
	 * 3. 单层递归逻辑
	 *  - 递归构建得到左节点集合
	 *  - 递归构建得到右节点集合
	 *  - 固定左节点集合,遍历右节点集合,依次构建二叉搜索树
	 */
	public List<TreeNode> generateTrees(int n) {
		return helper(1, n);
	}

	private List<TreeNode> helper(int start, int end) {
		List<TreeNode> list = new ArrayList<>();

		// 递归终止条件
		if(start > end) {
			// 防止后面在构建以i为根节点的二叉搜索树时无法构建
			list.add(null);
			return list;
		}

		for (int i = start; i <= end; i++) {
			// 得到以i为根节点的左孩子集合
			List<TreeNode> left = helper(start, i-1);
			// 得到以i为根节点的右孩子集合
			List<TreeNode> right = helper(i+1, end);
			// 比如当i= 1时,左孩子节点集合为{},右孩子节点集合为{2,3}
			// 当i=2时,左孩子节点集合为{1},右孩子节点集合为{3}

			// 构建以i为根节点的二叉搜索树
			// 固定左孩子 遍历右孩子
			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					list.add(root);
				}
			}
		}

		return list;
	}
}
