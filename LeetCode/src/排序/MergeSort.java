package 排序;

/**
 * @ClassName: MergeSort
 * @Author: whc
 * @Date: 2021/03/30/14:51
 */

public class MergeSort {

	/**
	 * 思路: 分治和递归的思想
	 * 1. 不断将数组二分划分,最后划分到只剩一个单独的元素
	 * 2. 将划分出来的左区间和右区间的元素进行合并(排序的过程)
	 *     - l_post标记左区间未排序的第一个元素
	 *     - r_post标记右区间未排序的第一个元素
	 *     - pos临时数组下标
	 *     需要用到一个临时数组tempArr[]存储合并过程中的元素,最后将临时数组的元素复制回原来的数组中
	 *
	 * 时间: O(NlogN)    -> 每一层归并的时间是O(N),归并层数最大为O(logN+1)
	 * 空间: O(N)        -> 一个临时数组
	 */
	public static void main(String[] args) {
		int[] arr = new int[]{7,5,6,4};
		// 分配一个辅助数组
		int[] tmp = new int[arr.length];
		mergeSort(arr, 0, arr.length - 1, tmp);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

	private static void mergeSort(int[] arr, int left, int right, int[] tmp) {
		// 如果只有一个元素,那么就不需要继续划分
		// 只有一个元素的区域,本来就是有序的,只需要被归并即可
		if(left < right) {
			// 找中间点
			int mid = (left + right) >> 1;
			// 左闭右闭
			// 递归划分左半区
			mergeSort(arr, left, mid, tmp);
			// 递归划分右半区
			mergeSort(arr, mid + 1, right, tmp);
			// 合并已经排序的部分
			merge(arr, left, mid, right, tmp);
		}
	}

	private static void merge(int[] arr, int left, int mid, int right, int[] tempArr) {
		// 标记左半区第一个未排序的元素
		int l_pos = left;
		// 标记右半区第一个未排序的元素
		int r_pos = mid+1;
		// 临时数组元素的下标
		int pos = left;

		// 合并
		while(l_pos <= mid && r_pos <= right) {
			if(arr[l_pos] < arr[r_pos]) {
				tempArr[pos++] = arr[l_pos++];
			} else {
				tempArr[pos++] = arr[r_pos++];
			}
		}

		// 合并左半区剩余的元素
		while(l_pos <= mid) {
			tempArr[pos++] = arr[l_pos++];
		}

		// 合并右半区剩余的元素
		while(r_pos <= right) {
			tempArr[pos++] = arr[r_pos++];
		}

		// 把临时数组中的元素复制回原来的数组
		while(left <= right) {
			arr[left] = tempArr[left];
			left++;
		}
	}

}
