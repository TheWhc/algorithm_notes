package mt._2021_10;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: _02_正则序列
 * @Author: whc
 * @Date: 2021/09/19/22:04
 */
public class _02_正则序列 {

	/**
	 * 思路: 先排序,后对输入序列中排名第i的元素修改为正则序列中的i
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			cnt += Math.abs(arr[i] - (i + 1));
		}

		System.out.println(cnt);
	}
}
