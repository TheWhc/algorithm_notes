package 剑指offer;

/**
 * @ClassName: _剑指_Offer_16_数值的整数次方
 * @Author: whc
 * @Date: 2021/05/26/0:29
 */
public class _剑指_Offer_16_数值的整数次方 {

	public static void main(String[] args) {
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Math.pow(-1, Integer.MIN_VALUE));
	}


	/**
	 *  思路: 快速幂(递归)
	 *  1. 如果n == 0，返回1
	 *  2. 如果n < 0，最终结果为  1 / (x * myPow(x, -n-1));  即 1/x^(-n)
	 *  3. 如果n为奇数，最终结果为 x * myPow(x, n-1);  即x * x^(n-1)
	 *  4. 如果n为偶数，最终结果为 myPow(x * x, n >> 1); 即 (x^2)^(n/2)
	 *
	 *  因为有n=Integer.MIN_VALUE的存在,取反后会溢出,所以提取一个x出来,这样就不会溢出了
	 */
	/* 	public double myPow(double x, int n) {
 		if(n == 0) {
 			return 1;
 		}
 		if(n < 0) {
 			// 如果x = Integer.MIN_VALUE -2147483648,则取反还是本身
 //			return myPow(1/x, -n);

 			return 1 / (x * myPow(x, -n-1));
 		}
 		// 偶数
 		if((n & 1) == 0) {
 			return myPow(x * x, n >> 1);
 		} else {
 			// 奇数
 			return x * myPow(x, n-1);
 		}
 	}*/

	/**
	 *  思路: 快速幂(递归)
	 *  1. 提前对n为Integer.MIN_VALUE作判断,如果x==±1,那么返回1,否则返回0
	 *  2. 如果n == 0，返回1
	 *  3. 如果n < 0，最终结果为  myPow(1/x, -n);  即 (1/x)^(-n)
	 *  4. 如果n为奇数，最终结果为 x * myPow(x, n-1);  即x * x^(n-1)
	 *  5. 如果n为偶数，最终结果为 myPow(x * x, n >> 1); 即 (x^2)^(n/2)
	 *
	 *  因为有n=Integer.MIN_VALUE的存在,取反后会溢出,所以提取一个x出来,这样就不会溢出了
	 */
	public double myPow(double x, int n) {

		// 除了1和-1都是为1外,其余都是0
		if(n == Integer.MIN_VALUE) {
			return (x == 1 || x == -1) ? 1 : 0;
		}

		if(n == 0) {
			return 1;
		}

		if(n < 0) {
			// 如果x = Integer.MIN_VALUE -2147483648,则取反还是本身,除了第一种方案往外提出一个数外,还可以单独对这个条件判断
			return myPow(1/x, -n);
		}

		// 偶数
		if((n & 1) == 0) {
			return myPow(x * x, n >> 1);
		} else {
			// 奇数
			return x * myPow(x, n-1);
		}
	}
}
