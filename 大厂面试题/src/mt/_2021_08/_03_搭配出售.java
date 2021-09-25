package mt._2021_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * @ClassName: _03_搭配出售
 * @Author: whc
 * @Date: 2021/09/21/10:20
 */
public class _03_搭配出售 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] params = br.readLine().trim().split(" ");
		int a = Integer.parseInt(params[0]);
		int b = Integer.parseInt(params[1]);
		int c = Integer.parseInt(params[2]);
		int d = Integer.parseInt(params[3]);
		int e = Integer.parseInt(params[4]);
		int f = Integer.parseInt(params[5]);
		int g = Integer.parseInt(params[6]);

		// 大根堆
		PriorityQueue<int[]> queue = new PriorityQueue<>(3, (o1, o2) -> {
			return Integer.compare(o2[1], o1[1]);
		});

		queue.offer(new int[]{a, e});
		queue.offer(new int[]{b, f});
		queue.offer(new int[]{c, g});

		long money = 0;
		
		while(!queue.isEmpty() && d > 0) {
			int[] temp = queue.poll();
			// 衬衫数量 > 剩余的衬衫数量
			if(temp[0] > d) {
				money += (long)d * temp[1];
				d = 0;
			} else {
				money += (long)temp[0] * temp[1];
				d -= temp[0];
			}
		}

		System.out.println(money);
	}
}
