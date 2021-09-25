package mt._2021_10;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @ClassName: _03_公司食堂
 * @Author: whc
 * @Date: 2021/09/19/22:55
 */
public class _03_公司食堂 {

	/**
	 * 思路：使用三个小顶堆,分别存储当前人数0,1,2的三种桌子的桌号,即为pq0,pq1,pq2
	 *
	 * 男员工:
	 * 	1. 先尝试坐人数为1的桌子,该桌子人数变成了2,等价于:
	 * 		- 将pq1的堆顶弹出,同时推入pq2
	 * 	2. 如果没有人数为1的桌子,等价于:
	 * 		- pq1为空,就去坐人数为0的桌子,等价于:
	 * 		- 将pq0的堆顶弹出,同时推入pq1
	 *
	 * 女员工：
	 * 	1. 先尝试坐人数为0的桌子,该桌子人数变成了1,等价于:
	 * 		- 将pq0的堆顶弹出,同时推入pq1
	 * 	2. 如果没有人数为0的桌子,等价于:
	 * 		- pq0为空,就去坐人数为1的桌子,等价于：
	 * 		- 将pq1的堆顶弹出,同时推入pq2
	 *
	 * 	因为桌号存储在优先队列中,由于是最小堆,所以堆顶的桌子号总是最小的,保证每个人有多个选择时优先选择最左边的桌子
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(reader.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(reader.readLine()); // N张桌子
			String tables = reader.readLine(); // 用餐人数字符串
			int M = Integer.parseInt(reader.readLine()); // M个人排队
			String enters = reader.readLine(); // 性别字符串
			int[] res = solve(tables, enters);

			for (int r : res) {
				writer.write(Integer.toString(r));
				writer.newLine();
			}
		}

		writer.flush();
	}

	private static int[] solve(String tables, String enters) {
		List<PriorityQueue<Integer>> pqs = new ArrayList<>(3);
		pqs.add(new PriorityQueue<>());
		pqs.add(new PriorityQueue<>());
		pqs.add(new PriorityQueue<>());

		for (int i = 0; i < tables.length(); i++) {
			pqs.get(tables.charAt(i) - '0').add(i);
		}
		int[] res = new int[enters.length()];
		for (int i = 0; i < enters.length(); i++) {
			int table;
			if(enters.charAt(i) == 'M') {
				// 男性
				if(!pqs.get(1).isEmpty()) {
					// 先尝试坐人数为1的桌子
					table = pqs.get(1).poll();
					pqs.get(2).add(table);
				} else {
					// 否则坐人数为0的桌子
					table = pqs.get(0).poll();
					pqs.get(1).add(table);
				}
			} else {
				// 女性
				if(!pqs.get(0).isEmpty()) {
					// 先尝试坐人数为0的桌子
					table = pqs.get(0).poll();
					pqs.get(1).add(table);
				} else {
					// 尝试坐人数为1的桌子
					table = pqs.get(1).poll();
					pqs.get(2).add(table);
				}
			}
			res[i] = table + 1;
		}
		return res;
	}
}
