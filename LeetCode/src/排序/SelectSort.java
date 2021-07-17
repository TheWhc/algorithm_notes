package 排序;

/**
 * @ClassName: SelectSort
 * @Author: whc
 * @Date: 2021/07/17/9:56
 */
public class SelectSort {

	public static void main(String[] args) {
		int[] array = new int[]{5,1,2,3,4};
		solution(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	/**
	 * 思路： 每次选择最大的值交换到末尾位置
	 * 这里标记每轮最大值的下标就可以了
	 *
	 * 平均时间:O(n^2)
	 * 最坏: O(n^2)
	 * 最好: O(n^2)
	 *
	 * 稳定性： 不稳定
	 */
	public static void solution(int[] arr) {
		for (int i = arr.length - 1; i > 0; i--) {
			// 每次选择最大的数字排到末尾
			int maxIdx = 0;
			for (int j = 1; j <= i; j++) {
				if(arr[j] > arr[maxIdx]) {
					maxIdx = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[maxIdx];
			arr[maxIdx] = temp;
		}
	}
}
