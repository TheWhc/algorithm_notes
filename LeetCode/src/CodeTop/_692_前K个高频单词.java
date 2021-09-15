package CodeTop;

import java.util.*;

/**
 * @ClassName: _692_前K个高频单词
 * @Author: whc
 * @Date: 2021/09/15/13:43
 */
public class _692_前K个高频单词 {

	public List<String> topKFrequent(String[] words, int k) {
		List<String> res = new ArrayList<>();
		if(words == null || words.length == 0) {
			return res;
		}

		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		// 最小堆
		PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(k, (o1, o2) -> {
			if(o1.getValue() == o2.getValue()) {
				return o2.getKey().compareTo(o1.getKey());
			} else {
				return Integer.compare(o1.getValue(), o2.getValue());
			}
		});

		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			if(queue.size() < k || entry.getValue() >= queue.peek().getValue()) {
				queue.offer(entry);
			}
			if(queue.size() > k) {
				queue.poll();
			}
		}

		while(!queue.isEmpty()) {
			res.add(queue.poll().getKey());
		}

		Collections.reverse(res);

		return res;
	}

	public static void main(String[] args) {
		_692_前K个高频单词 _692_前K个高频单词 = new _692_前K个高频单词();
		_692_前K个高频单词.topKFrequent(new String[]{"i","love","leetcode","i","love","coding"}, 1);
	}

}
