package 待分类;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName: 待分类._146_LRU缓存机制
 * @Author: whc
 * @Date: 2021/03/02/11:41
 */
public class _146_LRU缓存机制 {

	int capacity;
	Map<Integer, Integer> map;
	public _146_LRU缓存机制(int limit) {
		this.capacity = limit;
		this.map = new LinkedHashMap<Integer, Integer>(limit, 0.75f, true) {
			protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
				return map.size() > capacity;
			}
		};
	}

	public int get(int key) {
		if(!map.containsKey(key)) {
			return -1;
		}
		return map.get(key);
	}

	public void put(int key, int value) {
		map.put(key, value);
	}


}
