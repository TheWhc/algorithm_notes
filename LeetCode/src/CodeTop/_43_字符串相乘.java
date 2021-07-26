package CodeTop;

/**
 * @ClassName: _43_字符串相乘
 * @Author: whc
 * @Date: 2021/07/26/12:08
 */
public class _43_字符串相乘 {

	public String multiply(String num1, String num2) {
		if(num1.equals("0") || num2.equals("0")) {
			return "0";
		}

		int len1 = num1.length();
		int len2 = num2.length();
		int[] res = new int[len1 + len2];

		for (int i = len2-1; i >= 0; i--) {
			for (int j = len1-1; j >= 0; j--) {
				int p = i + j;
				int q = i + j + 1;
				int sum = (num1.charAt(j) - '0') * (num2.charAt(i) - '0');
				sum += res[q];
				res[p] += sum / 10;
				res[q] = sum % 10;
			}
		}

		// 拼接数组
		int idx = 0;
		while(res[idx] == 0) {
			idx++;
		}
		StringBuilder ans = new StringBuilder();
		for (int i = idx; i < res.length; i++) {
			ans.append(res[i]);
		}

		return ans.toString();
	}

	public static void main(String[] args) {
		_43_字符串相乘 _43_字符串相乘 = new _43_字符串相乘();
		_43_字符串相乘.multiply("123", "456");
	}
}
