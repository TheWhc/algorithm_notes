package CodeTop;

/**
 * @ClassName: _JZ9_跳台阶扩展问题
 * @Author: whc
 * @Date: 2021/07/22/12:23
 */
public class _JZ9_跳台阶扩展问题 {


	/**
	 * 完全背包凑满排列问题
	 * 举例: n=3时
	 *            0 1 2 3
	 * 物品0(1步)  1 1 1 2
	 * 物品1(2步)  1 1 2 3
	 * 物品2(3步)  1 1 2 4
	 */
	public int jumpFloorII(int target) {
		int[] dp = new int[target + 1];
		// 初始化
		dp[0] = 1;

		// 外层遍历背包容量,即1,2,3
		for (int j = 1; j <= target; j++) {
			// 内层遍历背包物品,即1,2,3
			for (int i = 1; i <= target; i++) {
				if(j >= i) {
					dp[j] += dp[j-i];
				}
			}
		}

		return dp[target];
	}
}
