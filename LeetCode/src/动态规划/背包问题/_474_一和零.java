package 动态规划.背包问题;

/**
 * @ClassName: _474_一和零
 * @Author: whc
 * @Date: 2021/05/04/9:24
 */
// strs里面的元素是物品,每个物品都是一个
// _01背包   m和n相当于是一个背包,两个维度的背包
public class _474_一和零 {

	public int findMaxForm(String[] strs, int m, int n) {
		// 1. 确定dp数组以及下标含义
		// dp[i][j] : 最多有i个0和j个1的strs的最大子集的大小为dp[i][j]
		int[][] dp = new int[m+1][n+1];

		// 2. 确定递推公式
		// 由前一个str里的字符串推出来,所以减去当前字符串的0和1的个数得到前一个字符串的最大子集再加1
		// dp[i][j] = Math.max(dp[i][j], dp[i-zeroNum][j-oneNum]+1);

		// 3. 初始化 都为0
		// 4. 确定遍历顺序 先遍历物品(字符串) 再遍历背包容量(m个0和n个1)
		for (String str : strs) {
			int zeroNum = 0;
			int oneNum = 0;
			for (int index = 0; index < str.length(); index++) {
				if(str.charAt(index) == '0') {
					zeroNum++;
				} else {
					oneNum++;
				}
			}

			for (int i = m; i >= zeroNum; i--) {
				for (int j = n; j >= oneNum; j--) {
					dp[i][j] = Math.max(dp[i][j], dp[i-zeroNum][j-oneNum] + 1);
				}
			}
		}

		return dp[m][n];
	}

}
