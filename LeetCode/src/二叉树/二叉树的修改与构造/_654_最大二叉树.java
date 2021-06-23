package 二叉树.二叉树的修改与构造;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _654_最大二叉树
 * @Author: whc
 * @Date: 2021/06/23/12:11
 */
public class _654_最大二叉树 {

	/**
	 * 思路: 递归
	 * 1. 找到数组最大值和最大值下标
	 * 2. 构造最大值为根节点,然后递归构造最最大值的左子树和右子树
	 *
	 */
	/*public TreeNode constructMaximumBinaryTree(int[] nums) {

		// 递归终止条件
		if(nums.length == 1) {
			return new TreeNode(nums[0]);
		}

		// 单层递归逻辑
		int maxIndex = 0;
		int maxValue = nums[maxIndex];
		for (int i = 1; i < nums.length; i++) {
			if(nums[i] > maxValue) {
				maxIndex = i;
				maxValue = nums[i];
			}
		}

		TreeNode root = new TreeNode(maxValue);
		root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIndex));
		root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIndex+1, nums.length));

		return root;
	}*/

	/**
	 * 思路: 递归划分
	 * 1. 递归函数的返回值以及参数的含义
	 * TreeNode constructMaximumBinaryTree(int[] nums, int left, int right)
	 * nums: 数组
	 * left: 需要构建二叉树的数组左边界
	 * right: 需要构建二叉树的数组右边界
	 *
	 * 2. 递归终止条件
	 * 	 如果right > left, 则返回null
	 *
	 * 3. 单层递归逻辑
	 *   找到最大值和最大值下标
	 *   以最大值作为根节点,然后递归构建节点的左子树和右子树
	 */
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return constructMaximumBinaryTree(nums, 0, nums.length-1);
	}

	private TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
		if(right < left) {
			return null;
		}

		int maxValue = nums[left];
		int maxIndex = left;

		for (int i = left+1; i <= right; i++) {
			if(nums[i] > maxValue) {
				maxIndex = i;
				maxValue = nums[i];
			}
		}

		TreeNode root = new TreeNode(maxValue);

		root.left = constructMaximumBinaryTree(nums, left, maxIndex-1);
		root.right = constructMaximumBinaryTree(nums, maxIndex+1, right);

		return root;
	}
}
