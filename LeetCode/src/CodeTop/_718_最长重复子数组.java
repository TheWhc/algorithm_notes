package CodeTop;

/**
 * @ClassName: _718_最长重复子数组
 * @Author: whc
 * @Date: 2021/07/24/9:44
 */
public class _718_最长重复子数组 {

	/*public int findLength(int[] nums1, int[] nums2) {
		int[][] dp = new int[nums2.length + 1][nums1.length + 1];

		int maxLength = 0;

		for (int i = 1; i <= nums2.length; i++) {
			for (int j = 1; j <= nums1.length; j++) {
				if(nums2[i-1] == nums1[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
					maxLength = Math.max(maxLength, dp[i][j]);
				}
			}
		}

		return maxLength;
	}*/

	public int findLength(int[] nums1, int[] nums2) {
		int[] dp = new int[nums1.length + 1];

		int maxLength = 0;
		int leftTop = 0;
		for (int i = 1; i <= nums2.length; i++) {
			for (int j = 1; j <= nums1.length; j++) {
				if(nums2[i-1] == nums1[j-1]) {
					int tmp = dp[j];
					dp[j] = leftTop + 1;
					maxLength = Math.max(maxLength, dp[j]);
					leftTop = tmp;
				} else {
					leftTop = dp[j];
					dp[j] = 0;
				}
			}
			leftTop = 0;
		}
		return maxLength;
	}

	public static void main(String[] args) {
		_718_最长重复子数组 _718_最长重复子数组 = new _718_最长重复子数组();
		_718_最长重复子数组.findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7});
	}
}
