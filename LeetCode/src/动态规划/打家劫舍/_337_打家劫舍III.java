package 动态规划.打家劫舍;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _337_打家劫舍III
 * @Author: whc
 * @Date: 2021/06/13/12:20
 */
public class _337_打家劫舍III {

	// 题意: 如果偷取了当前节点,那么它的孩子节点都不能偷取; 如果不偷取当前节点,那么它的孩子节点都能偷取

	/**
	 *  思路: 树形dp
	 *
	 *  树形dp: 在树上进行递归公式的推导
	 *
	 *  对一个节点偷与不偷得到的最大金额进行记录,然后才能用状态转移记录状态的变化
	 *
	 *  递归函数
	 *  1. 确定递归函数的参数和返回值
	 *  	- 返回值为一个长度为2的数组,表示偷与不偷两个状态
	 *  	- int[] robTree(TreeNode cur)
	 *
	 *  2. 确定终止条件
	 *  	(空节点时,偷与不偷都是为0)
	 *  	- if(cur == null) {
	 *  	 	return new int[]{0, 0};
	 *  	}
	 *
	 *  3. 确定遍历顺序
	 *  	后序遍历(左右根)
	 *  	通过递归得到左节点,得到左节点偷与不偷的金额
	 *      通过递归得到右节点,得到右节点偷与不偷的金额
	 *      下标为0表示不偷, 下标为1表示偷
	 *      int[] left = robTree(cur.left); // 左
	 *      int[] right = robTree(cur.right); // 右
	 *
	 *  4. 确定单层递归的逻辑
	 *  	如果偷取当前节点,那么孩子节点都不能偷取, int val1 = cur.val + left[0] + right[0]
	 *  	如果不偷取当前节点,那么孩子节点都能偷取,偷不偷选一个最大的值, int val2 = Math.max(left[0],left[1]) + Math.max(right[0],right[1])
	 *
	 *  5. 举例推导
	 *  	   3 {6,7}
	 *  	 /  \
	 * {3,2}2   3 {1,3}
	 *      \    \
	 * {0,3}3    1 {0,1}
	 *
	 *  时间: O(n)
	 *  空间: O(logn)
	 */
	/*public int rob(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int[] res = robTree(root);
		return Math.max(res[0], res[1]);
	}

	private int[] robTree(TreeNode cur) {
		// 递归终止条件
		if(cur == null) {
			return new int[]{0, 0};
		}

		// 后序遍历
		int[] left = robTree(cur.left); // 左
		int[] right = robTree(cur.right); // 右

		// 单层递归逻辑
		// 偷当前节点 + 左节点不偷 + 右节点不偷
		int val1 = cur.val + left[0] + right[0];
		// 不偷取当前节点 + 偷左节点中最大值 + 偷右节点最大值
		int val2 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

		return new int[]{val2, val1};
	}*/

	/**
	 *  思路: 递归 + 记忆化
	 *
	 *  实时计算每个节点偷与不偷的情况
	 *
	 *  时间: O(n)
	 *  空间: O(logn)
	 */
	// 记忆化避免重复计算
	Map<TreeNode, Integer> map = new HashMap<>();
	public int rob(TreeNode root) {
		if(root == null) {
			return 0;
		}

		if(root.left == null && root.right == null) {
			return root.val;
		}

		if(map.containsKey(root)) {
			return map.get(root);
		}

		// 偷取当前节点
		int val1 = root.val;
		if(root.left != null)
			val1 += rob(root.left.left) + rob(root.left.right);
		if(root.right != null)
	    	val1 += rob(root.right.left) + rob(root.right.right);

		// 不偷取当前节点
		int val2 = rob(root.left) + rob(root.right);

		// 记录当前结果
		map.put(root, Math.max(val1, val2));

		return Math.max(val1, val2);
	}


}
