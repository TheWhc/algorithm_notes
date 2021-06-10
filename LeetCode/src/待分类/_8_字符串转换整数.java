package 待分类;

/**
 * @ClassName: 待分类._8_字符串转换整数
 * @Author: whc
 * @Date: 2021/03/20/18:23
 */
public class _8_字符串转换整数 {

	public int myAtoi(String s) {
		int len = s.length();
		char[] charArray = s.toCharArray();

		// 去除前导空格 不用s.trim()会产生新的变量
		int index = 0;
		while(index < len && charArray[index] == ' ') {
			index++;
		}

		// 比如"         "
		if(index == len) {
			return 0;
		}

		// 记录符号
		int sign = 1;
		char firstChar = charArray[index];
		if(firstChar == '+') {
			index++;
		} else if(firstChar == '-') {
			sign = -1;
			index++;
		}

		// 不能使用long类型,由于环境限制32位整数
		int res = 0;
		while(index < len) {
			char curChar = charArray[index];
			// 判断不合法的情况
			if(curChar > '9' || curChar < '0') {
				break;
			}

            // 	2147483647		   (res > 214748364 ||(res==214748364 && tmp>=7))
			if(res > Integer.MAX_VALUE / 10 ||  (res == Integer.MAX_VALUE/10 && (curChar - '0') > Integer.MAX_VALUE % 10)) {
				return Integer.MAX_VALUE;
			}
			// -2147483648		   (res < -214748364 || (res==-214748364 && tmp>=8))
			if(res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE/10 && (curChar - '0') > -(Integer.MIN_VALUE % 10))) {
				return Integer.MIN_VALUE;
			}

			res = res * 10 + sign * (curChar - '0');
			index++;
		}

		return res;
	}

	public static void main(String[] args) {
		System.out.println(Integer.MIN_VALUE);
	}

}
