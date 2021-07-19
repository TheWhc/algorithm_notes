package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @ClassName: _剑指_Offer_41_数据流中的中位数
 * @Author: whc
 * @Date: 2021/05/31/12:31
 */
public class _剑指_Offer_41_数据流中的中位数 {

	/**
	 * 思路: 堆的应用
	 * 例如: 1 2 4 6 8 10 划分左右半区两个堆,4是最大堆中的最大值,6是最小堆的最小值
	 * 1. 维护一个最大堆和一个最小堆
	 * 		- 最大堆: 最小的k个数
	 * 		-  最小堆: 最大的k个数
	 * 2. 每次插入数据时保证两个堆的数量均衡
	 * 3. 最大堆数量 == 最小堆数量,新的数据插入到最小堆中
	 *    最大堆数量 != 最小堆数量,新的数据插入到最堆堆中
	 *
	 * 时间: O(logn)
	 */
	/** initialize your data structure here. */

	PriorityQueue<Integer> minHeap;
	PriorityQueue<Integer> maxHeap;
	public _剑指_Offer_41_数据流中的中位数() {
		// 默认最小堆
		this.minHeap = new PriorityQueue<>();
		this.maxHeap = new PriorityQueue<>((o1, o2) -> (o2 - o1));
	}

	public void addNum(int num) {
		// 插入到最小堆中
		if(minHeap.size() == maxHeap.size()) {
			// 插入时,先插入到最大堆中,弹出最大堆最大值插入到最小堆中,因为最小堆维护最大的k个数
			maxHeap.offer(num);
			minHeap.offer(maxHeap.poll());
		} else {
			// 插入到最大堆中
			// 插入时,先插入到最小堆中,弹出最小堆最小值插入到最大堆中,因为最大堆维护最小的k个数
			minHeap.offer(num);
			maxHeap.offer(minHeap.poll());
		}
	}

	public double findMedian() {
		if(minHeap.size() == maxHeap.size()) {
			return (minHeap.peek() + maxHeap.peek()) / 2.0;
		} else {
			return minHeap.peek();
		}
	}
}
