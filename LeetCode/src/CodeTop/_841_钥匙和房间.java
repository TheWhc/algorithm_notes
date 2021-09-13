package CodeTop;

import java.util.*;

/**
 * @ClassName: _841_钥匙和房间
 * @Author: whc
 * @Date: 2021/09/13/18:52
 */
public class _841_钥匙和房间 {

	/**
	 * 思路：dfs
	 */
	/*Set<Integer> set = new HashSet<>();
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		dfs(rooms, 0);
		return set.size() == rooms.size();
	}

	private void dfs(List<List<Integer>> rooms, int i) {
		List<Integer> room = rooms.get(i);

		set.add(i);
		for (Integer r : room) {
			if(!set.contains(r)) {
				dfs(rooms, r);
			}
		}
	}*/

	/*public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		int[] visited = new int[rooms.size()];
		dfs(rooms, visited, 0);
		for (int i = 0; i < visited.length; i++) {
			if(visited[i] == 0) {
				return false;
			}
		}
		return true;
	}

	private void dfs(List<List<Integer>> rooms, int[] visited, int i) {
		if(visited[i] == 1) {
			return;
		}

		visited[i] = 1;
		List<Integer> room = rooms.get(i);
		for (Integer r : room) {
			dfs(rooms, visited, r);
		}
	}*/

	// bfs
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		Queue<Integer> queue = new LinkedList<>();
		int[] visited = new int[rooms.size()];
		queue.offer(0);
		visited[0] = 1;
		while(!queue.isEmpty()) {
			Integer index = queue.poll();
			List<Integer> room = rooms.get(index);
			for (Integer r : room) {
				if(visited[r] == 0) {
					queue.offer(r);
					visited[r] = 1;
				}
			}
		}

		for (int i = 0; i < visited.length; i++) {
			if(visited[i] == 0) {
				return false;
			}
		}

		return true;
	}
}
