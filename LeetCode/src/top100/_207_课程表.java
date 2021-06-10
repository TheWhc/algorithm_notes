package top100;

import java.util.*;

/**
 * @ClassName: _207_课程表
 * @Author: whc
 * @Date: 2021/05/12/11:53
 */
public class _207_课程表 {

	public static void main(String[] args) {
		new _207_课程表().canFinish(6, new int[][]{{1,3}, {1,4},{2,4}, {3,5}, {3,6}, {4,6}});
	}



	/*public boolean canFinish(int numCourses, int[][] prerequisites) {
		// 保存每个节点的先修课个数,即出度(出度表)
		HashMap<Integer, Integer> outNum = new HashMap<>();
		// 保存以value作为key, value为先修课的列表,即入度的节点(邻接表)
		HashMap<Integer, ArrayList<Integer>> inNodes = new HashMap<>();

		// 保存所有节点,最后根据所有节点判断所有先修课是否为0
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < prerequisites.length; i++) {
			int key = prerequisites[i][0];
			int value = prerequisites[i][1];
			set.add(key);
			set.add(value);

			if(!outNum.containsKey(key)) {
				outNum.put(key, 0);
			}

			if(!outNum.containsKey(value)) {
				outNum.put(value, 0);
			}

			// 当前节点先修课个数加1(出度+1)
			outNum.put(key, outNum.get(key)+1);

			// 更新 以value为先修课  的列表(维护邻接表、维护入度节点)
			// 比如(3,6) (4,6) 先修课为6,则列表为 3 -> 4
			if(!inNodes.containsKey(value)) {
				inNodes.put(value, new ArrayList<>());
			}
			ArrayList<Integer> list = inNodes.get(value);
			list.add(key);
		}

		// 将当前先修课个数为0的课加入到队列中(即出度为0)
		Queue<Integer> queue = new LinkedList<>();
		for (int k : set) {
			if(outNum.get(k) == 0) {
				queue.add(k);
			}
		}

		while(!queue.isEmpty()) {
			// 队列拿出来的课 代表要删除的节点
			// 要删除的节点的list中所有课的先修课个数减1
			int v = queue.poll();
			ArrayList<Integer> list = inNodes.getOrDefault(v, new ArrayList<>());
			for (int k : list) {
				int num = outNum.get(k);
				// 当前课的先修课要变成0(出度为0),加入队列
				if(num == 1) {
					queue.add(k);
				}
				// 当前课的先修课个数减1
				outNum.put(k, num-1);
			}
		}

		// 判断所有课的先修课的个数是否为0
		for (int k : set) {
			if(outNum.get(k) != 0) {
				return false;
			}
		}

		return true;
	}*/


	/**
	 * dfs: 深度优先搜索是否有环,如果出现环,则返回false
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// 保存节点的先修课列表,即出度(邻接表)
		HashMap<Integer, ArrayList<Integer>> outNodes = new HashMap<>();
		// 保存有出度的节点
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < prerequisites.length; i++) {
			int key = prerequisites[i][0];
			int value = prerequisites[i][1];
			set.add(key);
			if(!outNodes.containsKey(key)) {
				outNodes.put(key, new ArrayList<>());
			}
			// 当前节点的先修课列表
			ArrayList<Integer> list = outNodes.get(key);
			list.add(value);
		}

		// 表示已经学完的课程, 优化
		HashSet<Integer> visitedFinish = new HashSet<>();
		// 访问过的节点,防止出现死循环, 因为我们判断的条件是 路径是否可达(叶节点) 或者 是否出现环(再次访问到)
		HashSet<Integer> visited = new HashSet<>();
		// 遍历有出度的节点是否有环
		for (int k : set) {
			if(!dfs(k, outNodes, visited, visitedFinish)) {
				return false;
			}
			visitedFinish.add(k);
		}

		return true;
	}

	private boolean dfs(int k, HashMap<Integer, ArrayList<Integer>> outNodes, HashSet<Integer> visited, HashSet<Integer> visitedFinish) {
		// 到底叶子节点 或者已经处理过
		if(!outNodes.containsKey(k) || visitedFinish.contains(k)) {
			return true;
		}

		// 出现了环
		if(visited.contains(k)) {
			return false;
		}

		// 将当前节点加入到路径
		visited.add(k);
		ArrayList<Integer> list = outNodes.get(k);
		for (int node : list) {
			if(!dfs(node, outNodes, visited, visitedFinish)) {
				return false;
			}
		}
		// 移除
		visited.remove(k);
		return true;
	}

}
