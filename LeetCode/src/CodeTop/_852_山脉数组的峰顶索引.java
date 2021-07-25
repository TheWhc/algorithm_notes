package CodeTop;

/**
 * @ClassName: _852_山脉数组的峰顶索引
 * @Author: whc
 * @Date: 2021/07/25/20:51
 */
public class _852_山脉数组的峰顶索引 {

	/*public int peakIndexInMountainArray(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		while(left < right) {
			int mid = left + (right - left + 1) / 2;
			if(arr[mid-1] < arr[mid]) {
				left = mid;
			} else {
				right = mid - 1;
			}
		}

		return left;
	}*/

	public int peakIndexInMountainArray(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		while(left < right) {
			int mid = left + (right - left) / 2;
			if(arr[mid] > arr[mid+1]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return left;
	}
}
