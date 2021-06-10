package 剑指offer;

/**
 * @ClassName: _剑指_Offer_67_把字符串转换成整数
 * @Author: whc
 * @Date: 2021/06/10/13:22
 */
public class _剑指_Offer_67_把字符串转换成整数 {

	public static int strToInt(String str) {
		char[] chars = str.trim().toCharArray();

		if(chars.length == 0) {
			return 0;
		}

		int res = 0;
		// 1表示正数,-1表示负数
		int sign = 1;

		// 处理越界的情况
		int a = Integer.MAX_VALUE / 10;

		// 从非符号位开始
		int index = 1;

		if(chars[0] == '-') {
			sign = -1;
		} else if(chars[0] != '+') {
			// 说明没有符号位,则默认为正数,下标从0开始
			index = 0;
		}

		for (int i = index; i < chars.length; i++) {
			// 遇到非数字的时候,结束循环
			if(chars[i] < '0' || chars[i] > '9') {
				break;
			}
			// 越界
			// 若res = 214748365以上, 则 10×res > 2147483647
			// 若res = 214748364, 且 后面紧跟着数字 > 7, 则 10×res > 2147483647
			// 注意这里的 > 7 巧妙的把负数的情况也包含了进来,结果依然正确
			if(res > a || (res == a) && (chars[i] - '0') > Integer.MAX_VALUE % 10) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			res = res * 10 + (chars[i] - '0');
		}

		return res * sign;
	}

	public static void main(String[] args) {
		System.out.println(strToInt("-2147483648"));
	}

}
