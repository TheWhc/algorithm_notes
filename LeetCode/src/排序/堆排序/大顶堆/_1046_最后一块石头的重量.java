package 排序.堆排序.大顶堆;

import java.util.PriorityQueue;

/**
 * @ClassName: _1046_最后一块石头的重量
 * @Author: whc
 * @Date: 2021/06/27/11:02
 */
public class _1046_最后一块石头的重量 {

	/**
	 * 思路: 大顶堆
	 *
	 * 1. 将所有石头放入到大顶堆当中
	 * 2. 每次从堆中出两块石头(最大的两块)
	 * 3. 如果两块石头相减有剩余,则放入到堆中
	 * 4. 最后判断堆是否为空,如果为空,则返回0, 如果不为空,则返回堆中只剩下的最后一个元素
	 *
	 * 时间: O(n*logk) n为石头数量,k为堆的大小,此题目中k=n
	 * 空间: O(k)
	 */
	public int lastStoneWeight(int[] stones) {

		// 构造大顶堆
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(stones.length, (o1, o2) -> (o2 - o1));

		for (int stone : stones) {
			queue.offer(stone);
		}

		while(queue.size() >= 2) {
			int stone1 = queue.poll();
			int stone2 = queue.poll();
			if(stone1 - stone2 > 0) {
				queue.offer(stone1 - stone2);
			}
		}

		return queue.isEmpty() ? 0 : queue.peek();
	}
}
