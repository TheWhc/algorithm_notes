package 图论.深度优先搜索.岛屿问题;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: _827_最大人工岛
 * @Author: whc
 * @Date: 2021/07/15/14:17
 */
public class _827_最大人工岛 {


	/**
	 * 思路: 两次dfs
	 *
	 * 1. 第一次dfs,计算岛屿的面积
	 * 用HashMap存储岛屿的下标和岛屿面积
	 * 以value为2开始, 标记相同编号的表示每一块岛屿
	 *
	 * 2. 第二次dfs,尝试进行填海操作
	 * 用一个set数组记录海洋的上下左右区域为陆地的 编号岛屿
	 * 同时更新最大值人工岛屿
	 */
	public int largestIsland(int[][] grid) {
		int value = 2; // 表示岛屿编号
		Map<Integer, Integer> map = new HashMap<>(); // key岛屿编号, value岛屿面积
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == 1) {
					int a = dfs(grid, i, j, value);
					map.put(value, a);
					value++;
				}
			}
		}

		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				// 进行填海
				int temp = fillSea(grid, i, j, map);
				res = Math.max(res, temp);
			}
		}

		return res;
	}

	private int fillSea(int[][] grid, int i, int j, Map<Integer, Integer> map) {
		if(grid[i][j] != 0) {
			return map.get(grid[i][j]);
		}

		int res = 0;
		Set<Integer> set = new HashSet<>();
		// 上
		if(inArea(grid, i-1, j) && grid[i-1][j] != 0) {
			set.add(grid[i-1][j]);
		}
		// 下
		if(inArea(grid, i+1, j) && grid[i+1][j] != 0) {
			set.add(grid[i+1][j]);
		}
		// 左
		if(inArea(grid, i, j-1) && grid[i][j-1] != 0) {
			set.add(grid[i][j-1]);
		}
		// 右
		if(inArea(grid, i, j+1) && grid[i][j+1] != 0) {
			set.add(grid[i][j+1]);
		}

		// 加上相邻岛屿的面积,如果相邻同于属于同一个岛屿,那么set大小只有一个
		for (int idx : set) {
			res += map.get(idx);
		}

		return res + 1;
	}

	private int dfs(int[][] grid, int i, int j, int value) {
		// 越界
		if(!inArea(grid, i, j)) {
			return 0;
		}

		// 当前坐标不是1陆地, 可能是0海洋,或者2以上的编号表示被其它岛屿标记过了
		if(grid[i][j] != 1) {
			return 0;
		}

		// 赋予当前陆地编号
		grid[i][j] = value;

		// 相邻陆地标记为同一个编号,并且返回相邻陆地组成的岛屿面积
		return 1 + dfs(grid, i - 1, j, value) + dfs(grid, i + 1, j, value)
				+ dfs(grid, i, j - 1, value) +  dfs(grid, i, j + 1, value);
	}

	private boolean inArea(int[][] grid, int i, int j) {
		return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
	}
}
