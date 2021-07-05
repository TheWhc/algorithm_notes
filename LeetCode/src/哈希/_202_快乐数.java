package 哈希;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: _202_快乐数
 * @Author: whc
 * @Date: 2021/07/05/11:14
 */
public class _202_快乐数 {

	/**
	 * 思路: Set记录sum的值,判断是不是有重复出现过
	 *
	 * 1. 设置set集合
	 * 2. 一直循环, 计算各个位置上的数字平方和
	 * 3. 如果和sum == 1, 返回true
	 *    如果和sum在集合中, 则说明重复计算了, 返回false
	 */
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		while(true) {
			int sum = getSum(n);
			if(sum == 1) {
				return true;
			}
			if(set.contains(sum)) {
				return false;
			}
			set.add(sum);
			n = sum;
		}
	}

	// 计算各个位置的数字平方和
	private int getSum(int n) {
		int sum = 0;
		while(n > 0) {
			int num = n % 10;
			sum += num * num;
			n /= 10;
		}
		return sum;
	}
}
