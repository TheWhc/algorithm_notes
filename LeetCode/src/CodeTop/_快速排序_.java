package CodeTop;

/**
 * @ClassName: _快速排序_
 * @Author: whc
 * @Date: 2021/07/20/9:59
 */
public class _快速排序_ {

	/**
	 * 平均时间: O(nlogn)
	 * 最好: O(nlogn)
	 * 最坏: O(n^2)
	 *
	 * 稳定性: 不稳定
	 */
	public static void main(String[] args) {
		_快速排序_ __快速排序_ = new _快速排序_();
		__快速排序_.quickSort(new int[]{5,4,3,10,2});
	}

	public void quickSort(int[] arr) {
		sort(arr, 0, arr.length - 1);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private void sort(int[] arr, int left, int right) {
		if(left < right) {
			int mid = partition(arr, left, right);
			sort(arr, left, mid-1);
			sort(arr, mid+1, right);
		}
	}

	private int partition(int[] arr, int left, int right) {
		int pivot = arr[left];// 备份轴点元素

		while(left < right) {
			while(left < right) {
				if(arr[right] > pivot) {
					right--;
				} else {
					arr[left++] = arr[right];
					break;
				}
			}

			while(left < right) {
				if(arr[left] < pivot) {
					left++;
				} else {
					arr[right--] = arr[left];
					break;
				}
			}
		}

		arr[left] = pivot;
		return left;
	}
}
