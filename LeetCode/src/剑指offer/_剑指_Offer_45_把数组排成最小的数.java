package 剑指offer;

import java.util.Arrays;

/**
 * @ClassName: _剑指_Offer_45_把数组排成最小的数
 * @Author: whc
 * @Date: 2021/06/02/9:55
 */
public class _剑指_Offer_45_把数组排成最小的数 {

	/**
	 *  思路: 字符串的快排
	 *  例子: [3,30]
	 *  330 > 303,所以两者交换顺序,小的排在前面
	 *  最后结果为303
	 *
	 *  因此,利用快速排序定义数组,传入比较规则
	 *
	 *  时间: O(nlogn)
	 *  空间: O(n)
	 */
	public String minNumber(int[] nums) {
		String[] stringNums = new String[nums.length];
		for(int i = 0; i < nums.length; i++) {
			stringNums[i] = String.valueOf(nums[i]);
		}

		Arrays.sort(stringNums, (o1, o2) -> (o1 +  o2).compareTo(o2 + o1));

		StringBuilder res = new StringBuilder();
		for(String num : stringNums) {
			res.append(num);
		}

		return res.toString();
	}

}
