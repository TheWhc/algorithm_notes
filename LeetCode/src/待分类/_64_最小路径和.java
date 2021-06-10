package 待分类;

/**
 * @ClassName: 待分类._64_最小路径和
 * @Author: whc
 * @Date: 2021/03/23/14:05
 */
public class _64_最小路径和 {
	public int minPathSum(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(i == 0 && j == 0) {
					continue;
				} else if(i == 0) {
					grid[i][j] += grid[i][j-1];
				} else if(j == 0) {
					grid[i][j] += grid[i-1][j];
				} else {
					grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
				}
			}
		}
		return grid[grid.length-1][grid[0].length-1];
	}
}
