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

	/*public static void main(String[] args) {
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
*/

	/**
	 * 思路: 滑动窗口暴力法(超时)
	 * 1. 按照滑动窗口的思路,设置left,right指针一开始指向起始位置
	 * 2. 不断滑动右指针,直到窗口大小等于k
	 * 	  窗口大小等于k时,统计窗口内的最大值
	 * 3. 窗口大小等于k时,开始移动left指针
	 *
	 * 时间: O(n * k)
	 */
	/*public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums.length < k) {
			return new int[0];
		}

		int left = 0;
		int right = 0;
		int[] res = new int[nums.length - k + 1];
		int idx = 0;

		while(right < nums.length) {

			if(right - left + 1 == k) {
				int maxValue = nums[left];
				for (int i = left + 1; i <= right; i++) {
					maxValue = Math.max(maxValue, nums[i]);
				}
				res[idx++] = maxValue;
				left++;
			}

			right++;
		}

		return res;
	}*/

	/**
	 * 思路： 滑动窗口 + 单调递减队列
	 *
	 * 1. 按照滑动窗口的思路
	 * 		- 不断滑动右指针,当窗口大小等于k时,将当前窗口的最大值添加到结果集中
	 * 		- 然后开始移动左指针, 注意要判断此时的左指针位置是不是队列的首元素的下标,如果是的,需要从队列中移除
	 * 2. 单调递减队列存储的值元素的下标值
	 *
	 *
	 * 时间: O(n)
	 * 空间: O(k)
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums.length < k) {
			return new int[0];
		}

		int left = 0;
		int right = 0;
		int[] res = new int[nums.length - k + 1];
		int idx = 0;
		// 队列存储的是元素的下标
		LinkedList<Integer> queue = new LinkedList<>();

		// 1. right指针不断滑动,直到数组元素末尾
		while(right < nums.length) {

			// 2. 保持队列的单调递减性
			while(!queue.isEmpty() && nums[queue.peekLast()] < nums[right]) {
				queue.pollLast();
			}
			// 3. 将当前元素的下标入队
			queue.offerLast(right);

			// 4. 窗口值大小等于k,则将单调队列的首位置添加到结果集中
			// 然后开始移动左指针,注意此时要判断左指针的位置等于指向单调队列首元素的位置,如果是的话,还需要将从队列中移除首元素的位置
			if(right - left + 1 == k) {
				res[idx++] = nums[queue.peekFirst()];
				if(queue.peekFirst() == left) {
					queue.pollFirst();
				}
				left++;
			}
			right++;
		}
		return res;
	}
}
