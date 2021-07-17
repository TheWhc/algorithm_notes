package 排序;

/**
 * @ClassName: BubbleSort
 * @Author: whc
 * @Date: 2021/03/16/20:19
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] array = new int[]{5,1,2,3,4};
		solution1(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	/**
	 * 思路: 两层遍历,外层轮数,内层比较并交换使得最大值冒出
	 *
	 * 平均时间: O(n^2)
	 * 最坏: O(n^2)
	 * 最好: O(n)
	 *
	 * 稳定性: 稳定
	 *
	 * 空间: O(1)
	 *
	 */
	public static void solution(int[] array) {
		for (int i = array.length - 1; i > 0; i--) {
			for (int j = 1; j <= i; j++) {
				if(array[j] < array[j-1]) {
					int temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
				}
			}
		}
	}

	/**
	 * 优化：序列完全有序,提前终止冒泡排序
	 *
	 * 思路：设置一个哨兵
	 *
	 * 比如: 5 1 2 3 4
	 */
	public static void solution1(int[] array) {
		for (int i = array.length - 1; i > 0; i--) {
			boolean flag = true;
			for (int j = 1; j <= i; j++) {
				if(array[j] < array[j-1]) {
					int temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
					flag = false;
				}
			}
			if(flag) {
				break;
			}
		}
	}




	/*public static void solution(int[] array) {
		int len = array.length;
		for (int i = 0; i < len - 1; i++) {
			for (int j = 1; j < len - i; j++) {
				if(array[j] < array[j-1]) {
					int temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
				}
			}
		}
	}*/
}
