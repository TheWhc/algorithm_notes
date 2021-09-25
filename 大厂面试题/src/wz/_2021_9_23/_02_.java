package wz._2021_9_23;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName: _02_
 * @Author: whc
 * @Date: 2021/09/22/20:44
 */
public class _02_ {

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
		char preC = arrays[0];
		long sum = 0;
		int i = 0, j = 0;
		Map<Character, int[]> map = new HashMap<>();
		map.put('h', new int[]{0, -1});
		map.put('j', new int[]{1, 0});
		map.put('k', new int[]{-1, 0});
		map.put('l', new int[]{0, 1});

		for (char c : arrays) {
			if(c != preC) {
				sum += x;
			}
			int X = i + map.get(c)[0];
			int Y = j + map.get(c)[1];

			if(X < 0 || X >= m || Y < 0 || Y >= n) {
				sum += y;
			} else {
				if(matrix[X][Y] == -1) {
					sum += y;
				} else {
					sum += Math.max(matrix[i][j], matrix[X][Y]);
					i = X;
					j = Y;
				}
			}

			preC = c;
		}

		System.out.println(sum);
	}
}
