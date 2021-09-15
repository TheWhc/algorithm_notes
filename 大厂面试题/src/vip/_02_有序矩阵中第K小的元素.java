package vip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: _02_有序矩阵中第K小的元素
 * @Author: whc
 * @Date: 2021/09/15/20:30
 */
public class _02_有序矩阵中第K小的元素 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();
		int[][] matrix = new int[n][n];
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = sc.nextInt();
				res.add(matrix[i][j]);
			}
		}

		Collections.sort(res);
		System.out.println(res.get(k-1));

	}

}
