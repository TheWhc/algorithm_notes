package 贪心;

import java.util.Arrays;

/**
 * @ClassName: _455_分发饼干
 * @Author: whc
 * @Date: 2021/04/11/20:48
 */
public class _455_分发饼干 {

	//局部最优就是大饼干喂给胃口大的，充分利用饼干尺寸喂饱一个，
	// 全局最优就是喂饱尽可能多的小孩
	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int res = 0;
		int index = s.length-1; // 饼干下标
		// 遍历孩子
		for (int i = g.length-1; i >= 0; i--) {
			if(index >= 0 && s[index] >= g[i]) {
				res++;
				index--;
			}
		}
		return res;
	}
}
