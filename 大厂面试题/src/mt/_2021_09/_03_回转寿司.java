package mt._2021_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName: _03_回转寿司
 * @Author: whc
 * @Date: 2021/09/20/16:23
 */
public class _03_回转寿司 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T > 0) {
			int N = Integer.parseInt(br.readLine().trim());
			String[] params = br.readLine().trim().split(" ");
			int[] value = new int[N];
			int allSum = 0;
			for (int j = 0; j < N; j++) {
				value[j] = Integer.parseInt(params[j]);
				allSum += value[j];
			}

			int max = value[0];
			int min = value[0];
			int dpMax = value[0];
			int dpMin = value[0];
			for (int i = 1; i < N; i++) {
				dpMax = Math.max(value[i], dpMax + value[i]);
				max = Math.max(dpMax, max);
				dpMin = Math.min(value[i], dpMin + value[i]);
				min = Math.min(dpMin, min);
			}
			System.out.println(Math.max(allSum - min, max));
			T--;
		}
	}

}
