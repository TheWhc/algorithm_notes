package 待分类;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: 待分类._3_无重复字符的最长子串
 * @Author: whc
 * @UpdateUser: whc
 * @Version: 0.0.1
 * @Date: 2021/01/07/14:28
 */
// 滑动窗口
public class _3_无重复字符的最长子串 {
	/*public int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		int left = 0;
		int res = 0;
		Set<Character> set = new HashSet<>();
		for (int right = 0; right < s.length(); right++) {
			while(set.contains(s.charAt(right))) {
				set.remove(s.charAt(left));
				left++;
			}
			set.add(s.charAt(right));
			res = Math.max(res, right-left);
		}

		return res+1;
	}*/
	/*public int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		int res = 0;
		int left = 0;
		// key:字符 value:字符位置
		Map<Character, Integer> map = new HashMap<>();
		for (int right = 0; right < s.length(); right++) {
			if(map.containsKey(s.charAt(right))) {
				left = Math.max(map.get(s.charAt(right)) + 1, left);
			}
			map.put(s.charAt(right), right);
			res = Math.max(res, right-left);
		}
		return res+1;
	}*/

	// 2021/3/1 刷
	/*public static int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}

		Set<Character> set = new HashSet<>();
		int maxLength = 0;
		int left = 0;
		for (int right = 0; right < s.length(); right++) {
			while(set.contains(s.charAt(right))) {
				set.remove(s.charAt(left));
				left++;
			}
			set.add(s.charAt(right));
			maxLength = Math.max(right-left, set.size());
		}

		return maxLength;
	}*/

	public static int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		// key存放是遍历过的字符, value是下标值+1
		Map<Character, Integer> map = new HashMap<>();
		int start = 0;
		int res = 0;
		for (int end = 0; end < s.length(); end++) {
			char c = s.charAt(end);
			if(map.containsKey(c)) {
				// 保证start不会倒退
				start = Math.max(map.get(c), start);
			}
			map.put(c, end+1);
			res = Math.max(end-start+1, res);
		}
		return res;
	}

	public static void main(String[] args) {
		lengthOfLongestSubstring("aab");
	}
}
