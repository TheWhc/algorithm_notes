package 贪心;

/**
 * @ClassName: _860_柠檬水找零
 * @Author: whc
 * @Date: 2021/04/13/11:48
 */
public class _860_柠檬水找零 {
	/*public boolean lemonadeChange(int[] bills) {
		int[] dp = new int[3];
		for (int i = 0; i < bills.length; i++) {
			if(bills[i] == 5) {
				dp[0] += 1;
			} else if(bills[i] == 10) {
				dp[1] += 1;
				if(dp[0] < 1) {
					return false;
				}
				dp[0] -= 1;
			} else {
				dp[2] += 1;
				if(!(dp[0] >= 3 || (dp[0] >= 1 && dp[1] >= 1))) {
					return false;
				} else {
					// 优先消耗10美元,因为5美元找零用处更大
					if(dp[0] >= 1 && dp[1] >= 1) {
						dp[0] -= 1;
						dp[1] -= 1;
					} else {
						dp[0] -= 3;
					}
				}
			}
		}

		return true;
	}*/

	/**
	 * 思路: 贪心
	 * 局部最优：遇到20块,优先消耗10块
	 * 全局最优：完成全部账单的找零
	 */
	public boolean lemonadeChange(int[] bills) {
		int five = 0;
		int ten = 0;

		for (int i = 0; i < bills.length; i++) {
			if(bills[i] == 5) {
				five++;
			} else if(bills[i] == 10) {
				if(five == 0) {
					return false;
				}
				five--;
				ten++;
			} else {
				if(five >= 1 && ten >= 1) {
					five--;
					ten--;
				} else if(five >= 3) {
					five -= 3;
				} else {
					return false;
				}
			}
		}

		return true;
	}
}
