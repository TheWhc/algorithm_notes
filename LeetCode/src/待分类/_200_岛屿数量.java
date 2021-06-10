package 待分类;

/**
 * @ClassName: 待分类._200_岛屿数量
 * @Author: whc
 * @Date: 2021/03/05/10:09
 */
public class _200_岛屿数量 {

	public int numIslands(char[][] grid) {
		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == '1') {
					res++;
					dfs(grid, i, j);
				}
			}
		}
		return res;
	}

	private void dfs(char[][] grid, int r, int c) {
		// 判断base case
		if(!isArea(grid, r, c)) {
			return;
		}

		// 不是岛屿,直接返回
		if(grid[r][c] != '1') {
			return;
		}

		grid[r][c] = 2; // 已遍历过

		// 访问上、下、左、右相邻节点
		dfs(grid, r-1, c);
		dfs(grid, r+1, c);
		dfs(grid, r, c-1);
		dfs(grid, r, c+1);
	}

	// 判断坐标(r,c)是否在网格中
	private boolean isArea(char[][] grid, int r, int c) {
		return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
	}
}
