package 待分类;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ClassName: 待分类._215_数组中的第K个最大元素
 * @Author: whc
 * @Date: 2021/03/03/8:27
 */
public class _215_数组中的第K个最大元素 {
	/*public int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}*/

	// 快速排序分治的思想
	/*public int findKthLargest(int[] nums, int k) {
		return partitionArray(nums,0, nums.length, k);
	}

	private int partitionArray(int[] nums, int left, int right, int k) {
		// 返回partition下标
		int m = partition(nums, left, right);
		int len = nums.length - k;
		if(m < len) {
			return partitionArray(nums, m+1, right, k);
		} else if(m > len) {
			return partitionArray(nums, left, m, k);
		} else {
			return nums[m];
		}
	}

	private int partition(int[] nums, int begin, int end) {
		// 备份轴点元素
		int pivot = nums[begin];

		end--;

		while(begin < end) {
			while(begin < end) {
				if(nums[end] > pivot) {
					end--;
				} else {
					nums[begin++] = nums[end];
					break;
				}
			}

			while(begin < end) {
				if(nums[begin] < pivot) {
					begin++;
				} else {
					nums[end--] = nums[begin];
					break;
				}
			}
		}

		nums[begin] = pivot;
		return begin;
	}*/

	/*public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(nums.length, (a, b) -> b - a);
		for (int i = 0; i < nums.length; i++) {
			queue.add(nums[i]);
		}
		for (int i = 0; i < k-1; i++) {
			queue.poll();
		}
		return queue.peek();
	}*/

	// 转化为最小的nums.length-k+1个数,中最大的值
	public int findKthLargest(int[] nums, int k) {
		// 1 2 3 20 5 9 12 25   k=2 7
		//  3 4 5
		int size = nums.length-k+1;
		// 最大堆
		PriorityQueue<Integer> queue = new PriorityQueue<>(size, (a, b) -> b - a);
		for (int num : nums) {
			if(queue.isEmpty() || queue.size() < size || num < queue.peek()) {
				queue.add(num);
			}
			if(queue.size() > size) {
				queue.poll();
			}
		}
		return queue.peek();
	}

}
