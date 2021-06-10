package 待分类;

/**
 * @ClassName: 待分类._5_最长回文子串
 * @Author: whc
 * @Date: 2021/03/19/11:00
 */
public class _5_最长回文子串 {
	/*public String longestPalindrome(String s) {
		int maxLength = 0;
		// 1. 定义dp数组和含义, dp[i][j]代表s[i,j]是否是回文字串
		boolean[][] dp = new boolean[s.length()][s.length()];
		// 2. 确定递推表达式
		// 3. 初始化为false
		// 4. 遍历方向 从下往上,从左往右
		int left = 0;
		int right = 0;
		for (int i = s.length()-1; i >= 0; i--) {
			// 填补数组右上角,所以j从i开始
			for (int j = i; j < s.length(); j++) {
				if(s.charAt(i) == s.charAt(j)) {
					if(j - i <= 1) {
						dp[i][j] = true;
					} else if(dp[i+1][j-1]) {
						dp[i][j] = true;
					}
				}
				// 记录最大回文子串的左右位置
				if(dp[i][j] && (j - i + 1) > maxLength) {
					maxLength = j - i + 1;
					left = i;
					right = j;
				}
			}
		}

		return s.substring(left, right+1);
	}*/

	// 中心扩展
	int maxLength = 0;
	int left = 0;
	int right = 0;
	public String longestPalindrome(String s) {
		for (int i = 0; i < s.length(); i++) {
			extend(s, i, i, s.length()); // 以i为中心
			extend(s, i, i+1, s.length()); // 以i+1为中心
		}
		return s.substring(left, right+1);
	}

	private void extend(String s, int i, int j, int n) {
		while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			if(j - i + 1 > maxLength) {
				maxLength = j - i + 1;
				left = i;
				right = j;
			}
			i--;
			j++;
		}
	}
}
