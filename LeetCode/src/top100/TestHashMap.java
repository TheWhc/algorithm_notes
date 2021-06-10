package top100;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: TestHashMap
 * @Author: whc
 * @Date: 2021/05/08/17:45
 */
public class TestHashMap {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		set.add(null);
		set.add(1);
		set.add(null);
		System.out.println(set.size());
	}
}
