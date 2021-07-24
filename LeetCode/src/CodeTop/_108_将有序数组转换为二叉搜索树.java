package CodeTop;

/**
 * @ClassName: _108_将有序数组转换为二叉搜索树
 * @Author: whc
 * @Date: 2021/07/24/9:37
 */
public class _108_将有序数组转换为二叉搜索树 {

	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums == null || nums.length == 0) {
			return null;
		}

		return buildTree(nums, 0, nums.length-1);
	}

	private TreeNode buildTree(int[] nums, int start, int end) {
		if(start > end) {
			return null;
		}

		int rootIdx = start + (end - start) / 2;
		int rootVal = nums[rootIdx];

		TreeNode root = new TreeNode(rootVal);
		// 递归构建左子树
		TreeNode left = buildTree(nums, start, rootIdx-1);
		// 递归构建右子树
		TreeNode right = buildTree(nums, rootIdx+1, end);
		root.left = left;
		root.right = right;
		return root;
	}
}
