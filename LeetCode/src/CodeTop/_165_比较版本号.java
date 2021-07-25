package CodeTop;

/**
 * @ClassName: _165_比较版本号
 * @Author: whc
 * @Date: 2021/07/25/22:20
 */
public class _165_比较版本号 {

/*	public int compareVersion(String version1, String version2) {
		String[] s1 = version1.split("\\.");
		String[] s2 = version2.split("\\.");

		int p = 0;
		int q = 0;

		while (p < s1.length && q < s2.length) {
			if (Integer.parseInt(s1[p]) < Integer.parseInt(s2[p])) {
				return -1;
			} else if (Integer.parseInt(s1[p]) > Integer.parseInt(s2[p])) {
				return 1;
			} else {
				p++;
				q++;
			}
		}

		while (p < s1.length) {
			if(Integer.parseInt(s1[p]) == 0) {
				p++;
			} else {
				return 1;
			}
		}

		while (q < s2.length) {
			if(Integer.parseInt(s2[q]) == 0) {
				q++;
			} else {
				return -1;
			}
		}

		return 0;
	}*/

	public int compareVersion(String version1, String version2) {
		int len1 = version1.length();
		int len2 = version2.length();

		int idx1 = 0;
		int idx2 = 0;

		for (int i = 0; i < Math.max(len1, len2); i++) {
			if(idx1 < len1 && version1.charAt(idx1) == '.') {
				idx1++;
			}

			if(idx2 < len2 && version2.charAt(idx2) == '.') {
				idx2++;
			}

			int cur1 = 0;
			int cur2 = 0;

			while(idx1 < len1 && version1.charAt(idx1) != '.') {
				cur1 = cur1 * 10 + (version1.charAt(idx1) - '0');
				idx1++;
			}

			while(idx2 < len2 && version2.charAt(idx2) != '.') {
				cur2 = cur2 * 10 + (version2.charAt(idx2) - '0');
				idx2++;
			}

			if(cur1 < cur2) {
				return -1;
			} else if(cur1 > cur2) {
				return 1;
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		_165_比较版本号 _165_比较版本号 = new _165_比较版本号();
		_165_比较版本号.compareVersion(
				"1.0.1","1");
	}
}
