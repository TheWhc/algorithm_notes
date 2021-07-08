package 贪心;

import java.util.Arrays;

/**
 * @ClassName: _455_分发饼干
 * @Author: whc
 * @Date: 2021/04/11/20:48
 */
public class _455_分发饼干 {

	/**
	 *  思路：贪心
	 *  1. 对饼干数组和小孩数组进行排序
	 *  2. 局部最优: 大饼干喂给胃口大的,充分利用每一块
	 *     全局最优： 喂饱尽量多的小孩
	 *  3. 遍历小孩数组,从后往前遍历
	 */
	/*public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);

		int res = 0;
		int idx = s.length - 1; // 饼干的下标

		for (int i = g.length - 1; i >= 0; i--) {
			if(idx >= 0 && g[i] <= s[idx]) {
				idx--;
				res++;
			}
		}

		return res;
	}*/

	/**
	 *  思路：贪心
	 *  1. 对饼干数组和小孩数组进行排序
	 *  2. 局部最优: 小饼干喂给胃口小的,充分利用每一块
	 *     全局最优： 喂饱尽量多的小孩
	 *  3. 遍历饼干数组,从前往后
	 */
	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);

		int res = 0;
		int idx = 0; // 小孩数组下标

		for (int i = 0; i < s.length; i++) {
			if(idx < g.length && s[i] >= g[idx]) {
				res++;
				idx++;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		_455_分发饼干 _455_分发饼干 = new _455_分发饼干();
		_455_分发饼干.findContentChildren(new int[]{1,2}, new int[]{1,2,3});
	}
}
