package CodeTop;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @ClassName: _347_前K个高频元素
 * @Author: whc
 * @Date: 2021/09/12/10:33
 */
public class _347_前K个高频元素 {

	// 最小堆
	public int[] topKFrequent(int[] nums, int k) {
		// 统计数字出现的次数
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		// 默认最小堆
		// 传入比较器,按照数组出现的次数从小到大
		PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(k, (o1, o2) -> {
			return o1.getValue() - o2.getValue();
		});

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(queue.size() < k || entry.getValue() > queue.peek().getValue()) {
				queue.offer(entry);
			}

			if(queue.size() > k) {
				queue.poll();
			}
		}

		int[] res = new int[queue.size()];

		for (int i = 0; i < k; i++) {
			res[i] = queue.poll().getKey();
		}

		return res;
	}
}
