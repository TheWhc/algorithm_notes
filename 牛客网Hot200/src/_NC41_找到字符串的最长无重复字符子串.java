import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _NC41_找到字符串的最长无重复字符子串
 * @Author: whc
 * @Date: 2021/02/19/11:57
 */
public class _NC41_找到字符串的最长无重复字符子串 {
	public int maxLength (int[] arr) {
		// write code here
		if(arr == null || arr.length == 0) {
			return 0;
		}

		int maxLength = 0;
		int begin = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int end = 0; end < arr.length; end++) {
			if(map.containsKey(arr[end])) {
				begin = end;
			}
			map.put(arr[end], end);
			maxLength = Math.max(maxLength, end-begin+1);
		}
		return maxLength;
	}
}
