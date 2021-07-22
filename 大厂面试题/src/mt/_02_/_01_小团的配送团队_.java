package mt._02_;

import java.util.*;

/**
 * @ClassName: _01_小团的配送团队_
 * @Author: whc
 * @Date: 2021/07/22/17:25
 */

public class _01_小团的配送团队_ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		UnionFind union = new UnionFind(n);
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			union.union(a, b);
		}

		// 打印小区的数量
		System.out.println(union.count);

		// 按照订单号从小到大排序
		// key为根触点,即属于同一个连通分量的订单号集合
		TreeMap<Integer, ArrayList<Integer>> region = new TreeMap<>();
		ArrayList<Integer> temp;
		for (int i = 1; i <= n; i++) {
			if(region.containsKey(union.parent[i])) {
				temp = region.get(union.parent[i]);
			} else {
				temp = new ArrayList<>();
			}
			// 属于同一个小区的订单号
			temp.add(i);
			region.put(union.parent[i], temp);
		}

		// 打印小区订单号
		for (int id : region.keySet()) {
			temp = region.get(id);
			for (int j = 0; j < temp.size(); j++) {
				System.out.print(temp.get(j) + " ");
			}
			System.out.println();
		}
	}

}


class UnionFind {
	public int[] parent;
	public int count;

	public UnionFind(int n) {
		// 初始化连通分量为n个,即订单数量
		count = n;
		parent = new int[n+1];

		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
	}

	public int find(int x) {
		if(x == parent[x]) {
			return x;
		}

		// 路径压缩
		return parent[x] = find(parent[x]);
	}

	public void union(int x, int y) {
		int fx = find(x);
		int fy = find(y);

		if(fx == fy) {
			return;
		}

		// 将节点编号大的合并到节点编号小的下面
		// Quick Find,注意这里是将所有同一个连通分量的节点指向新的编号小的节点
		if(fx < fy) {
			for (int i = 0; i < parent.length; i++) {
				if(parent[i] == fy) {
					parent[i] = fx;
				}
			}
		} else {
			for (int i = 0; i < parent.length; i++) {
				if(parent[i] == fx) {
					parent[i] = fy;
				}
			}
		}
		// 每合并一次,连通分量就减1,即小区数量减1
		count--;
	}

}



