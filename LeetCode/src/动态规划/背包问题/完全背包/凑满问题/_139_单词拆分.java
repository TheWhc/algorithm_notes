package 动态规划.背包问题.完全背包.凑满问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _139_单词拆分
 * @Author: whc
 * @Date: 2021/06/28/14:36
 */
public class _139_单词拆分 {

	// 完全背包 + 凑满问题

	/**
	 * 思路: 完全背包
	 *
	 * 如何转化为背包问题?
	 * 因为给定的字符串s可以看成是背包容量, wordDict单词列表可以看成是物品, 从workDict任意选凑成字符串s
	 *
	 * 1. 确定dp数组
	 * dp[j]:表示字符串长度为j时,如果dp[j]=true,表示可以拆分成一个或者多个在字典中出现的词
	 *
	 * 2. 确定递推公式
	 * // 先遍历背包容量(正序遍历),再遍历物品
	 * // 只有当前物品(当前字符串)与给定的字符串s指定位置的字符串匹配时,才进行递推
	 * int dicLen = wordDict.get(i).length();
	 * if( j >= len(i) && wordDict.get(i).equals(j-dicLen, j) ) {
	 *     dp[j] = dp[j] || dp[j - dicLen];
	 * }
	 *
	 * 3. 初始化
	 * dp[0] = true 是一切递推的基础
	 *
	 * 4. 确定遍历顺序
	 * 先遍历背包容量,再遍历物品
	 * 或者先遍历物品,再遍历背包容量都可以
	 * 如果先遍历物品,再遍历背包,还要维护一个容器,每次遍历完一个物品时,都要吧物品放入容器中,以便遍历第二个物品的时候可能会用到容器进行判断当前位置是否为true,时间复杂度高
	 *
	 * 所以这里用外层遍历背包容量,内层遍历物品,这样就不用维护一个容器了
	 *
	 */
	public boolean wordBreak(String s, List<String> wordDict) {

		boolean[] dp = new boolean[s.length()+1];

		dp[0] = true;

		// 外层遍历背包容量,即字符串s下标
		// 可以重复选取单词,所以正序遍历
		for (int j = 1; j <= s.length(); j++) {
			// 内层遍历物品,即字典中的单词
			for (int i = 0; i < wordDict.size(); i++) {
				// 当前单词的长度
				int dicLen = wordDict.get(i).length();
				// 背包容量,即字符串s下标长度是否大于单词的长度 并且 对应的指定字符串是否与单词匹配
				if(j >= dicLen && wordDict.get(i).equals(s.substring(j-dicLen, j))) {
					// 匹配时则进入递推公式
					dp[j] = dp[j] || dp[j-dicLen];
				}
			}
		}

		return dp[s.length()];
	}

	/*public static boolean wordBreak(String s, List<String> wordDict) {

		boolean[] dp = new boolean[s.length()+1];

		dp[0] = true;

		List<String> container = new ArrayList<>();

		// 外层遍历物品
		for (int i = 0; i < wordDict.size(); i++) {
			// 内层遍历背包容量
			for (int j = wordDict.get(i).length(); j <= s.length(); j++) {
				String word = wordDict.get(i);
				if(s.substring(j - wordDict.get(i).length(), j).equals(word)) {
					dp[j] = dp[j] || dp[j-word.length()];
				}
				for (String s1 : container) {
					if(j >= s1.length() && container.contains(s.substring(j - s1.length(), j))) {
						dp[j] = dp[j] || dp[j-s1.length()];
						break;
					}
				}
			}
			container.add(wordDict.get(i));

			// for (int j = 0; j <= s.length(); j++) {
			// 	System.out.print(dp[j] + " ");
			// }
			// System.out.println();
		}

		return dp[s.length()];
	}*/

}
