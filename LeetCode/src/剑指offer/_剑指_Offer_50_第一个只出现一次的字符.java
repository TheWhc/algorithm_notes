package 剑指offer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName: 剑指offer._剑指_Offer_50_第一个只出现一次的字符
 * @Author: whc
 * @Date: 2021/04/02/11:11
 */
public class _剑指_Offer_50_第一个只出现一次的字符 {

	/**
	 *  思路: 哈希表
	 *
	 */
	public char firstUniqChar(String s) {
		if(s == null || s.length() == 0) {
			return ' ';
		}
		Map<Character, Boolean> map = new HashMap<>();

		char[] chars = s.toCharArray();

		for (char c : chars) {
			map.put(c, !map.containsKey(c));
		}

		for (char c : chars) {
			if(map.get(c)) {
				return c;
			}
		}

		return ' ';
	}
}
