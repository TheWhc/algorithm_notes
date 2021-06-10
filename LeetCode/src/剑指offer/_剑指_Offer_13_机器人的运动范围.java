package 剑指offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: _剑指_Offer_13_机器人的运动范围
 * @Author: whc
 * @Date: 2021/05/24/11:39
 */
public class _剑指_Offer_13_机器人的运动范围 {

	public static void main(String[] args) {
		_剑指_Offer_13_机器人的运动范围 a = new _剑指_Offer_13_机器人的运动范围();
		System.out.println(a.movingCount(1, 2 , 1));
	}

	/**
	 *  思路: 深度优先搜索
	 *
	 *  1. 设置一个visited布尔数组记录已经被访问过的节点
	 *  2. 从(0,0)位置开始出发,因此只会往右和往下两个方向走
	 *  3. 设置一个全局变量res,记录dfs过程中满足条件的位置
	 *
	 *  时间: O(n*m)
	 *  空间: O(n*m)
	 */
	/*int res = 0;
	int[] dx = {0,1}; // 向右 和 向下
	int[] dy = {1,0};
	public int movingCount(int m, int n, int k) {
		if(m <= 0 || n <= 0 || k < 0) {
			return 0;
		}
		boolean[][] visited = new boolean[m][n];
		dfs(visited, 0, 0, m, n, k);
		return res;
	}

	private void dfs(boolean[][] visited, int x, int y, int m, int n, int k) {
		// 已被遍历过 返回
		if(visited[x][y]) {
			return;
		}
		visited[x][y] = true;
		res++;
		for (int i = 0; i < 2; i++) {
			int a = x + dx[i];
			int b = y + dy[i];
			// 满足条件向右和向下搜索
			if(a >= 0 && a < m && b >= 0 && b < n && digitSum(a) + digitSum(b) <= k) {
				dfs(visited, a, b, m, n, k);
			}
		}
	}

	private int digitSum(int x) {
		int sum = 0;
		while(x > 0) {
			sum += x % 10;
			x /= 10;
		}
		return sum;
	}*/


	/**
	 *  思路: 宽度优先搜索(bfs)
	 *  1. 创建visited[][]数组记录已被访问过的节点
	 *  2. 队列中存放可被访问的位置,每次弹出一个位置坐标(x,y),判断是否被访问过，
	 *  如果被访问过，则continue（易错点，应该在这里），并将其下方和右下方可以被访问的位置入队
	 *  3. 全局变量res记录队列中可以到达的格子数量
	 *  4. 队列为空结束循环，返回res
	 *
	 *  时间: O(n*m)
	 *  空间: O(n*m)
	 */
	public int movingCount(int m, int n, int k) {
		if(m <= 0 || n <= 0 || k < 0) {
			return 0;
		}
		int res = 0;
		boolean[][] visited = new boolean[m][n];
		// 存储每个节点的横纵坐标
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{0,0});
		int[] dx = {0,1};
		int[] dy = {1,0};
		while(!queue.isEmpty()) {
			int[] x = queue.poll();
			if(visited[x[0]][x[1]]) {
				continue;
			}
			res++;
			visited[x[0]][x[1]] = true;
			for(int i = 0; i < 2; i++) {
				int a = x[0] + dx[i];
				int b = x[1] + dy[i];
				if(a >= 0 && a < m && b >= 0 && b < n && digitSum(a) + digitSum(b) <= k) {
					queue.add(new int[]{a,b});
				}
			}
		}

		return res;
	}

	private int digitSum(int x) {
		int sum = 0;
		while(x > 0) {
			sum += x % 10;
			x /= 10;
		}
		return sum;
	}




	// 如果给的数组是一维数组,需要将二维数组转化为一维数组
	// 深度优先搜索
     /*int res = 0;
     int[] dx = {0, 1}; // 右下
     int[] dy = {1, 0};
     public int movingCount(int threshold, int rows, int cols) {
         if(rows <= 0 || cols <= 0 || threshold < 0) return 0;
         // 一维代替二维
         boolean[] visited = new boolean[rows * cols];
         dfs(visited, rows, cols, 0, 0, threshold);
         return res;
     }

     public void dfs(boolean[] visited, int rows, int cols, int row, int col, int threshold) {
         // 不满足条件
         int index = row * cols + col;
         visited[index] = true;
         res++;
         for(int i = 0; i < 2; i++) {
             int a = row + dx[i]; // 下一个位置的横坐标
             int b = col + dy[i]; // 下一个位置的纵坐标
             if(a >= 0 && a < rows && b >= 0 && b < cols && !visited[a * cols + b] && digitSum(a) + digitSum(b) <= threshold) {
                 dfs(visited, rows, cols, a, b, threshold);
             }
         }
     }

     private int digitSum(int x) {
         int sum = 0;
         while(x > 0) {
             sum += x % 10;
             x /= 10;
         }
         return sum;
     }*/

	// 宽度优先搜索
	/*public int movingCount(int threshold, int rows, int cols) {
		if(rows <= 0 || cols <= 0 || threshold < 0) {
			return 0;
		}
		int res = 0;
		// 存储每个点的x,y轴
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{0,0});
		// 方向
		int[] dx = {0, 1};// 右 下
		int[] dy = {1, 0};
		// 访问过的标志
		boolean[] visited = new boolean[rows * cols];
		while(queue.size() > 0) {
			int[] x = queue.poll();
			if(visited[x[0] * cols + x[1]]) {
				continue;
			}
			visited[x[0] * cols + x[1]] = true;
			res++;
			for(int i = 0; i < 2; i++) {
				int a = x[0] + dx[i];
				int b = x[1] + dy[i];
				// 条件满足才能入队
				if(a >= 0 && a < rows && b >= 0 && b < cols && digitSum(a) + digitSum(b) <= threshold) {
					queue.add(new int[]{a,b});
				}
			}
		}

		return res;
	}

	private int digitSum(int x) {
		int sum = 0;
		while(x > 0) {
			sum += x % 10;
			x /= 10;
		}
		return sum;
	}*/
}
