package 剑指offer;

/**
 * @ClassName: _剑指_Offer_66_构建乘积数组
 * @Author: whc
 * @Date: 2021/06/10/11:24
 */
public class _剑指_Offer_66_构建乘积数组 {


	/**
	 *  思路: 左边的乘积乘以右边的乘积
	 *
	 *  1. 构造左边乘积数组,不包含当前元素
	 *  2. 构造右边乘积数组,不包含当前元素
	 *  3. 构造结果集,将左边乘积数组 与 右边乘积数组 对应元素相乘得到结果
	 */
	public int[] constructArr(int[] a) {
		if(a == null || a.length == 0) {
			return new int[0];
		}
		int length = a.length;
		// 构造左边乘积
		int[] resLeft = new int[length];
		// 构造右边乘积
		int[] resRight = new int[length];

		resLeft[0] = 1;
		resRight[length-1] = 1;

		for (int i = 1; i < length; i++) {
			resLeft[i] = resLeft[i-1] * a[i-1];
		}

		int[] res = new int[length];

		for (int i = length-2; i >= 0; i--) {
			resRight[i] = resRight[i+1] * a[i+1];
		}


		for (int i = 0; i < length; i++) {
			res[i] = resLeft[i] * resRight[i];
		}

		return res;
	}
}
