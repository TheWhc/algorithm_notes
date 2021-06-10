package 待分类;

/**
 * @ClassName: 待分类._72_编辑距离
 * @Author: whc
 * @Date: 2021/04/07/10:27
 */
public class _72_编辑距离 {
	public int minDistance(String word1, String word2) {

		// 1. 确定dp数组以及下标的含义
		// dp[i][j] 表示以下标为i-1的word1和j-1的word2最短编辑距离
		// 不是以i的word1和j的word2, 要考虑空字符串
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];

		// 2. 确定递推公式
		// word1[i-1] == word2[j-1] ==>  dp[i][j] = dp[i-1][j-1]
		// word1[i-1] != word2[j-1] ==>  dp[i][j] = dp[i-1][j] + 1(添加), dp[i][j] = dp[i][j-1] + 1 (添加等同于删除)
		//                               dp[i][j] = dp[i-1][j-1] + 1(替换)

		// 3. 初始化
		for (int i = 0; i <= word1.length(); i++) {
			dp[i][0] = i;
		}

		for (int j = 0; j <= word2.length(); j++) {
			dp[0][j] = j;
		}

		// 4. 确定遍历顺序
		// 从上到下, 从左到右
		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				if(word1.charAt(i-1) == word2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				} else {
					dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
				}
			}
		}

		return dp[word1.length()][word2.length()];
	}
}
