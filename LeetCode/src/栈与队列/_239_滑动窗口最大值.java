package 栈与队列;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: 待分类._239_滑动窗口最大值
 * @Author: whc
 * @Date: 2021/04/24/10:46
 */
public class _239_滑动窗口最大值 {

	public static void main(String[] args) {
		maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
	}

	// 设计一个单调队列
	// 时间复杂度O(n)
	// 空间复杂度O(k)
	public static int[] maxSlidingWindow(int[] nums, int k) {
		// 维护一个单调队列,不必维护所有元素,保证队列是单调递减
		Deque<Integer> queue = new LinkedList<>();
		// 先将k个元素放入队列中
		for (int i = 0; i < k; i++) {
			while(!queue.isEmpty() && queue.peekLast() < nums[i]) {
				queue.pollLast();
			}
			queue.offer(nums[i]);
		}

		int[] res = new int[nums.length - k + 1];
		int count = 0;
		res[count++] = queue.peek();

		for (int i = k; i < nums.length; i++) {
			// 滑动窗口移除最前面的元素
			// 比较当前弹出的值是否等于队列出口元素的数值,如果相等则弹出
			if(!queue.isEmpty() && queue.peek() == nums[i-k]) {
				queue.poll();
			}
			while(!queue.isEmpty() && queue.peekLast() < nums[i]) {
				queue.pollLast();
			}
			queue.offer(nums[i]);
			res[count++] = queue.peek();
		}

		return res;
	}

}
