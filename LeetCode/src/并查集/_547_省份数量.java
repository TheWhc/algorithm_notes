package 并查集;

import java.util.Arrays;

/**
 * @ClassName: _547_省份数量
 * @Author: whc
 * @Date: 2021/05/18/10:36
 */
public class _547_省份数量 {

	// 并查集 Quick Union
	// 时间复杂度 平均O(logn) 最坏O(n^2)
	/*class UnionFind{
		int[] parents;
		int size; // 集合数量

		public UnionFind(int n) {
			parents = new int[n];
			for (int i = 0; i < parents.length; i++) {
				parents[i] = i;
			}
			size = n;
		}

		public int find(int x) {
			if(x == parents[x]) {
				return x;
			}
			return find(parents[x]);
		}

		public void union(int x, int y) {
			int fx = find(x);
			int fy = find(y);
			if(fx == fy) return;

			parents[fx] = fy;
			size--;
		}
	}*/

	// Quick Union + R(按秩合并) 节点树高度小的合并到节点树高度大的
	// 时间复杂度 平均O(logn) 最坏O(logn)
	/*class UnionFind{
		int[] parents;
		int size; // 集合数量
		int[] ranks; // 节点数高度

		public UnionFind(int n) {
			parents = new int[n];
			ranks = new int[n];
			for (int i = 0; i < parents.length; i++) {
				parents[i] = i;
			}
			Arrays.fill(ranks, 1);
			size = n;
		}

		public int find(int x) {
			if(x == parents[x]) {
				return x;
			}
			return find(parents[x]);
		}

		public void union(int x, int y) {
			int fx = find(x);
			int fy = find(y);
			if(fx == fy) return;

			if(ranks[fx] < ranks[fy]) {
				parents[fx] = fy;
			} else if(ranks[fx] > ranks[fy]) {
				parents[fy] = fx;
			} else {
				// 高度相同
				parents[fx] = fy;
				ranks[fy] += 1;
			}
			size--;
		}
	}

	public int findCircleNum(int[][] isConnected) {
		int n = isConnected.length;
		UnionFind unionFind = new UnionFind(n);
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				if(isConnected[i][j] == 1) {
					unionFind.union(i, j);
				}
			}
		}
		return unionFind.size;
	}*/


	// UnionFind + R(按秩合并) + PC(路径压缩)
	// 时间复杂度: 平均O(α(n)) 最差O(α(n))
	class UnionFind{
		int[] parents;
		int size; // 集合数量
		int[] ranks; // 节点数高度

		public UnionFind(int n) {
			parents = new int[n];
			ranks = new int[n];
			for (int i = 0; i < parents.length; i++) {
				parents[i] = i;
			}
			Arrays.fill(ranks, 1);
			size = n;
		}

		public int find(int x) {
			if(x == parents[x]) {
				return x;
			}
			// 在find时使路径上的所有节点指向根节点 降低树的高度 优化时间复杂度
			return parents[x] = find(parents[x]);
		}

		public void union(int x, int y) {
			int fx = find(x);
			int fy = find(y);
			if(fx == fy) return;

			// 将矮的树合并到高的树, 即高度小的树合并到高度大的树上 更加平衡
			if(ranks[fx] < ranks[fy]) {
				parents[fx] = fy;
			} else if(ranks[fx] > ranks[fy]) {
				parents[fy] = fx;
			} else {
				// 高度相同
				parents[fx] = fy;
				ranks[fy] += 1;
			}
			size--;
		}
	}

	public int findCircleNum(int[][] isConnected) {
		int n = isConnected.length;
		UnionFind unionFind = new UnionFind(n);
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				if(isConnected[i][j] == 1) {
					unionFind.union(i, j);
				}
			}
		}
		return unionFind.size;
	}
}
