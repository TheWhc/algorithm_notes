package 动态规划.背包问题._01背包.双重维度问题;

/**
 * @ClassName: _474_一和零
 * @Author: whc
 * @Date: 2021/06/27/13:37
 */
public class _474_一和零 {

	/**
	 * 思路: 01背包问题
	 *
	 * 如何转化为01背包?
	 * m和n相当于是一个背包,两个维度的背包
	 *
	 * 一个维度是m,一个维度是n,不同长度的字符串就是不同大小的待装物品
	 *
	 * 1. 确定dp数组以及下标含义
	 * dp[i][j]:最多有i个0和j个1的strs的最大子集的大小为dp[i][j]
	 *
	 * 2. 确定递推公式
	 * dp[i][j] = Math.max(dp[i][j], dp[i-zeroNum][j-oneNum] + 1)
	 *             不放入当前字符串    放入当前字符串(由前一个str里的字符串推出来,所以减去当前字符串的0和1的个数得到前一个字符串的最大子集再加1)
	 *
	 * 3. 初始化
	 * 初始化都为0
	 *
	 * 4. 确定遍历顺序
	 * 先遍历物品(strs)
	 * 再遍历背包
	 *
	 * 能不能先遍历背包,再遍历物品?
	 * 因为这里物品只能存放一次,所以背包容量应该是倒叙遍历,防止重复放置
	 * 并且应该是先遍历物品,再遍历背包容量,如果是先遍历背包容量,后遍历物品时,那么就会出现背包只会存放一个元素的情况
	 *
	 */
	public int findMaxForm(String[] strs, int m, int n) {
		int[][] dp = new int[m+1][n+1];

		// 外层遍历物品
		for (String str : strs) {
			int zeroSum = 0;
			int oneSum = 0;
			for (int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == '0') {
					zeroSum++;
				} else {
					oneSum++;
				}
			}

			// 内层遍历背包容量,逆序遍历
			for (int i = m; i >= zeroSum; i--) {
				for (int j = n; j >= oneSum; j--) {
					dp[i][j] = Math.max(dp[i][j], dp[i-zeroSum][j-oneSum] + 1);
				}
			}
		}

		return dp[m][n];
	}
}
