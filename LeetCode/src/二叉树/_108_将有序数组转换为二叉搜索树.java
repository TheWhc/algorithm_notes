package 二叉树;

/**
 * @ClassName: 待分类._108_将有序数组转换为二叉搜索树
 * @Author: whc
 * @Date: 2021/04/22/14:12
 */
public class _108_将有序数组转换为二叉搜索树 {

	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums == null || nums.length == 0) return null;

		return helper(nums, 0, nums.length-1);
	}

	private TreeNode helper(int[] nums, int start, int end) {
		if(start > end) return null;

		// 中间结点作为根节点
		int mid = (start + end) >> 1;
		int rootVal = nums[mid];
		TreeNode root = new TreeNode(rootVal);
		root.left = helper(nums, start, mid-1);
		root.right = helper(nums, mid + 1, end);

		return root;
	}
}
