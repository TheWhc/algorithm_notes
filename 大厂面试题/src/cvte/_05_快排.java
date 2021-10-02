package cvte;

/**
 * @ClassName: _05_快排
 * @Author: whc
 * @Date: 2021/10/01/10:32
 */
public class _05_快排 {

	public static void main(String[] args) {
		int[] nums = new int[]{5,4,3,2,1};
		quickSort(nums, 0, nums.length-1);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

	private static void quickSort(int[] nums, int left, int right) {
		if(left < right) {
			int mid = partition(nums, left, right);
			quickSort(nums, left, mid-1);
			quickSort(nums, mid+1, right);
		}
	}

	private static int partition(int[] nums, int left, int right) {
		int pivot = nums[left];

		while(left < right) {
			while(left < right) {
				if(nums[right] > pivot) {
					right--;
				} else {
					nums[left++] = nums[right];
					break;
				}
			}

			while(left < right) {
				if(nums[left] < pivot) {
					left++;
				} else {
					nums[right--] = nums[left];
					break;
				}
			}
		}

		nums[left] = pivot;
		return left;
	}
}
