package 动态规划.背包问题.完全背包.凑满排列问题;

/**
 * @ClassName: _JZ9_跳台阶扩展问题
 * @Author: whc
 * @Date: 2021/06/28/11:28
 */
public class _JZ9_跳台阶扩展问题 {

	/**
	 * 思路: 完全背包问题
	 *
	 * 如何转换?
	 * 比如跳到阶梯3时,凑成3时, 可以是1、2步,也可以是2、1步,这两种方法不同, 即求的是排列数
	 *
	 * 1. 确定dp数组
	 * dp[j]: 凑成目标target的排列数为dp[j]
	 *
	 * 2. 确定递推公式
	 * dp[j] += dp[j-nums[i]]
	 *
	 * nums[i]的取值范围为[1,target]
	 *
	 * 3. 初始化
	 * dp[0] = 1
	 *
	 * 4. 确定遍历顺序
	 * 凑满排列问题,先遍历背包容量,再遍历物品
	 * 因为是元素可以重复选,所以背包容量正序遍历
	 *
	 * 5. 举例推导dp数组
	 * 输入3
	 *        0 1 2 3
	 * 物品0  1 1 1 2
	 * 物品1  1 1 2 3
	 * 物品2  1 1 2 4
	 */
	public int jumpFloorII(int target) {

		int[] dp = new int[target+1];

		dp[0] = 1;

		// 外层遍历背包容量
		for (int j = 1; j <= target; j++) {
			// 内层遍历物品,即阶梯[1,target]
			for (int i = 1; i <= target; i++) {
				if(j >= i)
					dp[j] += dp[j-i];
			}
		}

		return dp[target];
	}
}
