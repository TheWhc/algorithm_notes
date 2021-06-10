package mt._2021_;

import java.util.Scanner;

/**
 * @ClassName: _01_小美的送花线路_
 * @Author: whc
 * @Date: 2021/05/28/1:20
 */
public class _01_小美的送花线路_ {

	// 问题描述: 求花店到所有客户地址之和,以及骑手实际走的路程

	/**
	 * 思路: 画图,可得出一棵树
	 *
	 * 花店到用户地址之和: 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 花店和客户总数
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		int sum1 = 0;
		int sum2 = 0;
		int maxLength = 0;
		// u,v,w, u和v之间的距离为w
		for (int i = 0; i < n-1; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			dp[v] = dp[u] + w;
			// 花店到用户地址之和
			sum1 += dp[v];
			sum2 += 2 * w;
			maxLength = Math.max(maxLength, dp[v]);
		}

		sum2 -= maxLength;

		System.out.println(sum1 + " " + sum2);
	}
}
