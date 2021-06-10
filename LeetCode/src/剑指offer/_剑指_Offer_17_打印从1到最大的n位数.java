package 剑指offer;

/**
 * @ClassName: 剑指offer._剑指_Offer_17_打印从1到最大的n位数
 * @Author: whc
 * @Date: 2021/04/01/23:35
 */
public class _剑指_Offer_17_打印从1到最大的n位数 {

	/*public int[] printNumbers(int n) {
		int[] res = new int[(int)Math.pow(10, n)-1];
		for (int i = 0; i < res.length; i++) {
			res[i] = i + 1;
		}
		return res;
	}*/

	/**
	 *  思路: 如果String[], 则大数的话,要全排列
	 *
	 *  由于返回值是int,为了测试通过,最后把字符串变成int,其实应该返回字符串数组
	 *
	 *  1. 为了避免数字开头0出现,先把首位first固定,first取值范围是1~9
	 *  2. 用digit表示要生成的数字的位数,从1位数一值生成n位数,对每种数字的位数都生成下一个首位,所以有个双重for循环,
	 *   生成首位之后进入递归生成剩下的digit-1位数,从0~9中取值
	 *  3. 递归终止条件是已生成了digit位的数字,即index=digit,将此时的数num转为int加到结果res中
	 *  		比如n=2,  digit = 1,2 当digit=1时,先固定首位,首位范围是1~9
	 *  				   			 当digit=2时,先固定首位(1~9),那么第二位对每种数字生成(0~9)
	 * 时间复杂度: O(10^n) -> 1~10^n-1都遍历了一遍
	 * 额外空间: O(n)   -> num数组和递归栈
	 */

	public static void main(String[] args) {
		_剑指_Offer_17_打印从1到最大的n位数 a = new _剑指_Offer_17_打印从1到最大的n位数();
		a.printNumbers(1);
	}

	int[] res;
	int count = 0;
	public int[] printNumbers(int n) {
		res = new int[(int)Math.pow(10,n) - 1];
		for (int digit = 1; digit <= n; digit++) {
			for (char first = '1'; first <= '9'; first++) {
				char[] num = new char[digit];
				num[0] = first;
				// 生成首位之后进入递归生成剩下的digit-1位数,从0~9中取值
				dfs(1, num, digit);
			}
		}

		return res;
	}

	private void dfs(int index, char[] num, int digit) {
		// 递归终止条件
		if(index == digit) {
			res[count++] = Integer.parseInt(String.valueOf(num));
			return;
		}

		// 从0~9中取值
		for (char i = '0'; i <= '9'; i++) {
			num[index] = i;
			dfs(index + 1, num, digit);
		}
	}
}
