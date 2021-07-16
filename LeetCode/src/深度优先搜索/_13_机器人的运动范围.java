package 深度优先搜索;

/**
 * @ClassName: _13_机器人的运动范围
 * @Author: whc
 * @Date: 2021/05/19/9:56
 */
public class _13_机器人的运动范围 {

	/**
	 *  思路: 搜索问题可以用深度优先搜索或者广度优先
	 *
	 *  深度优先搜索:
	 *  	- 当前坐标(i,j)看成状态
	 *  	- 递归搜索(i-1,j),(i+1,j),(i,j-1),(i,j+1) 【分解为子问题】
	 *   	- 记录是否访问过的全局状态
	 */

	// 位数和计算
	public int digitSum(int x) {
		int sum = 0;
		while(x > 0) {
			sum += x % 10;
			x /= 10;
		}
		return sum;
	}

	/*public int dfsSolver(int i, int j, int m, int n, int k, boolean[][] visited) {
		// 递归出口
		if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || digitSum(i) + digitSum(j) > k) {
			return 0;
		}
		visited[i][j] = true;
		return 1 + dfsSolver(i-1, j, m, n, k, visited) + dfsSolver(i+1, j, m, n, k, visited) + dfsSolver(i, j-1, m, n, k, visited) + dfsSolver(i, j+1, m, n, k, visited);
	}*/

	// 进一步优化 剪纸条件 只向右或者向下搜索即可
	public int dfsSolver(int i, int j, int m, int n, int k, boolean[][] visited) {
		// 递归出口
		if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || digitSum(i) + digitSum(j) > k) {
			return 0;
		}
		visited[i][j] = true;
		return 1 + dfsSolver(i+1, j, m, n, k, visited) + dfsSolver(i, j+1, m, n, k, visited);
	}

	public int movingCount(int m, int n, int k) {
		return dfsSolver(0, 0, m, n, k, new boolean[m][n]);
	}
}
