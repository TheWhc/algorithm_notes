package 排序;

/**
 * @ClassName: ShellSort
 * @Author: whc
 * @Date: 2021/07/17/15:01
 */
public class ShellSort {

	public static void main(String[] args) {
		int[] arr = new int[]{15,5,2,7,12,6,1,4,3,9,8,10};
		shellSort(arr, arr.length);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	/*private static void shellSort(int[] arr, int n) {
		int j;

		// 初始增量:n/2, 每一趟之后除以2
		for (int inc = n/2;  inc > 0; inc /= 2) {
			// 每一趟采用插入排序
			for (int i = inc;  i < n; i++) {
				int key = arr[i];
				for (j = i; j >= inc && key < arr[j - inc]; j -= inc) {
					arr[j] = arr[j - inc];
				}
				arr[j] = key;
			}

			for (int k = 0; k < arr.length; k++) {
				System.out.print(arr[k] + " ");
			}
			System.out.println();
		}
	}*/

	/**
	 * 思路： 插入排序算法的改进
	 * 在数组中采用跳跃式分组的策略,通过某个增量将数组元素划分为若干组,然后分组进行插入排序
	 * 随后逐步缩小增量,继续按组进行插入排序操作,直至增量为1
	 *
	 * 时间复杂度: 介于O(n)到O(n^2)之间
	 *
	 * 空间复杂度: O(1)
	 *
	 * 稳定性: 不稳定
	 */
	private static void shellSort(int[] arr, int n) {
		// 初始增量:n/2, 每一趟之后除以2
		for (int inc = n/2;  inc > 0; inc /= 2) {
			// 每一趟采用插入排序,从第inc个元素,逐个对其所在组进行直接插入排序操作
			for (int i = inc;  i < n; i++) {
				int cur = i;
				while(cur-inc >= 0 && arr[cur] < arr[cur-inc]) {
					swap(arr, cur, cur-inc);
					cur = cur - inc;
				}
			}
 		}
	}

	private static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
}
