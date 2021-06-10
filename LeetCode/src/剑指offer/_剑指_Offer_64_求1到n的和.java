package 剑指offer;

/**
 * @ClassName: _剑指_Offer_64_求1到n的和
 * @Author: whc
 * @Date: 2021/06/09/13:59
 */
public class _剑指_Offer_64_求1到n的和 {

	/**
	 * 思路: 逻辑符短路
	 *
	 * 1. 不能使用乘法和除法符号
	 * 2. 不能使用if,for,while
	 * 3. 所以使用&& 与逻辑符 判断终止条件,使得递归终止
	 */
	/*int sum = 0;
	public int sumNums(int n) {
		boolean x = n > 1 && sumNums(n-1) > 0;
		sum += n;
		return sum;
	}*/

	public int sumNums(int n) {
		boolean x = n > 1 && (n += sumNums(n-1)) > 0;
		return n;
	}
}
