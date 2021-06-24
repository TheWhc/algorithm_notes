package 二叉树.二叉搜索树的修改与构造;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _669_修剪二叉搜索树
 * @Author: whc
 * @Date: 2021/06/24/12:58
 */
public class _669_修剪二叉搜索树 {


	/**
	 * 思路: 递归法
	 * 1. 递归函数的返回值以及参数的含义
	 * TreeNode trimBST(TreeNode root, int low, int high)
	 * 2. 递归终止条件
	 * if(root == null) {
	 *     return null;
	 * }
	 * 3. 单层递归逻辑
	 * 如果当前节点 < low, 说明应该返回递归删除后的右子树
	 * 如果当前节点 > high, 说明应该返回递归删除后的左子树
	 *
	 * 如果当前节点值范围在[low,high],则root.left = 递归删除后的左子树, root.right = 递归删除后的右子树,然后返回根节点
	 *
	 */
	public TreeNode trimBST(TreeNode root, int low, int high) {
		if(root == null) {
			return null;
		}

		// 删除不在[low.high]范围的节点,因为当前节点比low还要小,说明[low,high]都在右子树中, 所以返回当前节点进入递归的右子树
		if(root.val < low) {
			return trimBST(root.right, low, high);
		} else if(root.val > high) {
			// 删除不在[low.high]范围的节点,因为当前节点比high还要大,说明[low,high]都在左子树中, 所以返回当前节点进入递归的左子树
			return trimBST(root.left, low, high);
		}

		// root在[low,high]范围内
		root.left = trimBST(root.left, low, high);
		root.right = trimBST(root.right, low, high);

		return root;
	}

}
