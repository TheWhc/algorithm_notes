package CodeTop;

/**
 * @ClassName: _34_在排序数组中查找元素的第一个和最后一个位置
 * @Author: whc
 * @Date: 2021/07/21/16:38
 */
public class _34_在排序数组中查找元素的第一个和最后一个位置 {

	public int[] searchRange(int[] nums, int target) {
		int len = nums.length;

		if(len == 0) {
			return new int[]{-1,-1};
		}

		int firstPosition = findFirstPosition(nums, target);
		if(firstPosition == -1) {
			return new int[]{-1, -1};
		}

		int lastPosition = findLastPosition(nums, target);
		return new int[]{firstPosition, lastPosition};
	}

	private int findLastPosition(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while(left < right) {
			// 将区间[l,r]划分为了[mid,r]和[l,mid-1],即更新操作为l=mid或者r=mid-1,为了防止死循环,计算mid时要+1
			int mid = left + (right - left + 1) / 2; // 注意这里的+1,取右边
			if(nums[mid] > target) {
				// 往左边逼近
				right = mid - 1;
			} else {
				left = mid;
			}
		}

		return left;
	}

	private int findFirstPosition(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while(left < right) {
			// 将区间[l,r]划分为了[l,mid]和[mid+1,r],即更新操作为r=mid或者l=mid+1,计算mid时不需要+1
			int mid = left + (right - left) / 2;
			if(nums[mid] < target) {
				// 往右边逼近
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		// 返回的时候需要判断一下是不是要查找的元素,因为虽然区间长度为1,但可能不是要查找的数字
		if(nums[left] == target) {
			return left;
		}

		return -1;
	}
}
