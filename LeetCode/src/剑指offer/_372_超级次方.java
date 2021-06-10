package 剑指offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: _372_超级次方
 * @Author: whc
 * @Date: 2021/05/25/11:15
 */
public class _372_超级次方 {

	public static void main(String[] args) {
		_372_超级次方 a = new _372_超级次方();
		a.superPow(2147483647, new int[]{2,0,0});
	}

	/**
	 *  快速幂
	 *  比如a^[2,3,7,8]
	 *     a^2378
	 *  = (a^237)^10 * a^8
	 *  = ((a^23)^10 * a^7) * a^8
	 *  = ((a^2)^10 * a^3 * a^7) * a^8
	 *  = a^0......
	 */
	public int superPow(int a, int[] b) {
		Deque<Integer> queue = new ArrayDeque<>();
		for (int i : b) {
			queue.add(i);
		}
		// 重载该方法
		return superPow(a, queue);
	}

	private int superPow(int a, Deque<Integer> queue) {
		// [2,3,7,8]从后往前依次出栈,为空时,为0次幂
		if(queue.isEmpty()) {
			return 1;
		}
		// 比如a^[2,3,7,8] = a^2378
		// 第一步(a^237)^10 * a^8
		int lastBit = queue.removeLast();
		// a^8
		int part1 = myPow(a, lastBit);
		// (a^237)^10
		int part2 = myPow(superPow(a, queue), 10);

		return (part1 * part2) % 1337;
	}

	private int myPow(int a, int b) {
		if(b == 0) {
			return 1;
		}

		// 奇数
		a %= 1337;
		if(b % 2 == 1) {
			return (a * myPow(a, b-1)) % 1337;
		} else {
			return myPow(a*a, b/2);
		}
	}
}
