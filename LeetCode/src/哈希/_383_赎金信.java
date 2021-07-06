package 哈希;

/**
 * @ClassName: _383_赎金信
 * @Author: whc
 * @Date: 2021/07/06/10:21
 */
public class _383_赎金信 {


	/**
	 * 思路: num数组记录字符出现的次数
	 */
	public boolean canConstruct(String ransomNote, String magazine) {
		if(ransomNote == null || magazine == null || ransomNote.length() > magazine.length()) {
			return false;
		}

		int[] num = new int[26];
		for (char c : magazine.toCharArray()) {
			num[c - 'a']++;
		}

		for (char c : ransomNote.toCharArray()) {
			if(num[c - 'a'] > 0) {
				num[c - 'a']--;
			} else {
				// ransomNote出现的字符在magazine中没有出现过,或者出现的次数大于magazine的次数
				return false;
			}

		}

		return true;
	}
}
