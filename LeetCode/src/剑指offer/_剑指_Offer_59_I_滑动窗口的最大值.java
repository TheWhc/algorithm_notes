package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: _剑指_Offer_59_I_滑动窗口的最大值
 * @Author: whc
 * @Date: 2021/06/07/13:01
 */
public class _剑指_Offer_59_I_滑动窗口的最大值 {

	public static void main(String[] args) {
		maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
	}

	/**
	 *  思路: 滑动窗口 + 暴力
	 *
	 *  时间: O(n * k)
	 *  空间: O(n)
	 */
	/*public static int[] maxSlidingWindow(int[] nums, int k) {
		int left = 0;
		int right = 0;
		List<Integer> res = new ArrayList<>();
		while(right < nums.length) {
			while(right - left < k) {
				right++;
			}
			int maxVal = Integer.MIN_VALUE;
			for (int i = left; i < right; i++) {
				maxVal = Math.max(maxVal, nums[i]);
			}
			res.add(maxVal);
			left++;
		}

		int[] result = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			result[i] = res.get(i);
		}
		return result;
	}*/


	/**
	 *  思路: 滑动窗口 + 单调队列
	 *  1. 遍历给定的数组元素,如果队列不为空且待加入的元素大于队尾元素,则移除队尾元素,直到队尾元素大于等于待加入元素,满足后,向队尾添加当前元素的下标值
	 *  2. 计算组成满足滑动窗口的左边界left值
	 *  3. 如果发现队首元素下标值小于left值,则表明队首元素已经不在满足滑动窗口当中了,则需要移除对应在滑动窗口的下标值
	 *  4. 如果left值大于等于0时,说明窗口刚好形成,向结果集中添加满足窗口的最大值,即队列中的首元素的下标值对应的元素值
	 *  5. 移动右指针,重复1,2,3,4步骤
	 *
	 *  时间: O(n)
	 *  空间: O(k) 队列的长度
	 */
	public static int[] maxSlidingWindow(int[] nums, int k) {
		// 滑动窗口个数
		int[] res = new int[nums.length-k+1];

		int left = 0;
		int right = 0;
		// 存储窗口单调递减下标值
		LinkedList<Integer> queue = new LinkedList<>();

		// 移动窗口右边界,直到小于数组元素大小,代表结束
		while(right < nums.length) {
			// 队列不为空且新加入的元素值大于队列队尾的元素时,需要一直出队尾元素,保持队列单调递减
			while(!queue.isEmpty() && nums[queue.peekLast()] < nums[right]) {
				queue.removeLast();
			}

			// 添加元素的下标值
			queue.addLast(right);

			// 计算每次待加入窗口的左边界
			left = right - k + 1;

			// 当队首元素的下标小于左边界时,表明队首元素已经不再滑动窗口中,需要移除掉
			if(queue.peekFirst() < left) {
				queue.removeFirst();
			}

			// 窗口形成,等同于 right + 1 >= k
			if(left >= 0) {
				res[left] = nums[queue.peekFirst()];
			}

			right++;
		}

		return res;
	}

}
