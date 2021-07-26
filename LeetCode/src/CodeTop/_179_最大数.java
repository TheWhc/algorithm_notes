package CodeTop;

import java.util.Arrays;

/**
 * @ClassName: _179_最大数
 * @Author: whc
 * @Date: 2021/07/26/1:27
 */
public class _179_最大数 {

	// 转化为字符串类型,然后对字符串数组进行按照自定义比较器规则进行快速排序
	public String largestNumber(int[] nums) {
		String[] stringNums = new String[nums.length];

		for (int i = 0; i < nums.length; i++) {
			stringNums[i] = String.valueOf(nums[i]);
		}

		// 按照从大到小排序, 比如"1"和"23" 排序的结果是"23","1" 因为"231" > "123"
		Arrays.sort(stringNums, (o1, o2) -> {
			return (o2 + o1).compareTo(o1 + o2);
		});

		StringBuilder res = new StringBuilder();
		for (String stringNum : stringNums) {
			res.append(stringNum);
		}

		// 注意这里的拼接结果最后如果是"000",那么应该返回"0"
		if(res.charAt(0) == '0') {
			return "0";
		}

		return res.toString();
	}
}
