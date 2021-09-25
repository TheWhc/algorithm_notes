package wz._2021_9_10;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName: _02_
 * @Author: whc
 * @Date: 2021/09/22/20:44
 */
public class _02_ {

	/**
	 * 题目描述:
	 * 求矩阵中走路的最大代价
	 *
	 * 思路:直接模拟
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();

		int[][] matrix = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}

		char[] arrays = sc.next().toCharArray();
		char pre = arrays[0];
		long sum = 0;
		int i = 0, j = 0;
		Map<Character, int[]> map = new HashMap<>();
		map.put('h', new int[]{0, -1});
		map.put('j', new int[]{1, 0});
		map.put('k', new int[]{-1, 0});
		map.put('l', new int[]{0, 1});

		for (char c : arrays) {
			if(c != pre) {
				sum += x;
			}
			int newX = i + map.get(c)[0];
			int newY = j + map.get(c)[1];

			if(newX < 0 || newX >= m || newY < 0 || newY >= n) {
				sum += y;
			} else {
				if(matrix[newX][newY] == -1) {
					sum += y;
				} else {
					sum += Math.max(matrix[i][j], matrix[newX][newY]);
					i = newX;
					j = newY;
				}
			}

			pre = c;
		}

		System.out.println(sum);
	}
}
