package 待分类;

/**
 * @ClassName: 待分类._88_合并两个有序数组
 * @Author: whc
 * @Date: 2021/03/08/9:45
 */
public class _88_合并两个有序数组 {
	/*public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] res = new int[m + n];
		int i = 0, j = 0, k = 0;
		while (i < m && j < n) {
			if (nums1[i] < nums2[j]) {
				res[k++] = nums1[i++];
			} else {
				res[k++] = nums2[j++];
			}
		}

		while (i < m) {
			res[k++] = nums1[i++];
		}

		while (j < n) {
			res[k++] = nums2[j++];
		}

		for (int l = 0; l < res.length; l++) {
			nums1[l] = res[l];
		}
	}*/

	// 从后往前走
	/*public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int index = m + n - 1;
		m -= 1;
		n -= 1;
		while(n >= 0 && m >= 0) {
			if(nums1[m] > nums2[n]) {
				nums1[index--] = nums1[m--];
			} else {
				nums1[index--] = nums2[n--];
			}
		}

		while(m >= 0) {
			nums1[index--] = nums1[m--];
		}

		while(n >= 0) {
			nums1[index--] = nums2[n--];
		}
	}*/

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = nums1.length-1;
		m -= 1;
		n -= 1;
		while(i >= 0) {
			if(nums2[n] > nums1[m]) {
				nums1[i--] = nums2[n--];
			} else {
				nums1[i--] = nums1[m--];
			}
		}

		while(n >= 0) {
			nums1[i--] = nums2[n--];
		}

		while(m >= 0) {
			nums1[i--] = nums1[m--];
		}
	}

	public static void main(String[] args) {
		int[] nums1 = {0};
		int[] nums2 = {1};
		merge(nums1, 0, nums2, 1);
	}
}
