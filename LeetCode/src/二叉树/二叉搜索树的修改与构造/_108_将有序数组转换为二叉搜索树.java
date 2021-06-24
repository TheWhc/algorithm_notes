package 二叉树.二叉搜索树的修改与构造;

/**
 * @ClassName: _108_将有序数组转换为二叉搜索树
 * @Author: whc
 * @Date: 2021/06/24/14:18
 */
public class _108_将有序数组转换为二叉搜索树 {

	/**
	 * 思路: 递归法
	 * 1. 确定递归函数以及参数的含义
	 * TreeNode buildTree(int[] nums, int left, int right)
	 * nums:待构建的数组
	 * left:左边界
	 * right:右边界
	 * 返回值为TreeNode,根据返回值做进一步的逻辑
	 *
	 * 2. 递归终止条件
	 * 左边界大于右边界时,返回null
	 *
	 * 3. 单层递归逻辑
	 *	构建中间节点元素为根节点,然后递归构建左子树[left,mid-1]和右子树[mid+1, right]
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
		return buildTree(nums, 0, nums.length-1);
	}

	private TreeNode buildTree(int[] nums, int left, int right) {
		if(left > right) {
			return null;
		}

		// 如果只剩下两个元素,则取左边的元素
		int mid = left + (right - left) / 2;
		// 构建中间元素为根节点,因为默认都是从数组中间元素取值作为根节点元素
		TreeNode root = new TreeNode(nums[mid]);
		root.left = buildTree(nums, left, mid-1);
		root.right = buildTree(nums, mid+1, right);
		return root;
	}
}
