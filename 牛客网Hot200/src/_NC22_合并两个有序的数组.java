/**
 * @ClassName: _NC22_合并两个有序的数组
 * @Author: whc
 * @Date: 2021/02/22/9:24
 */
public class _NC22_合并两个有序的数组 {

	public void merge(int A[], int m, int B[], int n) {
		int i = m-1, j = n-1;
		int k = m+n-1;

		// 从后往前放
		while(i >= 0 && j >= 0) {
			if(A[i] > B[j]) {
				A[k--] = A[i--];
			} else {
				A[k--] = B[j--];
			}
		}

		while(i >= 0) {
			A[k--] = A[i--];
		}

		while(j >= 0) {
			A[k--] = B[j--];
		}
	}

}
