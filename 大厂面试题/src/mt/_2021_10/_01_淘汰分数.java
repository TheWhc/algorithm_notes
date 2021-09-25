package mt._2021_10;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: _01_淘汰分数
 * @Author: whc
 * @Date: 2021/09/19/20:49
 */
public class _01_淘汰分数 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int[] score = new int[n];
		for (int i = 0; i < n; i++) {
			score[i] = sc.nextInt();
		}

		Arrays.sort(score);

		/**
		 *
		 * 最低分数 -> 过线的人多 -> 使用人数限制最大值y作为过线人数 -> 判断剩下的人是否在[x,y]区间
		 * 		如果不在:
		 * 			- 人数大于y,则输出-1
		 * 			- 人数小于x,则输出分数最低的第x个人,即score[x-1]
		 * 		如果在:
		 * 			- 直接返回
		 */
		// 未过线人数
		int notOk = n - y;
		if(notOk > y) {
			System.out.println(-1);
		} else if(notOk >= x && notOk <= y) {
			System.out.println(score[notOk - 1]);
		} else {
			System.out.println(score[x-1]);
		}
	}
}
