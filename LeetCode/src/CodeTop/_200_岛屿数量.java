package CodeTop;

/**
 * @ClassName: _200_岛屿数量
 * @Author: whc
 * @Date: 2021/07/21/10:45
 */
public class _200_岛屿数量 {

//	public int numIslands(char[][] grid) {
//		int res = 0;
//		for (int i = 0; i < grid.length; i++) {
//			for (int j = 0; j < grid[0].length; j++) {
//				if(grid[i][j] == '1') {
//					dfs(grid, i, j);
//					res++;
//				}
//			}
//		}
//
//		return res;
//	}
//
//	private void dfs(char[][] grid, int i, int j) {
//		if(!inArea(grid, i, j)) {
//			return;
//		}
//
//		if(grid[i][j] != '1') {
//			return;
//		}
//
//		grid[i][j] = '2';
//		// 上下左右
//		dfs(grid, i-1, j);
//		dfs(grid, i+1, j);
//		dfs(grid, i, j-1);
//		dfs(grid, i, j+1);
//	}
//
//	private boolean inArea(char[][] grid, int i, int j) {
//		return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
//	}


}
