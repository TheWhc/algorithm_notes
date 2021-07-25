package CodeTop;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: _76_最小覆盖子串
 * @Author: whc
 * @Date: 2021/07/25/1:15
 */
public class _76_最小覆盖子串 {

	public String minWindow(String s, String t) {
		if(s.length() < t.length()) {
			return "";
		}

		int left = 0;
		int right = 0;
		int winSize = Integer.MAX_VALUE;
		int winStart = 0;
		int count = t.length();
		int[] nums = new int[128]; // 存储128个字符,存储需要字符的次数
		for (int i = 0; i < t.length(); i++) {
			nums[t.charAt(i)]++;
		}

		while(right < s.length()) {
			char c = s.charAt(right);

			// 窗口遇到必须包含的字符时,则count--
			if(nums[c] > 0) {
				count--;
			}

			// 遍历s的每个字符时,对应的字符次数减1,是为了后续的窗口包含的子串,移动左指针作铺垫,在满足包含t字符串的同时,将窗口不断收缩
			// 窗口内的字符所需次数, < 0 表示不需要, = 0 表示必须包含子串t的字符
			nums[c]--;

			// 窗口包含所有t字符串的所有字符时
			if(count == 0) {
				// 找到窗口的起始位置
				while (left < right && nums[s.charAt(left)] < 0) {
					// 注意这里在滑动窗口左指针时,需要将窗口外的值次数加回
					nums[s.charAt(left)]++;
					left++;
				}

				// 尝试判断更新窗口大小
				if(right - left + 1 < winSize) {
					winSize = right - left + 1;
					winStart = left;
				}

				// 开始下一个子串的查找,移动左指针
				nums[s.charAt(left)]++; // 恢复t字符串中left下标字符的次数
				count++; // 以及恢复总共所需字符数
				left++; // 开始移动左指针
			}

			right++;
		}

		return winSize == Integer.MAX_VALUE ? "" : s.substring(winStart, winStart + winSize);
	}

	public static void main(String[] args) {
		_76_最小覆盖子串 _76_最小覆盖子串 = new _76_最小覆盖子串();
		_76_最小覆盖子串.minWindow("ADOBECODEBANC", "ABC");
	}

}
