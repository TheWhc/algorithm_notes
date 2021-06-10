package 剑指offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: _剑指_Offer_59_II_队列的最大值
 * @Author: whc
 * @Date: 2021/06/08/11:51
 */
public class _剑指_Offer_59_II_队列的最大值 {

	// 封装一个队列实现基本的功能
	Queue<Integer> queue;
	// 用于实现O(1)取得最大值
	Deque<Integer> deque;

	public _剑指_Offer_59_II_队列的最大值() {
		this.queue = new LinkedList<>();
		this.deque = new LinkedList<>();
	}

	public int max_value() {
		// 最大值队列中不为空返回首个元素(单调递减)
		if(deque.size() != 0) {
			return deque.peekFirst();
		} else {
			// 为空时返回-1
			return -1;
		}
	}

	public void push_back(int value) {
		// 元素入队基本队列中
		queue.offer(value);
		// 保持最大值队列的单调性,保持单调递减
		while(!deque.isEmpty() && deque.peekLast() < value) {
			deque.pollLast();
		}
		// 元素入队最大值队列
		deque.offerLast(value);
	}

	public int pop_front() {
		// 若基本队列为空时,直接返回-1
		if(queue.isEmpty()) {
			return -1;
		}
		// 判断出队首元素是否和最大值队列的队首元素是否相等,若相等,最大值队列也要出队
		if(queue.peek().equals(deque.peekFirst())) {
			deque.pollFirst();
		}
		// 基本队列出队首元素
		return queue.poll();
	}
}
