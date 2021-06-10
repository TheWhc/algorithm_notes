import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: _NC93_设置LRU缓存结构
 * @Author: whc
 * @Date: 2021/01/24/14:52
 */
public class _NC93_设置LRU缓存结构 {
	/**
	 * lru design
	 * @param operators int整型二维数组 the ops
	 * @param k int整型 the k
	 * @return int整型一维数组
	 */
	// 缓冲区大小
	private int limit;
	private Map<Integer, Integer> map;
	public int[] LRU (int[][] operators, int k) {
		// write code here
		this.limit = k;
		this.map = new LinkedHashMap<>();
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<operators.length; i++) {
			int[] temp = operators[i];
			if(temp.length == 3) {
				// 表示set操作
				set(temp[1], temp[2]);
			} else {
				// 表示get操作
				list.add(get(temp[1]));
			}
		}
		int[] res = new int[list.size()];
		int count = 0;
		for(int x : list) {
			res[count++] = x;
		}
		return res;
	}

	private int get(int key) {
		if(!map.containsKey(key))
			return -1;
		Integer value = map.remove(key);
		map.put(key, value);
		return value;
	}

	private void set(int key, int value) {
		if(map.containsKey(key)) {
			map.remove(key);
			map.put(key, value);
			return;
		}
		map.put(key, value);
		if(map.size() > limit) {
			// 超过缓冲区大小,删除最久没有使用的数据,即迭代器的第一个
			map.remove(map.entrySet().iterator().next().getKey());
		}
	}

	public static void main(String[] args) {
		int[][] array = {{1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}};
		new _NC93_设置LRU缓存结构().LRU(array, 3);
	}
}
