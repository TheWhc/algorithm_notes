package cvte;

import java.util.Scanner;

/**
 * @ClassName: _07_青蛙跳荷花
 * @Author: whc
 * @Date: 2021/10/01/11:53
 */
public class _07_青蛙跳荷花 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int n = in.nextInt();
			int count = jumpFloor(n);
			System.out.println(count);
		}
	}

	// 完全背包 + 背包凑满 + 排列问题(外层遍历背包容量,内层遍历物品)
	private static int jumpFloor(int n) {
		int[] dp = new int[n+1];

		dp[0] = 1;

		// 外层遍历背包容量
		for (int j = 1; j <= n; j++) {
			// 内层遍历物品
			for (int i = 1; i <= 3; i++) {
				if(j >= i) {
					dp[j] += dp[j-i];
				}
			}
		}

		return dp[n];
	}
}
