import java.util.*;

/**
 * @ClassName: _NC119_最小的K个数
 * @Author: whc
 * @Date: 2021/01/28/21:49
 */
public class _NC119_最小的K个数 {

	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		if(k == 0 || input.length < k)
			return new ArrayList<>();

		// 建立大顶堆
		PriorityQueue<Integer> queue = new PriorityQueue<>(k, (i1, i2) -> (i2 - i1));
		for (int num : input) {
			// 小于k 以及 小于最大堆最大值入堆
			if(queue.size() < k || num < queue.peek()) {
				queue.offer(num);
			}
			if(queue.size() > k) {
				queue.poll();
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (Integer integer : queue) {
			list.add(integer);
		}

//		list.sort((i1, i2) -> (i1 - i2));

		return list;
	}
}
