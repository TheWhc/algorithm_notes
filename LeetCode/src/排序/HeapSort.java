package 排序;

import java.util.PriorityQueue;

/**
 * @ClassName: HeapSort
 * @Author: whc
 * @Date: 2021/07/17/10:12
 */
public class HeapSort {

	public static void main(String[] args) {
		int[] array = new int[]{50,21,80,43,38,14};
		solution1(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	/**
	 * 思路：通过优先队列建立小队堆,然后依次堆顶元素依次出堆,添加到数组中
	 */
	/*public static void solution(int[] arr) {
		// 1. 建立小顶堆
		PriorityQueue<Integer> queue = new PriorityQueue<>(arr.length);

		for (int num : arr) {
			queue.offer(num);
		}

		// 2. 将堆中元素依次出队
		for (int i = 0; i < arr.length; i++) {
			arr[i] = queue.poll();
		}
	}*/

	/**
	 * 思路: 自己实现堆排序
	 *
	 * 1. 原地建堆(大顶堆)
	 * 2. 排序
	 * 		2.1 交换堆顶元素和末尾元素,使得末尾元素为最大
	 * 		2.2 交换后还要维护堆的性质,对0位置恢复堆的性质
	 *
	 * 平均时间复杂度：O(nlogn)
	 * 最好、最坏: O(nlogn)
	 * 空间: O(1)
	 * 稳定性： 不稳定
	 *
	 * 建堆时间： O(n)
	 * heapify: O(logn)
	 * 堆排序对N个数进行heapify: O(nlogn)
	 */
	public static void solution1(int[] arr) {

		// 1. 原地建堆
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			heapify(arr, arr.length, i);
		}

		// 2. 排序
		// 交换堆顶元素和末尾元素,交换后还要维护堆的性质
		for (int i = arr.length - 1; i > 0; i--) {
			swap(arr, i, 0);
			heapify(arr, i, 0);
		}
	}

	/**
	 * 维护堆的性质(大顶堆)
	 * 自下而上的下滤
	 * @param arr 存储堆的数组
	 * @param n 数组长度
	 * @param i 待维护节点的下标
	 */
	private static void heapify(int[] arr, int n, int i) {
		int largest = i;
		int lson = i * 2 + 1;
		int rson = i * 2 + 2;

		if(lson < n && arr[largest] < arr[lson]) {
			largest = lson;
		}
		if(rson < n && arr[largest] < arr[rson]) {
			largest = rson;
		}

		if(largest != i) {
			swap(arr, largest, i);
			// 递归维护交换后元素满足堆的性质
			heapify(arr, n, largest);
		}
	}

	private static void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

}
