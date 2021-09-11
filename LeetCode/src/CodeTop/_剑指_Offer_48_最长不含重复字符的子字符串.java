package CodeTop;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _剑指_Offer_48_最长不含重复字符的子字符串
 * @Author: whc
 * @Date: 2021/09/11/19:20
 */
public class _剑指_Offer_48_最长不含重复字符的子字符串 {

	/**
	 * 思路： 滑动窗口 + HashMap
	 */
	public int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		int left = 0;
		int right = 0;
		Map<Character, Integer> map = new HashMap<>();
		int res = 0;
		while(right < s.length()) {
			if(map.containsKey(s.charAt(right))) {
				left = Math.max(left, map.get(s.charAt(right)) + 1);
			}
			map.put(s.charAt(right), right);
			res = Math.max(res, right - left + 1);
			right++;
		}

		return res;
	}
}
