package 深度优先搜索.岛屿问题;

/**
 * @ClassName: _1254_统计封闭岛屿的数目
 * @Author: whc
 * @Date: 2021/07/15/17:56
 */
public class _1254_统计封闭岛屿的数目 {

	/**
	 * 思路: dfs
	 * 1. 遍历数组,遇到陆地0的时候,则进入dfs
	 * 2. dfs为boolean类型,判断当前位置是否能组成岛屿
	 * 			- 如果遇到越界了,则当前位置不能组成岛屿,则return false
	 * 			- 如果遇到海洋1或者已经遍历过的坐标2,则return true
	 * 			当前位置为陆地,设置当前为访问过2
	 * 			进入上下左右四个方向,判断是否能组成岛屿
	 */
	public int closedIsland(int[][] grid) {
		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == 0) {
					if(dfs(grid, i, j)) {
						res++;
					}
				}
			}
		}

		return res;
	}

	private boolean dfs(int[][] grid, int i, int j) {
		// 遇到越界,则当前无法组成岛屿,返回false
		if(!inArea(grid, i, j)) {
			return false;
		}

		// 遇到海洋或者已经遍历过,返回true
		if(grid[i][j] != 0) {
			return true;
		}

		// 当前为海洋,设置为访问过
		grid[i][j] = 2;

		// 只有都访问true,表示未越界
		return dfs(grid, i-1, j) & dfs(grid, i+1, j) & dfs(grid, i, j-1) & dfs(grid, i, j+1);
	}

	private boolean inArea(int[][] grid, int i, int j) {
		return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
	}

}
