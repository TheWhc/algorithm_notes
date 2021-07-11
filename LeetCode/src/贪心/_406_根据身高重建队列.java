package 贪心;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: _406_根据身高重建队列
 * @Author: whc
 * @Date: 2021/04/13/12:12
 */
public class _406_根据身高重建队列 {

	// 时间O(nlogn + n^3)
	// 空间O(n)
	/*public int[][] reconstructQueue(int[][] people) {
		// 2个维度 h 和 k
		// 先从一个维度出发
		// 先确定k还是h, 应该先确定h  身高从大到小排序,如果h相同,则按k从小到大排序
		Arrays.sort(people, (o1, o2) -> {
			if (o1[0] != o2[0]) {
				return Integer.compare(o2[0], o1[0]);
			} else {
				return Integer.compare(o1[1], o2[1]);
			}
		});

		// 局部最优: 优先按身高的people的k来插入,插入操作过后的people满足队列属性
		// 全局最优: 最后都做完插入操作,整个队列满足队列属性
		List<int[]> res = new ArrayList<>();
		for (int i = 0; i < people.length; i++) {
			res.add(people[i][1], people[i]);
		}

		return res.toArray(new int[res.size()][]);
	}*/


	/**
	 * 思路: 贪心
	 * 两个维度的问题, 身高和人头数
	 * 所以先固定一个维度, 应该先按身高进行从大到小的排序, 后面再按照每个元素的k作为插入的下标重新插入到前面重排序的数组中,因为此时k下标刚好就对应前面有多少人头
	 *
	 * 局部最优: 优先按身高的people的k来插入,插入操作过后的people满足队列属性
	 * 全局最优: 最后都做完插入操作,整个队列满足队列属性
	 */
	public int[][] reconstructQueue(int[][] people) {

		Arrays.sort(people, (o1, o2) -> {
			// 先按照身高进行从大到小排序,如果身高相同,则按照k进行从小到大排序
			if(o1[0] != o2[0]) {
				return o2[0] - o1[0];
			} else {
				return o1[1] - o2[1];
			}
		});

		List<int[]> res = new ArrayList<>();
		for (int i = 0; i < people.length; i++) {
			// 按照k的下标进行添加元素
			res.add(people[i][1], people[i]);
		}

		return res.toArray(new int[res.size()][]);
	}
}
