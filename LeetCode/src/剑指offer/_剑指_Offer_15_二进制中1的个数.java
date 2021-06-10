package 剑指offer;

/**
 * @ClassName: 剑指offer._剑指_Offer_15_二进制中1的个数
 * @Author: whc
 * @Date: 2021/04/02/0:27
 */
public class _剑指_Offer_15_二进制中1的个数 {

	// 2021/4/2 二刷
	/*public int hammingWeight(int n) {
		int res = 0;
		while(n != 0) {
			if((n & 1) == 1) {
				res++;
			}
			n >>>= 1;
		}

		return res;
	}*/

	/*public int hammingWeight(int n) {
		return Integer.toBinaryString(n).replaceAll("0", "").length();
	}
*/

	/*public int hammingWeight(int n) {
		int res = 0;
		while(n > 0) {
			n = n & n-1;
			res++;
		}
		return res;
	}*/


//	public int hammingWeight(int n) {
//		return Integer.bitCount(n);
//	}

	/*public int hammingWeight(int n) {
		int res = 0;
		// 注意负数的情况
		while(n != 0){
			if((n & 1) == 1) {
				res++;
			}
			n >>= 1;
		}
		return res;
	}*/

	/**
	 * 思路: n & (n-1)每次都会吧最后一个1变成0
	 */
	public int hammingWeight(int n) {
		int res = 0;
		while(n != 0) {
			n = n & (n-1);
			res++;
		}
		return res;
	}

}
