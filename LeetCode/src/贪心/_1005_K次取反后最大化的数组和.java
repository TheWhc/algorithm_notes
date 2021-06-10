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
	public int largestSumAfterKNegations(int[] A, int K) {
		// 从大到小 按绝对值排序
		Integer[] array = new Integer[A.length];
		for (int i = 0; i < A.length; i++) {
			array[i] = A[i];
		}
		Arrays.sort(array, (a, b) -> {
			return Integer.compare(Math.abs(b), Math.abs(a));
		});

		for (int i = 0; i < array.length; i++) {
			if(array[i] < 0 && K > 0) {
				array[i] *= -1;
				K--;
			}
		}
		// 如果K仍然大于0,则反转数值最小的元素,将K用完
		while(K > 0) {
			array[array.length-1] *= -1;
			K--;
		}

		int res = 0;
		for (Integer num : array) {
			res += num;
		}

		return res;
	}
}
