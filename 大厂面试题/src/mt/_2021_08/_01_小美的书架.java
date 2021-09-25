package mt._2021_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName: _01_小美的书架
 * @Author: whc
 * @Date: 2021/09/21/12:00
 */
public class _01_小美的书架 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] params = br.readLine().trim().split(" ");
		int n = Integer.parseInt(params[0]); // 书架n行
		int m = Integer.parseInt(params[1]); // 书本编号m
		int q = Integer.parseInt(params[2]); // q个操作
		int op, x, y;
		boolean[] locked = new boolean[10001]; // 表示第i行书架是否被上锁
		boolean[] hasBook = new boolean[10001]; // 表示第i本书是否在小团手上
		// 记录第i本书在第j行书架上
		int[] pos = new int[10001];
		for (int i = 0; i < q; i++) {
			params = br.readLine().trim().split(" ");
			// 放置的过程
			if(params.length == 3) {
				op = Integer.parseInt(params[0]);
				x = Integer.parseInt(params[1]);
				y = Integer.parseInt(params[2]);
				if(hasBook[x]) {
					continue;
				}

				if(locked[y]) {
					continue;
				}

				if(pos[x] != 0 && locked[pos[x]]) {
					continue;
				}

				pos[x] = y;

			} else {
				op = Integer.parseInt(params[0]);
				if(op == 2) {
					// 直接加锁
					y = Integer.parseInt(params[1]);
					locked[y] = true;
				} else if(op == 3) {
					// 释放锁
					y = Integer.parseInt(params[1]);
					locked[y] = false;
				} else if(op == 4) {
					// 借书
					x = Integer.parseInt(params[1]);
					// 如果x已经在书架上且该层书架没有上锁,就直接输出
					if(pos[x] != 0 && !locked[pos[x]]) {
						System.out.println(pos[x]);
						pos[x] = 0;
						hasBook[x] = true;
					} else {
						System.out.println(-1);
					}
				} else {
					// 还书
					x = Integer.parseInt(params[1]);
					if(!hasBook[x]) {
						continue;
					}
					hasBook[x] = false;
				}
			}
		}
	}
}
