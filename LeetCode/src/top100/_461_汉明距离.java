package top100;

/**
 * @ClassName: _461_汉明距离
 * @Author: whc
 * @Date: 2021/05/01/22:55
 */
public class _461_汉明距离 {

	// 统计二进制中个数不同有多少个
	/*public int hammingDistance(int x, int y) {
		return Integer.bitCount(x ^ y);
	}*/

	public int hammingDistance(int x, int y) {
		int res = x ^ y;
		int count = 0;
		while(res != 0) {
			if(res % 2 == 1) {
				count++;
			}
			res >>= 1;
		}

		return count;
	}
}
