package CodeTop;

/**
 * @ClassName: _695_岛屿的最大面积
 * @Author: whc
 * @Date: 2021/07/28/8:12
 */
public class _695_岛屿的最大面积 {

	public int maxAreaOfIsland(int[][] grid) {
		int maxArea = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == 1) {
					maxArea = Math.max(maxArea, dfs(grid, i, j));
				}
			}
		}

		return maxArea;
	}

	// 返回以当前为陆地的格子围成的岛屿面积
	private int dfs(int[][] grid, int i, int j) {
		if(!inArea(grid, i, j)) {
			return 0;
		}

		// 当前为海洋或者已经遍历过,返回0
		if(grid[i][j] != 1) {
			return 0;
		}

		// 标记为已访问过
		grid[i][j] = 2;

		return 1 + dfs(grid, i-1, j) + dfs(grid, i+1, j) + dfs(grid, i, j-1) + dfs(grid, i, j+1);
	}

	private boolean inArea(int[][] grid, int i, int j) {
		return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
	}
}
