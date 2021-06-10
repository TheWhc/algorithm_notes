package 待分类;

/**
 * @ClassName: 待分类._169_多数元素
 * @Author: whc
 * @Date: 2021/03/20/14:47
 */
public class _169_多数元素 {
	/*public int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			if(map.containsKey(num)) {
				int count = map.get(num);
				count++;
				map.put(num, count);
			} else {
				map.put(num, 1);
			}
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() > nums.length / 2) {
				return entry.getKey();
			}
		}
		return -1;
	}*/

	// 摩尔投票法
	public int majorityElement(int[] nums) {
		int x = 0; // 众数
		int vote = 0; // 票数统计
		for (int num : nums) {
			if(vote == 0) {
				x = num;
			}
			if(num == x) {
				vote++;
			} else {
				vote--;
			}
		}
		return x;
	}

	public static void main(String[] args) {
		new _169_多数元素().majorityElement(new int[]{3,2,3});
	}
}
