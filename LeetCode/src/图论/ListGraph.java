package 图论;

import java.util.ArrayList;

/**
 * @ClassName: ListGraph
 * @Author: whc
 * @Date: 2021/05/19/9:23
 */
// 图的邻接表
public class ListGraph {
	/**
	 * 顶点  邻接表
	 * 0  -> 1 -> 4
	 * 1  -> 0 -> 4 -> 2 -> 3
	 * 2  -> 1 -> 3
	 * 3  -> 1 -> 4
	 * 4
	 */
	ArrayList<ArrayList<Integer>> graphs;

	public ListGraph(int v) {
		graphs = new ArrayList<>();
		for (int i = 0; i < v; i++) {
			graphs.add(new ArrayList<>());
		}
	}

	public void addEdge(int start, int end) {
		graphs.get(start).add(end);
	}

	public void removeEdge(int start, int end) {
		graphs.get(start).remove(end);
	}

}
