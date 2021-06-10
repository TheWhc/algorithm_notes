package 待分类;

/**
 * @ClassName: 待分类._108_将有序数组转换为二叉搜索树
 * @Author: whc
 * @Date: 2021/03/12/14:12
 */
public class _108_将有序数组转换为二叉搜索树 {
	public TreeNode sortedArrayToBST(int[] nums) {
		return dfs(nums, 0, nums.length-1);
	}

	private TreeNode dfs(int[] nums, int left, int right) {
		if(left > right)
			return null;

		int mid = left + (right - left) / 2;
		// 升序数组的中间元素作为根节点（高度平衡）
		TreeNode root = new TreeNode(nums[mid]);
		root.left = dfs(nums, left, mid-1);
		root.right = dfs(nums, mid+1, right);
		return root;
	}

}
