package 图论;

import java.util.*;

/**
 * @ClassName: Test
 * @Author: whc
 * @Date: 2021/05/19/11:01
 */
public class Test {

	public static void main(String[] args) {
		List<String> wordList = new ArrayList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		ladderLength("hit", "cog", wordList);
	}

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord)) {
			return 0;
		}
		int len = 0;
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		boolean isFound = false;
		Set<String> dict = new HashSet<>(wordList);
		Set<String> visited = new HashSet<>();
		visited.add(beginWord);
		while (!queue.isEmpty()) {
			int size = queue.size();
			Set<String> subVisited = new HashSet<>();
			for (int j = 0; j < size; j++) {
				String temp = queue.poll();
				// 一次性得到所有的下一个的节点
				ArrayList<String> neighbors = getNeighbors(temp, dict);
				for (String neighbor : neighbors) {
					if (!visited.contains(neighbor)) {
						subVisited.add(neighbor);
						//到达了结束单词，提前结束
						if (neighbor.equals(endWord)) {
							isFound = true;
							break;
						}
						queue.offer(neighbor);
					}
				}

			}
			//当前层添加了元素，长度加一
			if (subVisited.size() > 0) {
				len++;
			}
			visited.addAll(subVisited);
			//找到以后，提前结束 while 循环，并且因为这里的层数从 0 计数，所以还需要加 1
			if (isFound) {
				len++;
				break;
			}
		}
		if(isFound){
			return len;
		}else{
			return 0;
		}

	}

	private static ArrayList<String> getNeighbors(String node, Set<String> dict) {
		ArrayList<String> res = new ArrayList<String>();
		char chs[] = node.toCharArray();

		for (char ch = 'a'; ch <= 'z'; ch++) {
			for (int i = 0; i < chs.length; i++) {
				if (chs[i] == ch)
					continue;
				char old_ch = chs[i];
				chs[i] = ch;
				if (dict.contains(String.valueOf(chs))) {
					res.add(String.valueOf(chs));
				}
				chs[i] = old_ch;
			}

		}
		return res;
	}

}
