package CodeTop;

import java.util.PriorityQueue;

/**
 * @ClassName: _面试题_17_14_最小K个数
 * @Author: whc
 * @Date: 2021/09/12/14:38
 */
public class _面试题_17_14_最小K个数 {

	public static int[] smallestK(int[] arr, int k) {
		if(arr == null || arr.length < k || k == 0) {
			return new int[0];
		}

		// 大顶堆
		PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> {
			return Integer.compare(o2, o1);
		});

		for (int num : arr) {
			if(queue.size() < k || queue.peek() > num) {
				queue.offer(num);
			}

			if(queue.size() > k) {
				queue.poll();
			}
		}

		int[] res = new int[queue.size()];
		for (int i = 0; i < res.length; i++) {
			res[i] = queue.poll();
		}

		return res;
	}

	public static void main(String[] args) {
		smallestK(new int[]{1,3,5,7,2,4,6,8}, 4);
	}
}
