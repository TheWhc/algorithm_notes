package 并查集;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: _399_除法求值
 * @Author: whc
 * @Date: 2021/05/18/22:04
 */
public class _399_除法求值 {

	class UnionFind {
		int[] parents;
		// 指向父节点的权值
		double[] weight;

		public UnionFind(int capacity) {
			this.parents = new int[capacity];
			this.weight = new double[capacity];
			for (int i = 0; i < capacity; i++) {
				parents[i] = i;
				weight[i] = 1.0;
			}
		}

		// 路径压缩
		public int find(int x) {
			if(parents[x] == x) return parents[x];
			// 保存原来的父节点值
			int origin = parents[x];
			// 当前结点指向根触点
			parents[x] = find(parents[x]);
			// 维护当前结点的权值  有向边的权值 * 原父节点指向根节点的权值
			weight[x] *= weight[origin];
			return parents[x];
		}

		public void union(int x, int y, double value) {
			int fx = find(x);
			int fy = find(y);
			if(fx == fy) return;

			parents[fx] = fy;
			// 合并权值
			// a/b=3 d/c=4 a/d=6 b/c=?
			weight[fx] = value * weight[y] / weight[x];
		}

		public double isConnected(Integer x, Integer y) {
			int fx = find(x);
			int fy = find(y);
			if(fx == fy) {
				return weight[x] / weight[y];
			} else {
				return -1.0;
			}
		}
	}

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		int equationsSize = equations.size();
		UnionFind unionFind = new UnionFind(2 * equationsSize);
		// 预处理,将变量的值与id进行映射,使得并查集底层使用数组实现,方便编码
		HashMap<String, Integer> map = new HashMap<>(2 * equationsSize);
		int id = 0;
		for (int i = 0; i < equationsSize; i++) {
			List<String> equation = equations.get(i);
			String var1 = equation.get(0);
			String var2 = equation.get(1);
			if(!map.containsKey(var1)) {
				map.put(var1, id);
				id++;
			}
			if(!map.containsKey(var2)) {
				map.put(var2, id);
				id++;
			}

			unionFind.union(map.get(var1), map.get(var2), values[i]);
		}

		// 做查询
		int querySize = queries.size();
		double[] res = new double[querySize];
		for (int i = 0; i < querySize; i++) {
			String var1 = queries.get(i).get(0);
			String var2 = queries.get(i).get(1);

			Integer id1 = map.get(var1);
			Integer id2 = map.get(var2);

			if(id1 == null || id2 == null) {
				res[i] = -1.0;
			} else {
				res[i] = unionFind.isConnected(id1, id2);
			}
		}

		return res;
	}

}
