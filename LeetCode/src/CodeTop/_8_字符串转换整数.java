package CodeTop;

/**
 * @ClassName: _8_字符串转换整数
 * @Author: whc
 * @Date: 2021/07/22/15:33
 */
public class _8_字符串转换整数 {

	public int myAtoi(String s) {
		int len = s.length();
		char[] chars = s.toCharArray();

		int index = 0;
		// 去除前导空格
		while(index < len && s.charAt(index) == ' ') {
			index++;
		}

		// 全部都为空格
		if(index == len) {
			return 0;
		}

		// 记录符号,默认为正数
		int sign = 1;

		if(s.charAt(index) == '+') {
			index++;
		} else if(s.charAt(index) == '-'){
			sign = -1;
			index++;
		}

		// 结果
		int res = 0;

		// 转化字符串为整数
		while(index < len) {

			char curChar = s.charAt(index);
			// 遇到不合法的字符,跳出循环
			if(curChar < '0' || curChar > '9') {
				break;
			}

			// 处理整数溢出的情况
			// 负数的情况时
			if((res == Integer.MIN_VALUE / 10 && (curChar - '0') < Integer.MIN_VALUE % 10) ||
			res < Integer.MIN_VALUE / 10) {
				return Integer.MIN_VALUE;
			}

			if((res == Integer.MAX_VALUE / 10 && (curChar - '0') > Integer.MAX_VALUE % 10) ||
			res > Integer.MAX_VALUE / 10) {
				return Integer.MAX_VALUE;
			}


			res = res * 10 + sign * (curChar - '0');
			index++;
		}

		return res;
	}
}
