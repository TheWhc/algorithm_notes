package wz._01_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @ClassName: _01_磁铁
 * @Author: whc
 * @Date: 2021/09/21/21:17
 */
public class _01_磁铁 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		String[] params = br.readLine().trim().split(" ");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(params[i]);
		}
		Arrays.sort(arr);

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
