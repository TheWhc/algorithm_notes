/**
 * @ClassName: _MT1_最大差值
 * @Author: whc
 * @Date: 2021/03/03/11:23
 */
public class _MT1_最大差值 {
	/*public int getDis(int[] A, int n) {
		// write code here
		// 时间复杂度O(n^2)
		int res = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = i; j < A.length; j++) {
				res = Math.max(A[j] - A[i], res);
			}
		}

		return res;
	}*/

	/*public int getDis(int[] A, int n) {
		// write code here
		// 动态规划, dp[i]代表最大差值
		int[] dp = new int[n];
		int max = 0;
		for (int i = 1; i < A.length; i++) {
			dp[i] = Math.max(dp[i], A[i]-A[i-1]+dp[i-1]);
			max = Math.max(max, dp[i]);
		}

		return max;
	}*/

	public int getDis(int[] A, int n) {
		// write code here
		int res = 0;
		// 记录最小值
		int minNum = A[0];
		for (int i = 1; i < A.length; i++) {
			res = Math.max(res, A[i]-minNum);
			minNum = Math.min(minNum, A[i]);
		}
		return  res;
	}
}
