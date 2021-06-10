package 排序;

/**
 * @ClassName: BubbleSort
 * @Author: whc
 * @Date: 2021/03/16/20:19
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] array = new int[]{5,4,3,2,1};
		solution(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	public static void solution(int[] array) {
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
	}
}
