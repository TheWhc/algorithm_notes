package CodeTop;

/**
 * @ClassName: _242_有效的字母异位词
 * @Author: whc
 * @Date: 2021/09/09/21:28
 */
public class _242_有效的字母异位词 {

	public boolean isAnagram(String s, String t) {
		int[] array = new int[26];
		for (char c : s.toCharArray()) {
			array[c - 'a'] += 1;
		}

		for (char c : t.toCharArray()) {
			array[c - 'a'] -= 1;
			if(array[c - 'a'] < 0) {
				return false;
			}
		}

		for (int i = 0; i < array.length; i++) {
			if(array[i] != 0) {
				return false;
			}
		}

		return true;
	}
}
