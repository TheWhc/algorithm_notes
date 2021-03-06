package 剑指offer;

/**
 * @ClassName: 剑指offer._剑指_Offer_65_不用加减乘除做加法
 * @Author: whc
 * @Date: 2021/04/02/13:17
 */
public class _剑指_Offer_65_不用加减乘除做加法 {

	/**
	 *  思路: 位运算
	 *
	 *  1. 将两个数的和拆为两步骤,
	 *     第一步骤是忽略进位,计算直接相加(^异或运算)
	 *     第二步骤是计算进位和
	 *     最后将第一步骤和第二步骤的结果相加即可(又重新回到两个数相加,那么重复第一和第二步骤)
	 *
	 *  2. 对于直接相加,可以直接两个数进行异或运算得到结果
	 *  3. 对于计算进位和, 先进行与运算,再左移一位
	 *
	 *  例子: 比如 1100(12) + 1111(15)
	 *  1. 直接相加结果 = 0011
	 *  2. 进位结果  = 11000
	 *  3. 最后结果 11011 (十进制27)
	 */
	public int add(int a, int b) {
		while(b != 0) {
			int x = a ^ b;
			int y = (a & b) << 1;
			a = x;
			b = y;
		}
		return a;
	}
}
