package 待分类;

import java.util.HashMap;

/**
 * @ClassName: 待分类._337_打家劫舍_III
 * @Author: whc
 * @Date: 2021/04/10/12:59
 */
public class _337_打家劫舍_III {

	// 时间O(n) 空间O(n)
	/*HashMap<TreeNode, Integer> memo = new HashMap<>();

	public int rob(TreeNode root) {
		if(memo.containsKey(root))
			return memo.get(root);
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return root.val;
		// 偷父节点,不偷子节点
		int val1 = root.val;
		if(root.left != null) {
			val1 += rob(root.left.left) + rob(root.left.right);
		}
		if(root.right != null) {
			val1 += rob(root.right.left) + rob(root.right.right);
		}

		// 不偷父节点,偷子节点
		int val2 = rob(root.left) + rob(root.right);
		memo.put(root, Math.max(val1, val2));
		return Math.max(val1, val2);
	}*/



	/*// 暴力递归 超时
	public int rob(TreeNode root) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return root.val;
		// 偷父节点,不偷子节点
		int val1 = root.val;
		if(root.left != null) {
			val1 += rob(root.left.left) + rob(root.left.right);
		}
		if(root.right != null) {
			val1 += rob(root.right.left) + rob(root.right.right);
		}

		// 不偷父节点,偷子节点
		int val2 = rob(root.left) + rob(root.right);

		return Math.max(val1, val2);
	}*/

	// 动态规划 + 递归
	public int rob(TreeNode root) {
		int[] res = help(root);
		return Math.max(res[0], res[1]);
	}

	// 1. 确定递归函数的参数和返回值
	// dp[0]表示不偷, dp[1]表示偷, 返回值是一个长度为2的数组, 参数为当前节点
	private int[] help(TreeNode cur) {
		// 2. 确定终止条件
		if(cur == null) {
			return new int[]{0,0};
		}

		// 3. 确定遍历顺序 后序遍历 左右根
		int[] left = help(cur.left);
		int[] right = help(cur.right);

		// 4. 单层递归逻辑
		int[] dp = new int[2];
		// 偷
		dp[1] = cur.val + left[0] + right[0];
		// 不偷
		dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

		return dp;
	}
}
