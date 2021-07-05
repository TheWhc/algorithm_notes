package 哈希;

/**
 * @ClassName: _242_有效的字母异位词
 * @Author: whc
 * @Date: 2021/07/05/9:45
 */
public class _242_有效的字母异位词 {

	/**
	 * 思路: 数组统计字符的个数
	 * 1. 定义一个大小为26的数组
	 * 2. 统计s中出现字符的个数
	 * 3. 然后遍历t
	 */
	public boolean isAnagram(String s, String t) {
		int[] res = new int[26];

		for (int i = 0; i < s.length(); i++) {
			res[s.charAt(i) - 'a']++;
		}

		for (int i = 0; i < t.length(); i++) {
			if(res[t.charAt(i) - 'a'] == 0) {
				return false;
			}
			res[t.charAt(i) - 'a']--;
		}

		for (int i = 0; i < 26; i++) {
			if(res[i] != 0) {
				return false;
			}
		}

		return true;
	}
}
