package mt._2021_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName: _02_偏爱字母
 * @Author: whc
 * @Date: 2021/09/21/9:07
 */
public class _02_偏爱字母 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		char[] str = br.readLine().trim().toCharArray();
		int maxSum = 0, sum = 0;
		for (int i = 0; i < str.length; i++) {
			if(str[i] == 'E') {
				sum += 1;
			} else {
				sum -= 1;
			}
			maxSum = Math.max(maxSum, sum);
			sum = Math.max(sum, 0);
		}

		System.out.println(maxSum);
	}
}
