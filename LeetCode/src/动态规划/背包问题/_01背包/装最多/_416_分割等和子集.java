package 动态规划.背包问题._01背包.装最多;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: _416_分割等和子集
 * @Author: whc
 * @Date: 2021/05/02/12:37
 */
public class _416_分割等和子集 {

	public static void main(String[] args) {
		canPartition(new int[]{1,1,1,1});
	}

	/**
	 * 思路: 回溯法
	 * 超时.....
	 *
	 * 按照回溯的思想,但是返回值为boolean,提前返回
	 */
	/*public static boolean canPartition(int[] nums) {
		int sum = 0;
		int maxNum = 0;
		for (int num : nums) {
			sum += num;
			maxNum = Math.max(maxNum, num);
		}

		// 排除不符合的情况
		if(sum % 2 == 1 || maxNum > sum / 2) {
			return false;
		}

		boolean[] used = new boolean[nums.length];
		// 降序便于提前回溯,降低时间复杂度
		Arrays.sort(nums);
		return backtrack(nums, sum/2, 0, used);
	}

	private static boolean backtrack(int[] nums, int target, int startIndex, boolean[] used) {
		if(target == 0) {
			return true;
		}

		if(target < 0) {
			return false;
		}

		if(startIndex == nums.length) {
			return false;
		}

		for (int i = startIndex; i < nums.length; i++) {
			if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
				continue;
			}
			used[i] = true;
			if(backtrack(nums, target - nums[i], i+1, used)) {
				return true;
			} else {
				used[i] = false;
				continue;
			}
		}

		return false;
	}*/


	// 求背包是否正好装满

	/**
	 * 思路: _01背包
	 *
	 * 如何转化为01背包?
	 * - 背包体积(重量)为sum/2
	 * - 背包要放入的商品(集合里的元素)重量为元素的数值,价值也为元素的数值
	 * - 背包如何正好装满,说明找到了总和为sum/2的子集
	 * - 背包中里的每一个元素都是不可重复放入的
	 *
	 * 1. 确定dp数组以及下标含义
	 * dp[j]: 表示背包容量为j,所背的物品价值可以最大为dp[j]
	 *
	 * 2. 确定递推公式
	 * dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
	 *
	 * 3. 初始化
	 * dp[0] = 0
	 *
	 * 4. 确定遍历顺序
	 * 先遍历物品,再遍历背包容量
	 * 注意遍历背包容量的时候应该是逆序遍历,防止重复放入
	 *
	 * 5. 举例推导dp数组
	 * 比如nums=[1,5,11,5]
	 *
	 * 背包容量为11
	 *     背包容量 0 1 2 3 4 5 6 7 8 9 10 11
	 * 元素0       0 1 1 1 1 1 1 1 1 1  1  1
	 * 元素1       0 1 1 1 1 1 6 6 6 6 6  6
	 * 元素2       0 1 1 1 1 1 6 6 6 6 6  11
	 * 元素3      0 1 1 1 1 5 6 6 6 6  10 11
	 */
	public static boolean canPartition(int[] nums) {
		int sum = 0;
		int maxNum = 0;
		for (int num : nums) {
			sum += num;
			maxNum = Math.max(maxNum, num);
		}

		if(sum % 2 == 1 || maxNum > sum / 2) {
			return false;
		}

		// 1.dp数组
		int target = sum / 2;
		int[] dp = new int[target + 1];

		// 2.确定递推公式
		// 3.初始化

		// 4.确定遍历顺序
		for (int i = 0; i < nums.length; i++) {
			// 后遍历背包容量,倒叙遍历
			for (int j = target; j >= nums[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
				//			不放入当前物品    放入当前物品
			}
		}

		return dp[target] == target;
	}
}
