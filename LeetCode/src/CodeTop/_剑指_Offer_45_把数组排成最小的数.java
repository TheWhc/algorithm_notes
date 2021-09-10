package CodeTop;

import java.util.Arrays;

/**
 * @ClassName: _剑指_Offer_45_把数组排成最小的数
 * @Author: whc
 * @Date: 2021/09/10/21:10
 */
public class _剑指_Offer_45_把数组排成最小的数 {

	public String minNumber(int[] nums) {
		String[] numsStr = new String[nums.length];

		for (int i = 0; i < nums.length; i++) {
			numsStr[i] = String.valueOf(nums[i]);
		}

		Arrays.sort(numsStr, (o1, o2) -> (o1+o2).compareTo(o2+o1));

		StringBuilder res = new StringBuilder();
		for (int i = 0; i < numsStr.length; i++) {
			res.append(numsStr[i]);
		}

		return res.toString();
	}
}
