package CodeTop;

import java.util.PriorityQueue;

/**
 * @ClassName: _剑指_Offer_40_最小的k个数
 * @Author: whc
 * @Date: 2021/08/18/10:25
 */
public class _剑指_Offer_40_最小的k个数 {

	// 大顶堆
	public int[] getLeastNumbers(int[] arr, int k) {
		if(arr == null || arr.length == 0 || k == 0) {
			return new int[0];
		}

		// 默认最小堆,改造成最大堆
		PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> {
			return Integer.compare(o2, o1);
		});

		for (int i = 0; i < arr.length; i++) {
			if(queue.size() < k || queue.isEmpty() || queue.peek() > arr[i]) {
				queue.offer(arr[i]);
			}
			if(queue.size() > k) {
				queue.poll();
			}
		}

		int[] res = new int[queue.size()];
		for (int i = 0; i < k; i++) {
			res[i] = queue.poll();
		}

		return res;
	}

	public static void main(String[] args) {
		_剑指_Offer_40_最小的k个数 _剑指_Offer_40_最小的k个数 = new _剑指_Offer_40_最小的k个数();
		_剑指_Offer_40_最小的k个数.getLeastNumbers(new int[]{0,0,1,2,4,2,2,3,1,4}, 8);
	}
}
