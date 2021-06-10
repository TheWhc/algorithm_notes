package 剑指offer;

/**
 * @ClassName: _剑指_Offer_56_II_数组中数字出现的次数II
 * @Author: whc
 * @Date: 2021/06/06/11:54
 */
public class _剑指_Offer_56_II_数组中数字出现的次数II {

	/**
	 *  思路: 位运算
	 *  1. int类型是32位,统计所有数组在某一个位置的和能否被3整除,如果不能被3整除,说明那个只出现1次的数字对应的那个位置二进制位为1
	 *  2. 所以统计所有的32位,遍历判断即可
	 */
	public int singleNumber(int[] nums) {

		int res = 0;
		for (int i = 0; i < 32; i++) {
			int oneCount = 0;
			for (int j = 0; j < nums.length; j++) {
				oneCount += (nums[j] >>> i) & 1;
			}

			if(oneCount % 3 == 1) {
				res |= 1 << i;
			}
		}

		return res;
	}
}
