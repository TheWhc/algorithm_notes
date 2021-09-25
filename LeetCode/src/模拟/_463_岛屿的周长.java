package 模拟;

/**
 * @ClassName: _463_岛屿的周长
 * @Author: whc
 * @Date: 2021/09/25/21:09
 */
public class _463_岛屿的周长 {

	int res = 0;
	public int islandPerimeter(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(grid[i][j] == 1) {
					dfs(grid, i, j);
					return res;
				}
			}
		}

		return res;
	}

	private void dfs(int[][] grid, int i, int j) {
		if(!inArea(grid, i, j) || grid[i][j] == 0) {
			res++;
			return;
		}

		// 已经访问过
		if(grid[i][j] == 2) {
			return;
		}

		grid[i][j] = 2;

		// 上下左右
		dfs(grid, i-1, j);
		dfs(grid, i+1, j);
		dfs(grid, i, j-1);
		dfs(grid, i, j+1);
	}

	private boolean inArea(int[][] grid, int i, int j) {
		return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
	}

}
