package CodeTop;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _3_无重复字符的最长子串
 * @Author: whc
 * @Date: 2021/07/19/23:31
 */
public class _3_无重复字符的最长子串 {

	/**
	 * 思路： 滑动窗口
	 */
	/*public int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}

		int left = 0;
		int right = 0;
		int res = Integer.MIN_VALUE;
		while(right < s.length()) {
			String window = s.substring(left, right);
			if(window.contains(String.valueOf(s.charAt(right)))) {
				res = Math.max(res, right - left);
				left++;
			}else{
				right++;
			}
		}

		res = Math.max(res, right - left);

		return  res;
	}*/

	public int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}

		int left = 0;
		int right = 0;
		int res = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		while(right < s.length()) {
			if(map.containsKey(s.charAt(right))) {
				// 避免出现"abba"时, 遍历到最后一个a时,此时的left指向2下标位置,避免指向前面位置
				left = Math.max(left, map.get(s.charAt(right)) + 1);
			}
			map.put(s.charAt(right), right);
			res = Math.max(res, right - left + 1);
			right++;
		}

		return  res;
	}

	public static void main(String[] args) {
		_3_无重复字符的最长子串 _3_无重复字符的最长子串 = new _3_无重复字符的最长子串();
		System.out.println(_3_无重复字符的最长子串.lengthOfLongestSubstring("abba"));
	}

}
