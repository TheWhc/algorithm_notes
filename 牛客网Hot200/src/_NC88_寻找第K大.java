/**
 * @ClassName: _NC88_寻找第K大
 * @Author: whc
 * @Date: 2021/01/30/0:52
 */
public class _NC88_寻找第K大 {
	public int findKth(int[] a, int n, int K) {
		// write code here
		// 原地不断划分数组
		return partitionArray(a, 0, n, K);

	}

	private int partitionArray(int[] a, int begin, int end, int k) {
		// 做一次partition操作
		int m = partition(a, begin, end);
		/*if(k == m+1) {
			return a[m];
			//  5 < 5+1
		} else if(k < m+1) {
			return partitionArray(a, begin, m, k);
		} else {
			// 7 > 5+1
			return partitionArray(a, m+1, end, k);
		}*/

		if(m + 1 < k) {
			return partitionArray(a, m+1, end, k);
		} else if(m + 1 > k) {
			return partitionArray(a, begin, m, k);
		} else {
			return a[m];
		}
	}

	private int partition(int[] a, int begin, int end) {
		// 备份轴点
		int pivot = a[begin];
		end--;

		while(begin < end) {

			while(begin < end) {
				if(a[end] > pivot) {
					end--;
				} else {
					a[begin] = a[end];
					begin++;
					break;
				}
			}

			while(begin < end) {
				if(a[begin] < pivot) {
					begin++;
				} else {
					a[end] = a[begin];
					end--;
					break;
				}
			}
		}
		a[begin] = pivot;
		return begin;
	}
}
