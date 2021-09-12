package CodeTop;

/**
 * @ClassName: _260_只出现一次的数字III
 * @Author: whc
 * @Date: 2021/09/12/11:07
 */
public class _260_只出现一次的数字III {

	public static int[] singleNumber(int[] nums) {
		int diff = 0;
		for (int num : nums) {
			diff ^= num;
		}

		// 吧3 ^ 5 = 110 中最右边的1保留,其它位置全变为0
		diff &= -diff;
		int[] res = new int[2];
		for (int num : nums) {
			// 分组异或
			if((num & diff) == 0) {
				res[0] ^= num;
			} else {
				res[1] ^= num;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		singleNumber(new int[]{1,2,1,3,2,5});
		int a = 6;
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(-a));
	}

}
