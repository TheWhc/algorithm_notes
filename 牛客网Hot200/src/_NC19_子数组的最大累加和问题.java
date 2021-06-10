/**
 * @ClassName: _NC19_子数组的最大累加和问题
 * @Author: whc
 * @Date: 2021/02/19/10:03
 */
public class _NC19_子数组的最大累加和问题 {
	public int maxsumofSubarray (int[] arr) {
		if(arr == null || arr.length < 1) {
			return 0;
		}
		// write code here
		// 子数组累加和
		int sum = arr[0];
		// 最大累加和
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			sum += arr[i];
			max = Math.max(sum, max);
			if(sum < 0) {
				sum = 0;
			}
		}

		return max;
	}
}
