package 图论;

import sun.font.FontRunIterator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;

/**
 * @ClassName: GraphTraversal
 * @Author: whc
 * @Date: 2021/05/19/9:23
 */
public class GraphTraversal {
	ListGraph graph;
	boolean[] visited;

	public GraphTraversal(ListGraph listGraph) {
		this.graph = listGraph;
		visited = new boolean[listGraph.graphs.size()];
	}

	public void DFSTraversal(int v) {
		if(visited[v]) return;
		visited[v] = true;
		System.out.println(v + "->");
		Iterator<Integer> iterator = graph.graphs.get(v).iterator();
		while(iterator.hasNext()) {
			int nextNode = iterator.next();
			if(!visited[nextNode]) {
				DFSTraversal(nextNode);
			}
		}
	}

	public void DFS() {
		for (int i = 0; i < graph.graphs.size(); i++) {
			if(!visited[i]) {
				DFSTraversal(i);
			}
		}
	}

	public void BFS() {
		for (int i = 0; i < graph.graphs.size(); i++) {
			if(!visited[i]) {
				BFSTraversal(i);
			}
		}
	}

	private void BFSTraversal(int v) {
		Deque<Integer> queue = new ArrayDeque<>();
		visited[v] = true;
		queue.offerFirst(v);
		while(queue.size() != 0) {
			Integer cur = queue.pollFirst();
			System.out.println(cur + "->");
			Iterator<Integer> iterator = graph.graphs.get(cur).iterator();
			while(iterator.hasNext()) {
				Integer nextNode = iterator.next();
				if(!visited[nextNode]) {
					queue.offerLast(nextNode);
					visited[nextNode] = true;
				}
			}
		}
	}
}
