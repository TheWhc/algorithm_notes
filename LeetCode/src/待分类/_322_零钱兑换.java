package 待分类;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: 待分类._322_零钱兑换
 * @Author: whc
 * @Date: 2021/03/27/10:15
 */
public class _322_零钱兑换 {


	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, Integer.MAX_VALUE); // 避免被覆盖
		dp[0] = 0;
		for (int i = 0; i < coins.length; i++) { // 遍历物品
			for (int j = coins[i]; j <= amount; j++) { // 遍历背包
				if(dp[j-coins[i]] != Integer.MAX_VALUE) { // 如果是初始值就跳过
					dp[j] = Math.min(dp[j-coins[i]] + 1, dp[j]);
				}
			}
		}
		if(dp[amount] == Integer.MAX_VALUE)
			return -1;
		return dp[amount];
	}

}
