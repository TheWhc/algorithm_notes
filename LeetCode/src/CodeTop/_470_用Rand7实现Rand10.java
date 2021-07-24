package CodeTop;

import java.util.Random;

/**
 * @ClassName: _470_用Rand7实现Rand10
 * @Author: whc
 * @Date: 2021/07/24/11:27
 */
public class _470_用Rand7实现Rand10 {

	/*public int rand10() {

		while(true) {
			// 等概率生成[1,49]
			int num = (rand7() - 1) * 7 + rand7();
			// 在[1,40]中取,即生成rand(40),保证40大于10且是10的倍数
			if(num <= 40) { // 拒绝采样,对于>40的数继续循环获取
				// 返回rand(10)的数
				return num % 10 + 1;
			}
		}
	}*/

	// 优化
	public int rand10() {

		while(true) {
			// 等概率生成[1,49]
			int num = (rand7() - 1) * 7 + rand7();
			// 在[1,40]中取,即生成rand(40),保证40大于10且是10的倍数
			if(num <= 40) { // 拒绝采样,对于>40的数继续循环获取
				// 返回rand(10)的数
				return num % 10 + 1;
			}

			// [1,9]即rand(9)
			int a = num - 40;
			int b = rand7();
			num = (a - 1) * 7 + b; // 生成[1,63]
			if(num <= 60) {
				return num % 10 + 1;
			}

			// [1,3]即rand(3)
			a = num - 60;
			num = (a - 1) * 7 + b; // 生成[1,21]
			if(num <= 20) {
				return num % 10 + 1;
			}
		}
	}

	private int rand7() {
		return new Random().nextInt(7) + 1; // 返回[1,7]随机整数
	}

}
