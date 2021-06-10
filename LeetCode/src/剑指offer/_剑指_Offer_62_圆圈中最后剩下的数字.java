package 剑指offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName: 剑指offer._剑指_Offer_62_圆圈中最后剩下的数字
 * @Author: whc
 * @Date: 2021/04/02/9:36
 */
public class _剑指_Offer_62_圆圈中最后剩下的数字 {

	/*public int lastRemaining(int n, int m) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		int idx = 0;
		while(n > 1) {
			idx = (idx + m -1) % n;
			list.remove(idx);
			n--;
		}

		return list.get(0);
	}*/

	/**
	 *  思路: 模拟
	 *  1. 将数据添加到ArrayList中,模拟链条循环
	 *  2. 下一个删除位置下标是(idx + m - 1 ) % n, 减1的原因是idx在删除一个元素后,从下一个元素的当前位置出发,所以仅需要加上 m-1步即可
	 *     %n表示求模剩下元素大小
	 */
	public int lastRemaining(int n, int m) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		int idx = 0;
		while(n > 1) {
			// idx = 2 % 5 = 2; idx = 4 % 4 = 0; idx = 2 % 3 = 2; idx = 4 % 2 = 0
			idx = (idx + m - 1) % n;
			list.remove(idx);
			n--;
		}

		return list.get(0);
	}

}
