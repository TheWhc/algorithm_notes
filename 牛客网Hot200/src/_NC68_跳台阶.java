/**
 * @ClassName: _NC68_跳台阶
 * @Author: whc
 * @Date: 2021/02/19/9:14
 */
public class _NC68_跳台阶 {

	// 递推版, 时间复杂度O(2^n)
	/*public int JumpFloor(int target) {
		return fic(target);
	}

	private int fic(int target) {
		if(target == 1) {
			return 1;
		}
		if(target == 2) {
			return 2;
		}
		return fic(target-1) + fic(target-2);
	}*/

	// 自底向上循环求解, 事件复杂度O(n)
	public int JumpFloor(int target) {
		int a = 1, b = 1;
		for (int i = 1; i < target; i++) {
			// res -> 1 1 2 3 5 6
			// n   -> 0 1 2 3 4 5
			b = a + b;
			a = b - a;
		}
		return b;
	}

}
