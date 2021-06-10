package 待分类;

import java.util.Arrays;

/**
 * @ClassName: 待分类._4_寻找两个正序数组的中位数
 * @Author: whc
 * @UpdateUser: whc
 * @Version: 0.0.1
 * @Date: 2021/01/07/20:18
 */
public class _4_寻找两个正序数组的中位数 {
	/*public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] nums = new int[nums1.length + nums2.length];
		for (int i = 0; i < nums1.length; i++) {
			nums[i] = nums1[i];
		}
		for (int i = 0; i < nums2.length; i++) {
			nums[nums1.length + i] = nums[2];
		}
		Arrays.sort(nums);
		if(nums.length % 2 == 0) {
			return (nums[nums.length / 2] + nums[nums.length / 2 - 1] ) / 2.0;
		} else {
			return nums[nums.length / 2];
		}
	}*/

	/*public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int count = 0;
		int m = nums1.length;
		int n = nums2.length;
		int[] nums = new int[m + n];
		int i = 0, j = 0;
		if(m == 0) {
			if(n % 2 == 0) {
				return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
			} else {
				return nums2[n / 2];
			}
		}

		if(n == 0) {
			if (m % 2 == 0) {
				return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
			} else {
				return nums1[m / 2];
			}
		}

		while(count != (m + n)) {
			if(i == m) {
				while(j < n) {
					nums[count++] = nums2[j++];
				}
				break;
			}
			if(j == n) {
				while(i < m) {
					nums[count++] = nums1[i++];
				}
				break;
			}

			if(nums1[i] < nums2[j]) {
				nums[count++] = nums1[i++];
			} else {
				nums[count++] = nums2[j++];
			}
		}

		if(count % 2 == 0) {
			return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
		} else {
			return nums[count / 2];
		}
	}*/

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		int total = len1 + len2;
		//如果A数组长度+B数组长度total是奇数，则找total/2+1小的元素即为中位数
		if(total % 2 == 1) {
			int midIndex = total / 2 + 1;
			return getKthElement(nums1, nums2, midIndex);
		}
		//否则，找total/2，total/2+1这两个元素
		else {
			int midIndex_1 = total / 2;
			int midIndex_2 = total / 2 + 1;
			double a = getKthElement(nums1, nums2, midIndex_1);
			double b = getKthElement(nums1, nums2, midIndex_2);
			return (a + b) / 2.0D;
		}
	}

	private static int getKthElement(int[] nums1, int[] nums2, int k) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		int index1 = 0;
		int index2 = 0;
		while(true) {
			//边界情况，当index1越界时，直接返回nums2的第k小元素
			if(index1 == len1) {
				return nums2[index2 + k - 1];
			}
			//边界情况，当index2越界时，直接返回nums1的第k小元素
			if(index2 == len2) {
				return nums1[index1 + k - 1];
			}
			//边界情况，k等于1时，返回nums1第一个元素和nums2第一个元素较小者
			if(k == 1) {
				return Math.min(nums1[index1], nums2[index2]);
			}
			// 第k/2大元素相对坐标
			int newIndex1 = Math.min(index1 + k / 2 - 1, len1 - 1);
			int newIndex2 = Math.min(index2 + k / 2 - 1, len2 - 1);
			int pivot1 = nums1[newIndex1];
			int pivot2 = nums2[newIndex2];
			//比较nums1[k/2-1]和nums2[k/2-1]
			//如果nums1的小，则忽略掉nums1[0] - nums1[k/2-1]这些元素
			//再更新 k，k 要减去忽略掉的那些元素，index1也要更新，待下轮使用
			if(pivot1 <= pivot2) {
				k -= (newIndex1 - index1 + 1);
				index1 = newIndex1 + 1;
			}
			//如果nums2的小，则忽略掉nums2[0] - nums2[k/2-1]这些元素
			//再更新 k，k 要减去忽略掉的那些元素，index2也要更新，待下轮使用
			else {
				k -= (newIndex2 - index2 + 1);
				index2 = newIndex2 + 1;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums1 = new int[]{1,2,4,9};
		int[] nums2 = new int[]{1,2,3,4,5,6,7,8};
		findMedianSortedArrays(nums1,nums2);
	}
}
