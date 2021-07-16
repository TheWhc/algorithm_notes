package 广度优先搜索;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: _994_腐烂的橘子
 * @Author: whc
 * @Date: 2021/07/16/10:53
 */
public class _994_腐烂的橘子 {

	/**
	 * 思路: bfs
	 * 1. 先统计未腐烂的橘子数量以及将一开始腐烂的橘子坐标加入到队列的第0层
	 * 2. 将队列中的元素依次出队,出队的同时,将当前出队元素对应的坐标的上下左右四个方向的未腐烂橘子加入到队列中
	 * 3. 最后结果返回时,判断未腐烂橘子数是否大于0,若大于0,则返回-1,反之,则返回最小分钟数
	 *
	 */
	public int orangesRotting(int[][] grid) {
		int count = 0;
		int m = grid.length;
		int n = grid[0].length;
		Queue<int[]> queue = new LinkedList<>();
 		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(grid[i][j] == 1) {
					count++;
				} else if(grid[i][j] == 2) {
					// 第0层节点
					// 所有腐烂橘子的坐标
					queue.offer(new int[]{i, j});
				}
			}
		}

		// 最小分钟数
		int round = 0;
		// 被感染的橘子已经遍历完 或者 队列不为空
		while(count > 0 && !queue.isEmpty()) {
			round++;
			int size = queue.size();
			while(size > 0) {
				int[] orange = queue.poll();
				int i = orange[0];
				int j = orange[1];

				// 上
				if(i - 1 >= 0 && grid[i-1][j] == 1) {
					grid[i-1][j] = 2; // 标记为腐烂
					count--; // 新鲜橘子数减1
					queue.offer(new int[]{i-1, j});
				}

				// 下
				if(i + 1 < m && grid[i+1][j] == 1) {
					grid[i+1][j] = 2; // 标记为腐烂
					count--; // 新鲜橘子数减1
					queue.offer(new int[]{i+1, j});
				}

				// 左
				if(j - 1 >= 0 && grid[i][j-1] == 1) {
					grid[i][j-1] = 2; // 标记为腐烂
					count--; // 新鲜橘子数减1
					queue.offer(new int[]{i, j-1});
				}

				// 右
				if(j + 1 < n && grid[i][j+1] == 1) {
					grid[i][j+1] = 2; // 标记为腐烂
					count--; // 新鲜橘子数减1
					queue.offer(new int[]{i, j+1});
				}
				size--;
			}
		}


		return count > 0 ? -1 : round;
	}

	public static void main(String[] args) {
		_994_腐烂的橘子 __994_腐烂的橘子 = new _994_腐烂的橘子();
		__994_腐烂的橘子.orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}});
	}
}
