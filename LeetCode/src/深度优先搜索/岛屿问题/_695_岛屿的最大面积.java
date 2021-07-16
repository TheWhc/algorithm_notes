package 深度优先搜索.岛屿问题;

/**
 * @ClassName: _695_岛屿的最大面积
 * @Author: whc
 * @Date: 2021/07/15/13:50
 */
public class _695_岛屿的最大面积 {

	/**
	 * 思路： dfs
	 * 1. 对每个岛屿做dfs,求出每个岛屿的面积
	 * 2. 递归终止条件
	 * 	   坐标越界
	 * 	  单层递归逻辑
	 * 	  如果当前坐标已经遍历过,或者当前坐标为海洋,则return 0;
	 *
	 * 	  否则,设置当前坐标为值为2(表示已遍历过), 然后上下左右四个方向进行递归计算
	 */

	int maxArea = 0;
	public int maxAreaOfIsland(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] == 1) {
					maxArea = Math.max(maxArea, dfs(grid, i, j));
				}
			}
		}

		return maxArea;
	}

	private int dfs(int[][] grid, int i, int j) {
		// base case
		if(!inArea(grid, i, j)) {
			return 0;
		}

		// 当前格子为海洋或者已遍历过,则return
		if(grid[i][j] != 1) {
			return 0;
		}

		// 已遍历过
		grid[i][j] = 2;

		// 上下左右四个方向
		return 1 + dfs(grid, i - 1, j) + dfs(grid, i + 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1);
	}

	private boolean inArea(int[][] grid, int i, int j) {
		return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
	}
}
