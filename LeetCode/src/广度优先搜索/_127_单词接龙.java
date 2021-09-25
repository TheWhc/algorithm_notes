package 广度优先搜索;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.*;

/**
 * @ClassName: _127_单词接龙
 * @Author: whc
 * @Date: 2021/09/25/20:10
 */
public class _127_单词接龙 {

	/**
	 *  思路:bfs
	 *
	 *  1. 将起点和终点以及转换列表连接起来
	 *  2. 起点到终点的最短路径长度
	 *
	 *  广搜要用标记位,标记是否已走过
	 *
	 */
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		HashSet<String> set = new HashSet<>(wordList); // 将wordList转化为set,提高判断速度

		if(wordList.size() == 0 || !set.contains(endWord)) {
			return 0;
		}

		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);

		Map<String, Integer> map = new HashMap<>(); // 记录单词对应的路径长度
		map.put(beginWord, 1);

		while(!queue.isEmpty()) {
			String word = queue.poll();
			int path = map.get(word);
			for (int i = 0; i < word.length(); i++) {
				// 转化为字符数组,容易替换
				char[] chars = word.toCharArray();
				for (char k = 'a'; k <= 'z'; k++) {
					chars[i] = k;
					String newWord = String.valueOf(chars);
					if(newWord.equals(endWord)) {
						return path + 1;
					}

					if(set.contains(newWord) && !map.containsKey(newWord)) {
						// 包含在列表中且被未访问过
						map.put(newWord, path + 1);
						queue.offer(newWord);
					}
				}
			}
		}

		return 0;
	}
}
