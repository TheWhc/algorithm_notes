package mt._2021_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: _01_糕点
 * @Author: whc
 * @Date: 2021/09/20/11:44
 */
public class _01_糕点 {

	/**
	 * 思路: 分情况讨论
	 * 1. 已经烤好的蛋糕,重量最小的比a轻,重量最大的比b大,不满足条件
	 * 2. 已经烤好的蛋糕重量在区间[a,b]间:
	 * 		2.1 刚好是a,b两个重量,则满足
	 * 		2.2 是a或者b其中一个重量,并且还能烤的蛋糕数不少于1
	 * 		2.3 a或者b重量都不满足,则需要烤的蛋糕数不少于2
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		String[] params;
		while((line = br.readLine()) != null) {
			params = line.trim().split(" ");
			int n = Integer.parseInt(params[0]);
			int m = Integer.parseInt(params[1]);
			int a = Integer.parseInt(params[2]);
			int b = Integer.parseInt(params[3]);
			Set<Integer> set = new HashSet<>();
			params = br.readLine().trim().split(" ");
			// 已经烤好的蛋糕重量
			int[] weight = new int[m];
			for (int i = 0; i < m; i++) {
				weight[i] = Integer.parseInt(params[i]);
				set.add(weight[i]);
			}
			Arrays.sort(weight);
			// 保证a < b
			if(a > b) {
				int temp = a;
				a = b;
				b = temp;
			}
			if(weight[0] < a || weight[weight.length-1] > b) {
				System.out.println("NO");
			} else {
				if(set.contains(a) && set.contains(b)) {
					System.out.println("YES");
				} else if((set.contains(a) || set.contains(b)) && (n - m) >= 1) {
					System.out.println("YES");
				} else if((n - m) >= 2) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}
}
