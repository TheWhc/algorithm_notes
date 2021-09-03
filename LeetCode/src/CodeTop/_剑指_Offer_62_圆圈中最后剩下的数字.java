package CodeTop;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _剑指_Offer_62_圆圈中最后剩下的数字
 * @Author: whc
 * @Date: 2021/08/20/16:45
 */
public class _剑指_Offer_62_圆圈中最后剩下的数字 {

	public int lastRemaining(int n, int m) {

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}

		int idx = 0;
		while(n > 1) {
			idx = (idx + (m - 1)) % n;
			list.remove(idx);
			n--;
		}

		return list.get(0);
	}

}
