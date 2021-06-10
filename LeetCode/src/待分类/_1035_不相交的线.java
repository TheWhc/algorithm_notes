package 待分类;

/**
 * @ClassName: 待分类._1035_不相交的线
 * @Author: whc
 * @Date: 2021/04/09/2:03
 */
public class _1035_不相交的线 {

	// 其实求两个字符串最长公共子序列长度
	public int maxUncrossedLines(int[] A, int[] B) {
		// 1. 确定dp数组以及下标含义
		int[][] dp = new int[A.length + 1][B.length + 1];

		// 2. 确定递推公式
		// A[i-1] == B[j-1] dp[i][j] = dp[i-1][j-1] + 1
		//        !=                 = max(dp[i-1][j], dp[i][j-1])

		// 3. 初始化
		for (int i = 0; i <= A.length; i++) {
			dp[i][0] = 0;
		}
		for (int j = 0; j <= B.length; j++) {
			dp[0][j] = 0;
		}

		int result = 0;
		// 4. 确定遍历顺序 从上到下 从左往右
		for (int i = 1; i <= A.length; i++) {
			for (int j = 1; j <= B.length; j++) {
				if(A[i-1] == B[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
				result = Math.max(result, dp[i][j]);
			}
		}

		return result;
	}
}
