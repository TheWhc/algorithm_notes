package 待分类;

/**
 * @ClassName: 待分类._43_字符串相乘
 * @Author: whc
 * @Date: 2021/03/05/10:16
 */
public class _43_字符串相乘 {
	/*public String multiply(String num1, String num2) {
		if(num1.equals("0") || num2.equals("0"))
			return "0";
		int len1 = num1.length();
		int len2 = num2.length();
		int[] res = new int[len1 + len2];
		for (int i = len2-1; i >= 0; i--) {
			for (int j = len1-1; j >= 0; j--) {
				int mul = (num1.charAt(j) - '0') * (num2.charAt(i) - '0');
				int p1 = i + j;
				int p2 = i + j + 1;
				int sum = mul + res[p2];
				res[p2] = sum % 10;
				res[p1] += sum / 10;
			}
		}

		// 从不为0的下标开始
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < res.length; i++) {
			// 剔除首位可能为0的情况
			if(res[i] == 0 && i == 0)
				continue;
			sb.append(res[i]);
		}

		return sb.toString();
	}
*/

	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}

		String res = "0";

		// num2逐位与num1相乘
		for (int i = num2.length() - 1; i >= 0; i--) {
			int carry = 0;
			// 保存num2第i位与num1相乘的结果
			StringBuffer temp = new StringBuffer();
			// 补0
			for (int j = 0; j < num2.length()-1-i; j++) {
				temp.append("0");
			}
			int n2 = num2.charAt(i) - '0';
			int j = num1.length() - 1;
			while(j >= 0 || carry != 0) {
				int n1 = j >= 0 ? num1.charAt(j) - '0' : 0;
				temp.append((n1 * n2 + carry) % 10);
				carry = (n1 * n2 + carry) / 10;
				j--;
			}
			// 将当前计算结果与新计算结果相加作为新的结果
			res = addStrings(res, temp.reverse().toString());
		}

		return res;
	}

	private String addStrings(String s1, String s2) {
		StringBuffer result = new StringBuffer();
		int i = s1.length() - 1;
		int j = s2.length() - 1;
		int carry = 0;
		while(i >= 0 || j >= 0 || carry != 0) {
			int n1 = i >= 0 ? s1.charAt(i) - '0' : 0;
			int n2 = j >= 0 ? s2.charAt(j) - '0' : 0;
			result.append((n1 + n2 + carry) % 10);
			carry = (n1 + n2 + carry) / 10;
			i--;
			j--;
		}

		return result.reverse().toString();
	}
}
