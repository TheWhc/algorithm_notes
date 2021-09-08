package CodeTop;

/**
 * @ClassName: _剑指_Offer_11_旋转数组的最小数字
 * @Author: whc
 * @Date: 2021/09/08/21:33
 */
public class _剑指_Offer_11_旋转数组的最小数字 {

	public int minArray(int[] numbers) {
		int left = 0;
		int right = numbers.length - 1;
		while(left < right) {
			int mid = left + (right - left) / 2;
			if(numbers[mid] > numbers[right]) {
				left = mid + 1;
			} else if(numbers[mid] < numbers[right]){
				right = mid;
			} else {
				// 重复元素
				right--;
			}
		}

		return numbers[left];
	}
}
