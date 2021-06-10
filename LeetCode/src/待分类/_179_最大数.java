package 待分类;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * @ClassName: 待分类._179_最大数
 * @Author: whc
 * @Date: 2021/03/29/10:52
 */
public class _179_最大数 {

	public String largestNumber(int[] nums) {
		String[] str = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			str[i] = String.valueOf(nums[i]);
		}

		Arrays.sort(str, (s1, s2) -> {
			return (s2 + s1).compareTo(s1 + s2);
		});

		StringBuffer sb = new StringBuffer();
		for (String s : str) {
			sb.append(s);
		}

		String result = sb.toString();
		if(result.charAt(0) == '0') {
			result = "0";
		}

		return result;
	}
}
