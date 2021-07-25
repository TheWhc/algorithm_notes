package CodeTop;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @ClassName: _239_滑动窗口最大值
 * @Author: whc
 * @Date: 2021/07/25/9:00
 */
public class _239_滑动窗口最大值 {

	/*public int[] maxSlidingWindow(int[] nums, int k) {
		int left = 0;
		int right = 0;
		int[] res = new int[nums.length - k + 1];
		int idx = 0;
		LinkedList<Integer> queue = new LinkedList<>();
		while(right < nums.length) {
			while(!queue.isEmpty() && nums[queue.peekLast()] < nums[right]) {
				queue.pollLast();
			}

			queue.offerLast(right);

			if(right - left + 1 == k) {
				res[idx++] = nums[queue.peekFirst()];

				if(nums[queue.peekFirst()] == nums[left]) {
					queue.pollFirst();
				}
				left++;
			}
			right++;
		}

		return res;
	}*/


	public int[] maxSlidingWindow(int[] nums, int k) {
		int left = 0;
		int right = 0;
		int[] res = new int[nums.length - k + 1];
		int idx = 0;
		LinkedList<Integer> queue = new LinkedList<>();
		while(right < nums.length) {
			while(!queue.isEmpty() && queue.peekLast() < nums[right]) {
				queue.pollLast();
			}

			queue.offerLast(nums[right]);

			if(right - left + 1 == k) {
				res[idx++] = queue.peekFirst();

				if(queue.peekFirst() == nums[left]) {
					queue.pollFirst();
				}
				left++;
			}
			right++;
		}

		return res;
	}
}
