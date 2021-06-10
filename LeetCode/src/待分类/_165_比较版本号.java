package 待分类;

/**
 * @ClassName: 待分类._165_比较版本号
 * @Author: whc
 * @Date: 2021/03/24/13:58
 */
public class _165_比较版本号 {
	/*public int compareVersion(String version1, String version2) {
		String[] s1 = version1.split("\\.");
		String[] s2 = version2.split("\\.");
		for (int i = 0; i < Math.max(s1.length, s2.length); i++) {
			int value1 = (i < s1.length) ? Integer.valueOf(s1[i]) : 0;
			int value2 = (i < s2.length) ? Integer.valueOf(s2[i]) : 0;
			if(value1 < value2) {
				return -1;
			} else if(value1 > value2) {
				return 1;
			}
 		}
		return 0;
	}*/

	public int compareVersion(String version1, String version2) {
		int len1 = version1.length();
		int len2 = version2.length();
		int index1 = 0, index2 = 0;

		for (int i = 0; i < Math.max(len1, len2); i++) {
			while(index1 < len1 && version1.charAt(index1) == '.') {
				index1++;
			}
			while(index2 < len2 && version2.charAt(index2) == '.') {
				index2++;
			}
			int curr1 = 0;
			int curr2 = 0;
			while(index1 < len1 && version1.charAt(index1) != '.') {
				curr1 = curr1 * 10 + version1.charAt(index1) - '0';
				index1++;
			}
			while(index2 < len2 && version2.charAt(index2) != '.') {
				curr2 = curr2 * 10 + version2.charAt(index2) - '0';
				index2++;
			}
			if(curr1 < curr2) {
				return -1;
			} else if(curr1 > curr2) {
				return 1;
			}
		}
		return 0;
	}


	/*while(index1 < len1 || index2 < len2) {
			while(index1 < len1 && version1.charAt(index1) == '.') {
				index1++;
			}
			while(index2 < len2 && version2.charAt(index2) == '.') {
				index2++;
			}
			int curr1 = 0;
			int curr2 = 0;
			while(index1 < len1 && version1.charAt(index1) != '.') {
				curr1 = curr1 * 10 + version1.charAt(index1) - '0';
				index1++;
			}
			while(index2 < len2 && version2.charAt(index2) != '.') {
				curr2 = curr2 * 10 + version2.charAt(index2) - '0';
				index2++;
			}
			if(curr1 < curr2) {
				return -1;
			} else if(curr1 > curr2) {
				return 1;
			}
			return 0;
		}*/

}
