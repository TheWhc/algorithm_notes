package mt._2021_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @ClassName: _02_晋级人数
 * @Author: whc
 * @Date: 2021/09/20/16:13
 */
public class _02_晋级人数 {

	/**
	 * 思路：
	 * 1. 最大值为0,则输出0
	 * 2. 最大值不为0,计算分数第x大的人得了多少分,作为baseline
	 * 	2.1 baseline == 0, 则找到第一个分数不为0人,分数大于等于它的都能晋级
	 * 	2.2 baseline != 0, 检查有多少个并列,吧这些人也一起晋级
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] params = br.readLine().trim().split(" ");
		int n = Integer.parseInt(params[0]);
		int x = Integer.parseInt(params[1]);
		params = br.readLine().trim().split(" ");
		int[] score = new int[n];
		for (int i = 0; i < n; i++) {
			score[i] = Integer.parseInt(params[i]);
		}

		Arrays.sort(score);
		if(score[n-1] == 0) {
			System.out.println(0);
		} else {
			int res = 0;
			int baseline = score[n - x];
			for (int i = 0; i < n; i++) {
				if(score[i] == 0) {
					continue;
				} else if(score[i] == baseline) {
					res = n - i;
					break;
				}
			}
			System.out.println(res);
		}
	}
}
