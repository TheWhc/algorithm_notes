package 贪心;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * @ClassName: _1005_K次取反后最大化的数组和
 * @Author: whc
 * @Date: 2021/04/12/11:48
 */
public class _1005_K次取反后最大化的数组和 {

	/**
	 * 思路: 贪心
	 * 局部最优：让绝对值大的负数变为正数
	 * 整体最优：整个数组和达到最大
	 *
	 * 1. 对数组进行排序
	 * 2. 遍历数组,遇到元素是负数,则进行反转,如果遇到正数 或者 已经有K个数反转了, 则结束循环
	 * 3. 如果还有K个数未反转完,判断此时是否为奇数,如果是奇数,则将数组进行再次排序,然后反转第一个元素
	 */
	public int largestSumAfterKNegations(int[] A, int K) {
		Arrays.sort(A);

		for (int i = 0; i < A.length; i++) {
			if(A[i] < 0) {
				A[i] = -A[i];
				K--;
			} else {
				break;
			}
		}

		if(K % 2 == 1) {
			Arrays.sort(A);
			A[0] = -A[0];
		}

		int sum = 0;
		for (int num : A) {
			sum += num;
		}

		return sum;
	}

	public static void main(String[] args) {
		_1005_K次取反后最大化的数组和 _1005_K次取反后最大化的数组和 = new _1005_K次取反后最大化的数组和();
		System.out.println(_1005_K次取反后最大化的数组和.largestSumAfterKNegations(new int[]{-5,-6,-2,-8,6,9}, 4));
	}
}
