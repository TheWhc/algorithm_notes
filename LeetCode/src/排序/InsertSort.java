package 排序;

/**
 * @ClassName: InsertSort
 * @Author: whc
 * @Date: 2021/07/17/12:27
 */
public class InsertSort {

	public static void main(String[] args) {
		int[] array = new int[]{50,21,80,43,38,14};
		solution(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	/**
	 * 思路: 通过构建有序序列,对于未排序数据,在已排序序列中从后向前扫描,找到相应位置并插入
	 *
	 * 平均时间: O(n^2)
	 * 最好： O(n)
	 * 最坏： O(n^2)
	 *
	 * 空间： O(1)
	 *
	 * 稳定性: 稳定
	 */
	public static void solution(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			int cur = i;
			while(cur > 0 && arr[cur] < arr[cur-1]) {
				swap(arr, cur, cur-1);
				cur--;
			}
		}
	}

	private static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
}
