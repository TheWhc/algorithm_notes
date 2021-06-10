package 待分类;

import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * @ClassName: 待分类._7_整数反转
 * @Author: whc
 * @Date: 2021/03/29/11:43
 */
public class _7_整数反转 {
	/*public int reverse(int x) {
		StringBuffer sb = new StringBuffer();
		int flag = 0; // 是否为负数
		if(x < 0) {
			flag = 1;
			x = -x;
		}
		while(x > 0) {
			sb.append(x % 10);
			x /= 10;
		}
		int index = 0;
		while(sb.charAt(index) == '0') {
			index++;
		}
		String revString = sb.toString().substring(index);
		if(flag == -1) {
			revString = "-" + revString;
		}
		return Integer.valueOf(revString);
	}*/

	public static int reverse(int x) {
		int res = 0;
		while(x != 0) {
			int tmp = x % 10;

			// 溢出判断
			if(res > Integer.MAX_VALUE / 10 || ((res == Integer.MAX_VALUE / 10) && tmp > Integer.MAX_VALUE % 10)) {
				return 0;
			}

			if(res < Integer.MIN_VALUE / 10 || ((res == Integer.MIN_VALUE / 10)) && tmp < Integer.MIN_VALUE % 10) {
				return 0;
			}

			res = res * 10 + tmp;
			x /= 10;
		}
		return res;
	}

}
