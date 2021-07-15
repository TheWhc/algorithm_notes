package 图论.深度优先搜索.岛屿问题;

/**
 * @ClassName: _463_岛屿的周长
 * @Author: whc
 * @Date: 2021/07/15/17:29
 */
public class _463_岛屿的周长 {

	/**
	 * 思路: dfs
	 * 1. 遍历数组元素,遇到当前元素是陆地,则进入递归
	 * 2. 递归过程中如何统计周长呢?
	 * 	 这里吧递归的终止条件做特殊处理
	 * 	 - 遇到越界的时候,res++
	 * 	 - 遇到海洋的时候,res++
	 * 	 - 遇到已遍历过的陆地,直接返回
	 *
	 * 	 设置当前陆地为访问过,gird[i][j]=2
	 * 	 遍历四个方向,上下左右
	 */
	int res = 0;
	public int islandPerimeter(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == 1) {
					dfs(grid, i, j);
					return res;
				}
			}
		}
		return 0;
	}

	private void dfs(int[][] grid, int i, int j) {
		// 越界,经过边界,那么res++
		// 或者遇到海洋,返回,并且res++
		if(!inArea(grid, i, j) || grid[i][j] == 0) {
			res++;
			return;
		}

		// 已访问过,直接返回
		if(grid[i][j] == 2) {
			return;
		}

		grid[i][j] = 2;

		dfs(grid, i-1, j);
		dfs(grid, i+1, j);
		dfs(grid, i, j-1);
		dfs(grid, i, j+1);
	}

	private boolean inArea(int[][] grid, int i, int j) {
		return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
	}
}
