package 排序;

/**
 * @ClassName: QuickSort
 * @Author: whc
 * @Date: 2021/03/12/12:54
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = new int[]{11,4,5,13,15};
		quicksort(arr, 0, arr.length-1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void quicksort(int[] arr, int left, int right) {
		if(left < right) {
			int mid = partition(arr, left, right);
			quicksort(arr, left, mid-1);
			quicksort(arr, mid+1, right);
		}
	}

	private static int partition(int[] arr, int left, int right) {
		int pivot = arr[left]; // 备份轴点元素

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

	/**
	 *  思路: 快速排序填坑法
	 *  1. 采用分治递归的思想
	 *  2. 从序列中选择一个轴点元素,假设每次选择最左边的元素
	 *  3. 利用pivot将序列分割成2个序列
	 *  	- 小于pivot的元素放在pivot的前面
	 *  	- 大于pivot的元素放在pivot的后面
	 *  	- 等于pivot的元素放哪边都可以
	 *  4. 对2个子序列不断进行2、3步骤,递归直到序列只剩1个元素
	 *
	 *  平均时间: O(nlogn)
	 *          每一层划分时间为O(N)
	 *          平均划分层数为O(logN)
	 *  最好时间：O(nlogn)
	 *
	 *  最坏时间: O(N^2)
	 *  		每一层划分时间为O(N)
	 *  		最大划分层数为O(N)
	 *
	 *  空间复杂度: O(logN) 递归调用
	 *
	 *  稳定性: 不稳定
	 *
	 */
	/*private static void quicksort(int[] arr, int left, int right) {
		if(left < right) {
			int mid = partition(arr, left, right);
			quicksort(arr, left, mid-1);
			quicksort(arr, mid+1, right);
		}
	}

	// 填坑法
	private static int partition(int[] arr, int left, int right) {
		// 备份轴点元素
		int pivot = arr[left];
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
	}*/

}
