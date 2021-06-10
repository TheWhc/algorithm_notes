package 待分类;

/**
 * @ClassName: 待分类._583_两个字符串的删除操作
 * @Author: whc
 * @Date: 2021/04/08/10:20
 */
public class _583_两个字符串的删除操作 {

	public int minDistance(String word1, String word2) {
		// 1. 定义dp数组以及确定数组下标含义 dp[i][j]表示s1[i-1]  s2[j-1]的最小步数
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];

		// 2. 确定递推公式
		// s1[i-1] == s2[j-1]   dp[i][j] = dp[i-1][j-1]
		// s1[i-1] != s2[j-1]   dp[i][j] = dp[i][j-1] + 1   dp[i][j] = dp[i-1][j] + 1;

		// 3. 初始化
		for (int i = 0; i <= word1.length(); i++) {
			dp[i][0] = i;
		}

		for (int j = 0; j <= word2.length(); j++) {
			dp[0][j] = j;
		}

		// 4. 确定遍历顺序 从左到右 从上到下
		for (int i = 1; i <= word1.length(); i++) {
			for (int j = 1; j <= word2.length(); j++) {
				if(word1.charAt(i-1) == word2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				} else {
					dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + 1;
				}
			}
		}

		return dp[word1.length()][word2.length()];
	}
}
