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
	/*public int[] topKFrequent(int[] nums, int k) {
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
	}*/


	/**
	 * 思路: HashMap + 优先队列
	 *
	 * 	1. 用HashMap统计元素以及元素对应的次数
	 * 	2. 构建最小堆,存放一个数组int[]{num, numsCount}
	 * 	3. 遍历HashMap,将元素存入最小堆中
	 */
	/*public int[] topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		// 优先队列默认最小堆
		// int[]{num, numCount} 需要对元素的次数按照从小到大排序
		PriorityQueue<int[]> queue = new PriorityQueue<>(k, (o1, o2) -> {
			return o1[1] - o2[1];
		});

		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {

			// 堆的大小小于k 或者 当前元素的次数大于最小堆的次数时,入堆
			if(queue.size() < k || entry.getValue() > queue.peek()[1]) {
				queue.offer(new int[]{entry.getKey(), entry.getValue()});
			}

			// 堆的大小大于k时,将堆顶最小值出堆
			if(queue.size() > k) {
				queue.poll();
			}
		}

		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = queue.poll()[0];
		}

		return res;
	}*/

	/**
	 * 思路: HashMap + 优先队列
	 *
	 * 	1. 用HashMap统计元素以及元素对应的次数
	 * 	2. 构建最小堆,存放Map.Entry
	 * 	3. 遍历HashMap,将元素存入最小堆中
	 */
	public int[] topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		// 优先队列默认最小堆
		PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(k, (o1, o2) -> {
			return o1.getValue() - o2.getValue();
		});

		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {

			// 堆的大小小于k 或者 当前元素的次数大于最小堆的次数时,入堆
			if(queue.size() < k || entry.getValue() > queue.peek().getValue()) {
				queue.offer(entry);
			}

			// 堆的大小大于k时,将堆顶最小值出堆
			if(queue.size() > k) {
				queue.poll();
			}
		}

		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = queue.poll().getKey();
		}

		return res;
	}

	public static void main(String[] args) {
		_347_前K个高频元素 _347_前k个高频元素 = new _347_前K个高频元素();
		int[] ints = _347_前k个高频元素.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
		for (int i : ints) {
			System.out.println(i);
		}

	}

}
