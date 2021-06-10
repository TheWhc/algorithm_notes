package 剑指offer;

/**
 * @ClassName: 剑指offer._剑指_Offer_11_旋转数组的最小数字
 * @Author: whc
 * @Date: 2021/04/02/15:04
 */
public class _剑指_Offer_11_旋转数组的最小数字 {

	/*public int minArray(int[] numbers) {
		int left = 0;
		int right = numbers.length-1;
		while(left < right) {
			int mid = (left + right) >> 1;
			if(numbers[mid] < numbers[right]) {
				right = mid;
			} else if(numbers[mid] > numbers[right]) {
				left = mid + 1;
			} else {
				right--;
			}
		}
		return numbers[left];
	}*/


	/**
	 * 思路: 二分查找
	 * 将中间元素mid和右边元素right相比较,缩小搜索的范围
	 * numbers[mid] < numbers[right], 则 right = mid
	 * numbers[mid] > numbers[right], 则 left = mid + 1
	 * numbers[mid] = numbers[right], 则 right--
	 */
	public int minArray(int[] numbers) {
		int left = 0;
		int right = numbers.length-1;
		while(left < right) {
			int mid = (left + right) >>> 1;
			if(numbers[mid] < numbers[right]) {
				right = mid;
			} else if(numbers[mid] > numbers[right]) {
				left = mid + 1;
			} else {
				right--;
			}
		}

		return numbers[left];
	}

}
