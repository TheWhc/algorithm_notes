package 动态规划.背包问题._01背包.装最多问题;

/**
 * @ClassName: _1049_最后一块石头的重量II
 * @Author: whc
 * @Date: 2021/06/27/10:38
 */
public class _1049_最后一块石头的重量II {

	// 求背包最多能装多少

	/**
	 * 思路: 01背包 动态规划
	 * 将石头尽量拆分成重量相同的两堆,所以最后返回结果sum - dp[重量/2] - dp[重量/2]
	 *
	 * 1. 确定dp数组以及下标含义
	 * dp[j]表示背包容量为j的最大所背重量
	 *
	 * 2. 确定递推公式
	 * dp[j] = Math.max(dp[j], dp[j-stones[i]] + stones[i])
	 *           不放入当前石头   放入当前石头
	 *
	 * 3. 初始化
	 * dp[0] = 0
	 *
	 * 4. 确定遍历顺序
	 * 01背包,先遍历物品,再遍历背包容量,背包容量应该逆序遍历
	 *
	 * 5. 举例推导dp数组
	 * 输入[2,4,1,1]
	 *   下标  0  1  2  3  4
	 * 石头0   0  0  2  2  2
	 * 石头1   0  0  2  2  4
	 * 石头2   0  1  2  3  4
	 * 石头3   0  1  2  3  4
	 *
	 * dp[4] = 4
	 * res = 8 - 4 - 4 = 0
	 *
	 * 时间: O(n * m) n为石头块数
	 * 空间: O(m)   m为石头总重量的一半
	 */
	public int lastStoneWeightII(int[] stones) {
		// 1 <= stones.length <= 30
		// 1 <= stones[i] <= 100
		// 最大重量的一半 = 30 * 100 / 2 = 1500
		int[] dp = new int[1501];

		int sum = 0;
		for (int stone : stones) {
			sum += stone;
		}

		int target = sum / 2;

		for (int i = 0; i < stones.length; i++) {
			for (int j = target; j >= stones[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j-stones[i]] + stones[i]);
			}
		}

		return sum - dp[target] - dp[target];
	}
}
