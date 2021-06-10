import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _NC61_两数之和
 * @Author: whc
 * @Date: 2021/02/19/9:39
 */
public class _NC61_两数之和 {
	public int[] twoSum (int[] numbers, int target) {
		// write code here
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			if(map.containsKey(target - numbers[i])) {
				return new int[]{map.get(target - numbers[i]) + 1, i + 1};
			}
			map.put(numbers[i], i);
		}
		return new int[0];
	}

}
