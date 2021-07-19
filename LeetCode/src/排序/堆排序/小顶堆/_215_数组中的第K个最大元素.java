package 排序.堆排序.小顶堆;

/**
 * @ClassName: _215_数组中的第K个最大元素
 * @Author: whc
 * @Date: 2021/07/19/10:05
 */
public class _215_数组中的第K个最大元素 {

	// 最小堆
	/*public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(k);

		for (int num : nums) {
			// 入堆
			if(queue.isEmpty() || queue.size() < k || queue.peek() < num) {
				queue.offer(num);
			}
			if(queue.size() > k) {
				queue.poll();
			}
		}

		return queue.peek();
	}*/

	/**
	 * 思路: 实现一个小根堆
	 */
	public int findKthLargest(int[] nums, int k) {
		if(k > nums.length) {
			return Integer.MIN_VALUE;
		}

		// 原地建堆
		for (int i = nums.length / 2 - 1; i >= 0; i--) {
			heapify(nums, nums.length, i);
		}

		// 交换堆顶和末尾元素,交换后还要维护堆的性质
		for (int i = nums.length - 1; i >= k; i--) {
			swap(nums, i, 0);
			heapify(nums, i, 0);
		}

		return nums[0];
	}

	private void heapify(int[] nums, int n, int i) {
		int largest = i;
		int lson = largest * 2 + 1;
		int rson = largest * 2 + 2;
		if(lson < n && nums[largest] > nums[lson]) {
			largest = lson;
		}
		if(rson < n && nums[largest] > nums[rson]) {
			largest = rson;
		}
		if(largest != i) {
			swap(nums, largest, i);
			heapify(nums, n, largest);
		}
	}

	private void swap(int[] nums, int idx1, int idx2) {
		int temp = nums[idx1];
		nums[idx1] = nums[idx2];
		nums[idx2] = temp;
	}

	public static void main(String[] args) {
		_215_数组中的第K个最大元素 _215_数组中的第K个最大元素 = new _215_数组中的第K个最大元素();
		System.out.println(_215_数组中的第K个最大元素.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
	}
}
