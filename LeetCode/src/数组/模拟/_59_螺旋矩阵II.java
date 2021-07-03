package 数组.模拟;

/**
 * @ClassName: _59_螺旋矩阵II
 * @Author: whc
 * @Date: 2021/07/03/23:01
 */
public class _59_螺旋矩阵II {

	/**
	 * 思路: 模拟法
	 * 1. 定义i,j指针代表当前访问到的坐标(x,y)
	 * 设置一个boolean数组,表示已访问过,visited[][]
	 *
	 * 2. 从count=1,开始遍历到n*n时停止
	 * 		- 遇到到满足的情况时,则添加结果
	 * 		- 遇到不满足的情况时,变更i,j以及方向flag
	 */
	public int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];

		// 访问标记
		boolean[][] visited = new boolean[n][n];

		int i = 0;
		int j = 0;

		// 1表示向右,2表示向下,3表示向右,4表示向上
		int flag = 1;

		int count = 1;
		while(count <= n * n) {
			// 满足时,则添加结果
			if(i >= 0 && i < n && j >= 0 && j < n && !visited[i][j]) {
				res[i][j] = count++;
				visited[i][j] = true;
				if(flag == 1) {
					j++;
				} else if(flag == 2) {
					i++;
				} else if(flag == 3) {
					j--;
				} else {
					i--;
				}
			} else {
				// 不满足的情况,即越界或者已经访问过,则需要变更i,j的值和flag方向
				if(flag == 1) {
					// 右 -> 下
					i++;
					j--;
					flag = 2;
				} else if(flag == 2) {
					// 下 -> 右
					i--;
					j--;
					flag = 3;
				} else if(flag == 3) {
					// 右 -> 上
					j++;
					i--;
					flag = 4;
				} else {
					// 上 -> 右
					i++;
					j++;
					flag = 1;
				}
			}
		}

		return res;
	}
}
