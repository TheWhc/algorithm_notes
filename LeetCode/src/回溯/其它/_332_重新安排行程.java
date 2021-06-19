package 回溯.其它;

import java.util.*;

/**
 * @ClassName: _332_重新安排行程
 * @Author: whc
 * @Date: 2021/06/19/13:55
 */
public class _332_重新安排行程 {

	List<String> res = new ArrayList<>();
	// key:出发机场,  value: key为到达机场, value为航班次数
	Map<String, Map<String, Integer>> map = new HashMap<>();
	public List<String> findItinerary(List<List<String>> tickets) {
		if(tickets == null || tickets.size() == 0) {
			return new ArrayList<>();
		}

		// 例子: ["JFK", "KUL"], ["JFK","NRT"], ["NRT", "JFK"]
		for (List<String> ticket : tickets) {

			// 第二次ticket
			// ticket = ["JFK", "NRT"]
			if(map.containsKey(ticket.get(0))) {
				// 获取到temp,此时内容为{["KUL", 1]}
				Map<String, Integer> temp = map.get(ticket.get(0));
				// 存放"NRT"后, 此时temp内容为{["KUL", 1], ["NRT", 1]}
				temp.put(ticket.get(1), temp.getOrDefault(ticket.get(1), 0) + 1);
				// 重新放入map中
				map.put(ticket.get(0), temp);
			} else {
				// 第一次ticket
				// ticket = ["JFK", "KUL"]
				// 不存在出发机场key时,新创建key, value为TreeMap,按照value的key字母排序
				// "KUL":1
				Map<String, Integer> temp = new TreeMap<>();
				temp.put(ticket.get(1), 1);
				map.put(ticket.get(0), temp);
			}
		}

		// 第一个出发地
		res.add("JFK");
		backtrack(tickets.size());

		return res;
	}

	// ticketNum参数表示有多少个航班(终止条件会用到)
	// 注意终止条件返回boolean,和其它回溯法的返回值不一样
	private boolean backtrack(int ticketNum) {
		if(ticketNum + 1 == res.size()) {
			return true;
		}

		String last = res.get(res.size()-1);
		if(map.containsKey(last)) {
			for (Map.Entry<String, Integer> target : map.get(last).entrySet()) {
				int count = target.getValue();
				// 去重
				if(count > 0) {
					res.add(target.getKey());
					target.setValue(count-1);
					if(backtrack(ticketNum)) {
						return true;
					}
					res.remove(res.size()-1);
					target.setValue(count);
				}
			}
		}

		return false;
	}

}
