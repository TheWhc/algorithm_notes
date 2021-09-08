package CodeTop;

import java.util.Arrays;

/**
 * @ClassName: _16_最接近的三数之和
 * @Author: whc
 * @Date: 2021/09/08/23:12
 */
public class _16_最接近的三数之和 {

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums); // 排序
		int ans = nums[0] + nums[1] + nums[2]; // 初始化

		for (int i = 0; i < nums.length; i++) {
			int left = i + 1;
			int right = nums.length - 1;

			while(left < right) {
				int sum = nums[left] + nums[right] + nums[i];
				if(Math.abs(target - sum) < Math.abs(target - ans)) {
					ans = sum;
				}

				// 左移left,可能会得到更小的ans
				if(sum < target) {
					left++;
				} else if(sum > target) {
					// 右移right,可能会得到更小的ans
					right--;
				} else {
					return ans;
				}
			}
		}

		return ans;
	}

}
