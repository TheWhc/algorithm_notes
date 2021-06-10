package 剑指offer;

/**
 * @ClassName: _剑指_Offer_43_1到n整数中1出现的次数
 * @Author: whc
 * @Date: 2021/06/01/10:52
 */
public class _剑指_Offer_43_1到n整数中1出现的次数 {


	/**
	 *  思路: 数学问题
	 *  例子3 1 0  1  5 9 2
	 *  high cur low
	 *  左边high = n / base / 10, 当前位cur = n / base % 10, 右边low = n % base
	 *
	 *  1. cur此时指向3101(5)92 即百位时为5
	 *  此时cur>1时, base=100,则假设百位为1时
	 *  左边高位范围(0,3101),右边低位范围(0,99)
	 *  当cur>1时,方案数(high + 1) * base 方案
	 *
	 *  2. cur此时指向310(1)592 即千位时为1
	 *  此时cur==1时,base=1000,则假设千位为1时
	 *  分两种情况讨论
	 *   2.1 左边高位范围(0,309),右边低位范围(0,999) 方案数为 high * base
	 *   2.2 左边高位范围(310,310),右边低位范围(0,592) 方案数为 low + 1
	 *   综上,当cur==1时,方案数=hig * base + low + 1
	 *
	 *  3. cur此时指向31(0)1592 即万位时为0
	 *  此时cur==0, base=10000,则假设万位为1时
	 *  左边高位范围(0,30) 右边低位范围(0,9999)
	 *  当cur==0时, 方案数 high * base
	 */
	public int countDigitOne(int n) {

		long base = 1;
		int res = 0;
		while(base <= n) {
			long high = n / base / 10;
			long low = n % base;
			long cur = n / base % 10;
			if(cur > 1) {
				res += (high + 1) * base;
			} else if(cur == 1) {
				res += high * base + low + 1;
			} else {
				res += high * base;
			}
			base *= 10;
		}
		return res;
	}
}
