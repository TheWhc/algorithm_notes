package 剑指offer;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ClassName: 剑指offer._剑指_Offer_40_最小的k个数
 * @Author: whc
 * @Date: 2021/04/02/14:58
 */
public class _剑指_Offer_40_最小的k个数 {

	/**
	 *  思路: 最大堆
	 *
	 *  时间: O(NlogK)
	 *  空间: O(K)
	 */
	/*public int[] getLeastNumbers(int[] arr, int k) {
		if(arr == null || arr.length == 0) {
			return new int[0];
		}

		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> (o2 - o1));

		for (int num : arr) {
			if(queue.isEmpty() || queue.size() < k) {
				queue.offer(num);
			} else if (queue.peek() > num) {
				queue.poll();
				queue.offer(num);
			} else {
				continue;
			}
		}

		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = queue.poll();
		}

		return res;
	}*/

	/**
	 *  思路: 快排
	 *  时间: O(n)
	 */
	public int[] getLeastNumbers(int[] arr, int k) {
		if(arr == null || arr.length == 0 || k == 0) {
			return new int[0];
		}
		if(arr.length <= k) {
			return arr;
		}
		return quickSearch(arr, 0, arr.length-1, k-1);
	}

	private int[] quickSearch(int[] arr, int left, int right, int k) {
		int mid = partition(arr, left, right);

		if(k == mid) {
			return Arrays.copyOf(arr, k+1);
		}

		if(k < mid) {
			return quickSearch(arr, left, mid-1, k);
		} else {
			return quickSearch(arr, mid+1, right, k);
		}
	}

	private int partition(int[] arr, int left, int right) {
		// 备份轴点元素
		int pivot = arr[left];

		while(left < right) {
			while(left < right) {
				if(arr[right] > pivot) {
					right--;
				} else {
					arr[left++] = arr[right];
					break;
				}
			}

			while(left < right) {
				if(arr[left] < pivot ) {
					left++;
				} else {
					arr[right--] = arr[left];
					break;
				}
			}
		}

		arr[left] = pivot;
		return left;
	}

}
