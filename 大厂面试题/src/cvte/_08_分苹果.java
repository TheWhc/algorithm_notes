package cvte;

/**
 * @ClassName: _08_分苹果
 * @Author: whc
 * @Date: 2021/10/01/12:13
 */
public class _08_分苹果 {

	/*public static int getApple(int n) {
		if(n == 1) {
			return 8;
		}

		int before = getApple(n-1);
		return before + n;
	}

	public static void main(String[] args) {
		System.out.println(getApple(100));
	}*/

	public static void main(String[] args) {
		int a = 8;
		for (int i = 2; i <= 100; i++) {
			int b = a + i;
			a = b;
		}

		System.out.println(a);
	}
}
