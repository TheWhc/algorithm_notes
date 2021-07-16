package 广度优先搜索;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: _1162_地图分析
 * @Author: whc
 * @Date: 2021/07/16/11:42
 */
public class _1162_地图分析 {

	/**
	 * 思路: bfs
	 * 1. 一开始先将所有陆地加入到队列中的第0层中
	 * 2. 先队列依次出队,出队的同时,标记为已访问过,遍历上下左右四个方向,属于海洋的则加入队列中
	 */
	public int maxDistance(int[][] grid) {
		int distance = 0;
		int m = grid.length;
		int n = grid[0].length;
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(grid[i][j] == 1) {
					queue.offer(new int[]{i,j});
				}
			}
		}

		// 只有海洋或者只有陆地时直接返回-1
		if(queue.isEmpty() || queue.size() == m * n) {
			return -1;
		}
		
		while(!queue.isEmpty()) {
			distance++;
			int size = queue.size();
			while(size > 0) {
				int[] cell = queue.poll();
				int x = cell[0];
				int y = cell[1];
				// 上
				if(x - 1 >= 0 && grid[x-1][y] == 0) {
					// 当格子为海洋时加入队列
					queue.offer(new int[]{x-1, y});
					// 标记为已访问过
					grid[x-1][y] = 2;
				}
				// 下
				if(x + 1 < m && grid[x+1][y] == 0) {
					// 当格子为海洋时加入队列
					queue.offer(new int[]{x+1, y});
					// 标记为已访问过
					grid[x+1][y] = 2;
				}
				// 左
				if(y - 1  >= 0 && grid[x][y-1] == 0) {
					// 当格子为海洋时加入队列
					queue.offer(new int[]{x, y-1});
					// 标记为已访问过
					grid[x][y-1] = 2;
				}
				// 右
				if(y + 1  < n && grid[x][y+1] == 0) {
					// 当格子为海洋时加入队列
					queue.offer(new int[]{x, y+1});
					// 标记为已访问过
					grid[x][y+1] = 2;
				}
				size--;
			}
		}

		return distance - 1;
	}
}
