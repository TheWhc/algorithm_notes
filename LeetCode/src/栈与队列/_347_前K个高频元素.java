package 栈与队列;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @ClassName: _347_前K个高频元素
 * @Author: whc
 * @Date: 2021/04/24/12:34
 */
public class _347_前K个高频元素 {

	// 时间O(nlogk)
	// 空间O(n)
	public int[] topKFrequent(int[] nums, int k) {
		// 统计元素出现频率
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		// 对频率排序
		// 定义小顶堆,大小为k 默认是小顶堆
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
			return o1[1] - o2[1];
		});

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(queue.size() == k) {
				if(entry.getValue() > queue.peek()[1]) {
					queue.poll();
					queue.offer(new int[]{entry.getKey(), entry.getValue()});
				}
			} else {
				queue.offer(new int[]{entry.getKey(), entry.getValue()});
			}
		}

		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = queue.poll()[0];
		}

		return res;
	}

}
