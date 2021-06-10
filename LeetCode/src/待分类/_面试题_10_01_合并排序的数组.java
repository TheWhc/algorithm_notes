package 待分类;

/**
 * @ClassName: 待分类._面试题_10_01_合并排序的数组
 * @Author: whc
 * @Date: 2021/04/02/21:30
 */
public class _面试题_10_01_合并排序的数组 {

	public void merge(int[] A, int m, int[] B, int n) {
		m -= 1;
		n -= 1;
		int index = A.length-1;
		while(m >= 0 && n >= 0) {
			if(A[m] < B[n]) {
				A[index--] = B[n--];
			} else {
				A[index--] = A[m--];
			}
		}

		while(n >= 0) {
			A[index--] = B[n--];
		}
	}
}
