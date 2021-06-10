package 待分类;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: 待分类._239_滑动窗口最大值
 * @Author: whc
 * @Date: 2021/03/23/14:42
 */
public class _239_滑动窗口最大值 {

	public int[] maxSlidingWindow(int[] nums, int k) {
		int len = nums.length;
		if(len == 0) {
			return nums;
		}
		int[] arr = new int[len - k + 1];
		int arr_index = 0;
		// 单调递增的双向队列
		Deque<Integer> deque = new LinkedList<>();
		// 第一个窗口的所有值存入单调双端队列,单调队列是单调递减的
		for (int i = 0; i < k; i++) {
			// 队尾元素小于要加入的元素,则将队尾元素出队,直到队尾元素大于新元素或者为空
			while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
				deque.removeLast();
			}
			deque.offerLast(nums[i]);
		}

		// 队头元素存到数组
		arr[arr_index++] = deque.peekFirst();

		// 移动窗口
		for (int i = k; i < len; i++) {
			// 窗口的前一个元素等于队头元素要移除
			if(nums[i - k] == deque.peekFirst()) {
				deque.removeFirst();
			}
			while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
				deque.removeLast();
			}
			deque.offerLast(nums[i]);
			arr[arr_index++] = deque.peekFirst();
		}

		return arr;
	}
}
