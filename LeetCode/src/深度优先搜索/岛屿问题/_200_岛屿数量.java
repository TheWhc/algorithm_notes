package 深度优先搜索.岛屿问题;

/**
 * @ClassName: _200_岛屿数量
 * @Author: whc
 * @Date: 2021/07/15/17:14
 */
public class _200_岛屿数量 {

	/**
	 * 思路： dfs
	 * 1. 遍历每个坐标,进入dfs
	 * 2. 如果当前坐标越界,则返回
	 * 	  如果当前坐标不是'1'陆地,则返回
	 *
	 * 	  设置当前坐标为访问过的标记,为'2'
	 * 	  然后进入上下左右四个方向,标记属于同一块岛屿的陆地
	 */
	public int numIslands(char[][] grid) {
		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == '1') {
					dfs(grid, i, j);
					res++;
				}
			}
		}

		return res;
	}

	private void dfs(char[][] grid, int i, int j) {
		if(!inArea(grid, i, j)) {
			return;
		}

		if(grid[i][j] != '1') {
			return;
		}

		// 标记为已遍历过
		grid[i][j] = '2';

		dfs(grid, i-1, j);
		dfs(grid, i+1, j);
		dfs(grid, i, j-1);
		dfs(grid, i, j + 1);
	}

	private boolean inArea(char[][] grid, int i, int j) {
		return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
	}
}
