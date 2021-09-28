package CodeTop;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName: _146_LRU缓存机制
 * @Author: whc
 * @Date: 2021/07/20/1:04
 */
public class _146_LRU缓存机制 {

	/*class Node {
		int k, v;
		Node l, r;
		Node(int _k, int _v) {
			this.k = _k;
			this.v = _v;
		}
	}

	int n;
	Node head, tail;
	Map<Integer, Node> map;

	public _146_LRU缓存机制(int capacity) {
		n = capacity;
		this.map = new HashMap<>();
		head = new Node(-1, -1);
		tail = new Node(-1, -1);
		head.r = tail;
		tail.l = head;
	}

	public int get(int key) {
		if(map.containsKey(key)) {
			Node node = map.get(key);
			refresh(node);
			return node.v;
		}
		return -1;
	}

	public void put(int key, int value) {
		Node node = null;
		if(map.containsKey(key)) {
			node = map.get(key);
			node.v = value;
		} else {
			if(map.size() == n) {
				map.remove(tail.l.k);
				delete(tail.l);
			}
			node = new Node(key, value);
			map.put(key, node);
		}
		refresh(node);
	}

	private void refresh(Node node) {
		delete(node);
		node.r = head.r;
		node.l = head;
		head.r.l = node;
		head.r = node;
	}

	private void delete(Node node) {
		if(node.l != null) {
			node.l.r = node.r;
			node.r.l = node.l;
		}
	}*/

	private int limit;
	private Map<Integer, Integer> map = new LinkedHashMap<>();

	public _146_LRU缓存机制(int capacity) {
		this.limit = capacity;
	}

	public int get(int key) {
		if(!map.containsKey(key)) {
			return -1;
		}

		int val = map.remove(key);
		map.put(key, val);
		return val;
	}

	public void put(int key, int value) {
		if(map.containsKey(key)) {
			map.remove(key);
		}

		map.put(key, value);
		// 超过缓存大小,删除最近最少使用的key
		if(map.size() > limit) {
			map.remove(map.entrySet().iterator().next().getKey());
		}
	}


}
