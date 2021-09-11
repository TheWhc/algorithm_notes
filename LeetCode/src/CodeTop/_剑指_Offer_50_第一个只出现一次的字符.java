package CodeTop;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _剑指_Offer_50_第一个只出现一次的字符
 * @Author: whc
 * @Date: 2021/09/11/16:09
 */
public class _剑指_Offer_50_第一个只出现一次的字符 {

	public char firstUniqChar(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}

		Map<Character, Boolean> map = new HashMap<>();

		for (char c : s.toCharArray()) {
			map.put(c, !map.containsKey(c));
		}

		for (char c : s.toCharArray()) {
			if(map.get(c)) {
				return c;
			}
		}

		return ' ';
	}
}
