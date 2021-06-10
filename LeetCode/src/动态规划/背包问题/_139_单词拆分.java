package 动态规划.背包问题;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: _139_单词拆分
 * @Author: whc
 * @Date: 2021/05/04/16:50
 */
public class _139_单词拆分 {

	// 回溯法
	// 超时 时间复杂度O(2^n)
	/*public boolean wordBreak(String s, List<String> wordDict) {
		return backtrack(s, wordDict, 0);
	}

	private boolean backtrack(String s, List<String> wordDict, int startIndex) {
		// 递归终止条件
		if(startIndex >= s.length()) {
			return true;
		}

		// 单层递归逻辑
		for (int i = startIndex; i < s.length(); i++) {
			String word = s.substring(startIndex, i+1);
			// 左侧部分是单词,继续对剩余子串进入下一层递归考察
			// 若左侧不是单词,则继续进行单层划分
			if(wordDict.contains(word) && backtrack(s, wordDict, i+1)) {
				return true;
			}
		}

		return false;
	}*/

	// 记忆化
	// 时间复杂度：O(n ^ 3)
	/*public boolean wordBreak(String s, List<String> wordDict) {
		boolean[] memory = new boolean[s.length()];
		return backtrack(s, wordDict, 0, memory);
	}

	private boolean backtrack(String s, List<String> wordDict, int startIndex, boolean[] memory) {
		// 递归终止条件
		if(startIndex >= s.length()) {
			return true;
		}
		// 增加一个booleanboolean数组表示当前位置之后的字符串是否遍历过了，
		// 如果遍历过了并且没有提前递归的返回truetrue说明，这个位置后面的匹配是不会成功的，
		// 因此直接返回false
		if(memory[startIndex]) {
			return false;
		}

		// 单层递归逻辑
		for (int i = startIndex; i < s.length(); i++) {
			String word = s.substring(startIndex, i+1);
			// 左侧部分是单词,继续对剩余子串进入下一层递归考察
			// 若左侧不是单词,则继续进行单层划分
			if(wordDict.contains(word) && backtrack(s, wordDict, i+1, memory) ) {
				return true;
			}
		}
		// 以startIndex开始的子串无法划分
		memory[startIndex] = true;
		return false;
	}*/

	// 完全背包问题
	// s相当于背包容量
	// wordDict相当于物品,且无数个
	public boolean wordBreak(String s, List<String> wordDict) {
		// 1. 定义dp数组以及下标含义
		// dp[i]表示字符串长度为i为true时,表示可以拆分
		boolean[] dp = new boolean[s.length()+1];

		// 2. 确定递推公式
		// 用指针j去划分s[0:i]子串
		// dp[j]为true时, 且s[j,i-1]区间子串出现在字典中,那么dp[i]才为true
		// 所以递推公式: if(s[j, i-1] 这个区间的子串出现在字典里 && dp[j]是true) 那么 dp[i] = true
		// 举例 l e e t c o d e  ["leet", "code"]
		//             j       i
  		// 3. 初始化
		dp[0] = true;
		// j = 0时,

		// 4. 确定遍历顺序
		// 先遍历背包容量 再遍历物品
		/*for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				String word = s.substring(j, i);
				if(dp[j] && wordDict.contains(word)) {
					dp[i] = true;
				}
			}
		}*/
		// 先容量 后物品
		for (int j = 1; j <= s.length(); j++) {
			for (int i = 0; i < wordDict.size(); i++) {
				int dicLen = wordDict.get(i).length();
				if(j >= dicLen && wordDict.get(i).equals(s.substring(j-dicLen, j))) {
					dp[j] = dp[j] || dp[j-dicLen];
				}
			}
		}

		return dp[s.length()];
	}
}
