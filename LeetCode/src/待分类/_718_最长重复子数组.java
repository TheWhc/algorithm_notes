package 待分类;

/**
 * @ClassName: 待分类._718_最长重复子数组
 * @Author: whc
 * @Date: 2021/03/22/10:48
 */
public class _718_最长重复子数组 {

	/*public int findLength(int[] A, int[] B) {
		int[][] dp = new int[A.length + 1][B.length + 1];
		int result = 0;
		for (int i = 1; i <= A.length; i++) {
			for (int j = 1; j <= B.length; j++) {
				if(A[i] == B[j]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				if(dp[i][j] > result) {
					result = dp[i][j];
				}
			}
		}

		return result;
	}*/

	// 降维
	/*public int findLength(int[] A, int[] B) {
		int[] dp = new int[B.length + 1];
		int result = 0;
		for (int i = 1; i <= A.length; i++) {
			for (int j = B.length; j >= 1; j--) {
				if(A[i-1] == B[j-1]) {
					dp[j] = dp[j-1] + 1;
				} else {
					dp[j] = 0;
				}
				if(dp[j] > result) {
					result = dp[j];
				}
			}
		}
		return result;
	}
*/

	public int findLength(int[] A, int[] B) {
		// 1. 确定dp数组以及下标含义  dp[i][j] 代表A[i-1] B[j-1]最长公共子数组
		int[][] dp = new int[A.length + 1][B.length + 1];

		// 2. 确定递推公式
		// A[i-1] == B[j-1]  dp[i][j] = dp[i-1][j-1] + 1

		// 3. 初始化
		for (int i = 0; i <= A.length; i++) {
			dp[i][0] = 0;
		}
		for (int j = 0; j <= B.length; j++) {
			dp[0][j] = 0;
		}

		// 记录最大值
		int result = 0;
		// 4. 确定遍历顺序 从上到下,从左到右
		for (int i = 1; i <= A.length; i++) {
			for (int j = 1; j <= B.length; j++) {
				if(A[i-1] == B[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				result = Math.max(dp[i][j], result);
			}
		}
		return result;
	}
}
